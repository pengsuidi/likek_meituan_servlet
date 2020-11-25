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


@WebServlet("/initPaypassword")
public class InsertBuyerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String userid=req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String paypassword=req.getParameter("paypassword");
            System.out.println("userid:-----!!!!!"+userid+"pass:"+paypassword);

            boolean isUpdate = new UserDao().insertBuyer(Integer.parseInt(userid),paypassword);

            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("更新user成功");
                // System.out.println("User:" + user.toString());
                // System.err.println("修改成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

                // resp.getWriter().write("修改成功");
            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("更新user失败");
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
