package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.User;
import com.hwadee.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/GetUserInfo")
public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();
            System.out.println("在此处处理 LoginServlet 的 GET/POST 请求");

            //获取参数
            String id = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);

            if (id == null || id.trim().length() == 0 ) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("用户名或密码为空");

                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }

            User user = new UserDao().GetUserInfo(id);
            if (user!=null) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("成功");
                user.setUser_img(image2byte(user.getUser_img_addr()));
                result.setData(user);
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
    public static byte[] image2byte(String path) {
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
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }


}
