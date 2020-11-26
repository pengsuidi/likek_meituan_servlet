# likek_meituan_servlet
仿美团的后端java

配置环境:



本项目使用的ide是intellij idea,连接的数据库是mysql,使用servlet进行与android数据交互

需要配置java web的环境,需要购买云服务器,配置tomcat,绑定云端数据库:

    https://blog.csdn.net/qq_42764468/article/details/100513233

    javaweb,mysql:https://blog.csdn.net/wx_15323880413/article/details/108506048

    javaweb:https://developer.aliyun.com/article/673825

安装mysql可能的问题:

     https://blog.csdn.net/aiyowei1106/article/details/88703746

需要在Config文件中修改:

    JDBC_URL = "jdbc:mysql://你的云服务器IP:3306/你的数据库名字?useUnicode=true&characterEncoding=UTF-8";
  
    public static final String JDBC_USER = "你注册mysql的名字";

    public static final String JDBC_PASSWORD = "你注册mysql的密码";

