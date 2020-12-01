package com.psd.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL JDBC 操作工具类，封装 MySQL 操作的增删改查及其他方法
 * <p>
 * 1.注册 JDBC 驱动
 * 2.获取 MySQL Connection
 * 3.构建 Statement（PrepareStatement）
 * 4.操作 增删改查
 * 5.处理操作结果
 * 6.关闭 Statement、Connection
 */
public class JDBCUtil {

    public JDBCUtil() throws ClassNotFoundException {
        Class.forName(Config.JDBC_DRIVER);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Config.JDBC_URL, Config.JDBC_USER, Config.JDBC_PASSWORD);
    }


    /**
     * 增删改 的共性操作
     *
     * @param sql     要操作的 SQL 语句
     * @param objects 预编译的 SQL 语句中的占位符填充元素
     * @return
     */
    public boolean execute(String sql, Object... objects) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                //填充占位符元素
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1, objects[i]);
                }
                System.err.println("1232123");
                return preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("asdasdasd");
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 如果是想直接传递实体对象，并自动进行属性构建，可使用以下方式
     * 未完善，需要自行补足
     *
     * @param sql
     * @param object
     * @return
     */
    public boolean insert(String sql, Object object) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                //填充占位符元素
                //动态获取 SQL 插入数据的列
                String temp = sql.split(" ")[2];
                if (temp.contains("(")) {
                    //如果 SQL 语句插入的列是显示写入的，可直接获取
                    //insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)
                    String[] columns = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")")).split(",");
                    for (int i = 0; i < columns.length; i++) {
                        //通过反射的方式，获取列名对应对象中的属性值
                        Field field = object.getClass().getDeclaredField(columns[i]);
                        field.setAccessible(true);
                        Object o = field.get(object);

                        preparedStatement.setObject(i + 1, o);
                    }
                } else {
                    //如果 SQL 语句插入的列是隐式的，需要间接获取
                    //TODO 根据表名（temp）查询表结构 select * from "temp" limit 0,1
                }


//                for (int i = 0; i < objects.length; i++) {
//                    preparedStatement.setObject(i + 1, objects[i]);
//                }

                return preparedStatement.executeUpdate() > 0;
            }
        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    // select * from muser where uname=? and upassword=?
    // select * from tmovies where mid=?
    public <T> T selectOne(Class<T> clazz, String sql, Object... objects) {
        //获取 连接对象
        try (Connection connection = getConnection()) {
            //预编译 SQL
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                //填充占位符元素
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1, objects[i]);
                }

                ResultSet resultSet = preparedStatement.executeQuery();
                //解析数据，并填充对象
                if (resultSet.next()) {//检测是否有数据，有数据返回为 true
                    return getT(clazz, resultSet);
                }

                return null;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> List<T> selectList(Class<T> clazz, String sql, Object... objects) {
        List<T> list = new ArrayList<>();
        //获取 连接对象
        try (Connection connection = getConnection()) {
            //预编译 SQL
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                //填充占位符元素
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1, objects[i]);
                }

                ResultSet resultSet = preparedStatement.executeQuery();
                //解析数据，并填充对象
                while (resultSet.next()) {
                    T t = getT(clazz, resultSet);

                    list.add(t);
                }
                return list;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return list;
        }
    }


    /**
     * 通过解析 ResultSet 的数据内容，构建实体并返回
     *
     * @param clazz     构建的实体的类型
     * @param resultSet 包含数据的 ResultSet 对象（也就是已经移动指针指向具体数据行的对象）
     * @param <T>
     * @return
     */
    public <T> T getT(Class<T> clazz, ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException, NoSuchFieldException {
        //获取 T 对应的对象；实例化对象 T
        T t = clazz.newInstance();

        //根据 ResultSet 中的数据项，为 对象 t 设置参数
        //通过 ResultSet 的元数据，获取所有查询的列信息
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            Object columnValue = resultSet.getObject(columnName);
            //resultSet.getObject(i);

//            if (columnValue == null) columnValue = "";

            //获取参数的对象
            Field field = clazz.getDeclaredField(columnName);
            field.setAccessible(true);
            field.set(t, columnValue);
        }

        return t;
    }

}
