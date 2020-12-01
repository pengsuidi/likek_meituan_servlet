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

@WebServlet("/selectBirthday")
public class ShowBirthdayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 SelectServlet 的 GET/POST 请求");

            String uid=req.getParameter("uid");

            System.out.println("uid:"+uid);
            //检测数据是否异常
            if ( uid == null || uid.trim().length() == 0) {
                //TODO 返回响应：数据为空；不继续操作
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("id为空");

                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;

            }

            User user = new UserDao().selectOne(uid);

            if (user == null) {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("id输入错误，请重试");

                //TODO 返回响应：登陆失败
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                //TODO 返回响应：登陆成功；保存用户信息
                req.getSession().setAttribute("user", user);

                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage(user.getUbirthday().toString());
                result.setData(user);
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
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
