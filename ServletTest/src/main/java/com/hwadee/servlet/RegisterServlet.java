package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.User;
import com.hwadee.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private String FOLDER = "/root/UserImg/";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();
            System.out.println("在此处处理 LoginServlet 的 GET/POST 请求");

            //获取参数
            String uname = req.getParameter(Config.REQUEST_PARAMETER_USERNAME);
            String unickname = req.getParameter(Config.REQUEST_PARAMETER_NICKNAME);
            String upassword = req.getParameter(Config.REQUEST_PARAMETER_PASSWORD);
            String img64 = req.getParameter(Config.REQUEST_PARAMETER_UserIMG_BASE64);
            //检测数据是否异常
            if (uname == null || uname.trim().length() == 0 || upassword == null || upassword.trim().length() == 0) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("用户名或密码为空");

                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }
            String name = "_" + uname  + "_" + System.currentTimeMillis();
            String path =FOLDER; //所创建文件目录
            File f = new File(path);
            if(!f.exists()){
                f.mkdirs(); //创建目录
            }
            savePicture(img64,name);


            String user_img_addr = FOLDER + name + ".jpg";


            User user = new User();

            user.setUname(uname);
            user.setUpassword(upassword);
            user.setUnickname(unickname == null || unickname.length() == 0 ? "" : unickname);
            user.setUser_img_addr(user_img_addr);
            boolean isRegistered = new UserDao().register(user);
            if (isRegistered) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("注册成功");

                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("注册失败");

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
    public void savePicture(String head_photo, String name) {
//        BASE64Decoder decoder = new BASE64Decoder();

        FileOutputStream output = null;
        File file = new File(FOLDER + name + ".jpg");
        try {


            byte[] bytes1 = Base64.decode(head_photo);
            output = new FileOutputStream(file);
            for (int i = 0; i < bytes1.length; i++) {
                output.write(bytes1[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
