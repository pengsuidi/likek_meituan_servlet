package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.User;
import com.hwadee.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String unickname=req.getParameter("unickname");
            String uname=req.getParameter("uname");

            //检测数据是否异常
            if (unickname == null || unickname.trim().length() == 0 || uname == null || uname.trim().length() == 0) {
                //TODO 返回响应：数据为空；不继续操作
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("昵称或id为空");

                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;

            }
            User user = new User();
            user.setUnickname(unickname);
            user.setUname(uname);

            boolean isUpdate = new UserDao().update(user);
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
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
