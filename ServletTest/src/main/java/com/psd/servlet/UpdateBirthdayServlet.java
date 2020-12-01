package com.psd.servlet;

import com.alibaba.fastjson.JSONObject;
import com.psd.dao.UserDao;
import com.psd.entity.Result;
import com.psd.entity.User;
import com.psd.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/updateBirthday")
public class UpdateBirthdayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String ubirthday=req.getParameter("ubirthday");
            String uid=req.getParameter("uid");
            System.out.println("newBirth:"+ubirthday);
            //检测数据是否异常
            if (ubirthday == null || ubirthday.trim().length() == 0 || uid == null || uid.trim().length() == 0) {
                //TODO 返回响应：数据为空；不继续操作
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("生日为空");

                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;

            }
            User user = new User();
            SimpleDateFormat ft=new SimpleDateFormat(ubirthday);

            user.setUid(Integer.parseInt(uid));

            boolean isUpdate = new UserDao().updateBirthday(uid,ubirthday);
            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("修改成功");
                // System.out.println("User:" + user.toString());
                // System.err.println("修改成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

                // resp.getWriter().write("修改成功");
            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("修改失败");
                //TODO 返回响应：注册失败
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                // resp.getWriter().write("修改失败");
            }

            resp.getWriter().write(JSONObject.toJSONString(result));
        }catch (ClassNotFoundException  e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
