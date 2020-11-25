package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.util.Config;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet("/buyfood")
public class BuyFoodServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();
            System.out.println("在此处处理 LoginServlet 的 GET/POST 请求");

            //获取参数
            String food_name = req.getParameter(Config.REQUEST_PARAMETER_FOOD_NAME);
            String food_price = req.getParameter(Config.REQUEST_PARAMETER_FOOD_PRICE);

            String user_id = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String shop_name = req.getParameter(Config.REQUEST_PARAMETER_SHOPNAME);
            //检测数据是否异常
//            if (uname == null || uname.trim().length() == 0 || upassword == null || upassword.trim().length() == 0) {
            if (food_name == null || food_name.trim().length() == 0 ) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("用户名或密码为空");

                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }

            boolean isRegistered = new UserDao().BuyFood(food_name,food_price,user_id,shop_name);
            if (isRegistered)
            {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("失败");

                //TODO 返回响应：注册失败
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
            }

            resp.getWriter().write(JSONObject.toJSONString(result));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

}