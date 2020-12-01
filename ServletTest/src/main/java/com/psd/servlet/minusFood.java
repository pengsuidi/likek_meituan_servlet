package com.psd.servlet;

import com.alibaba.fastjson.JSONObject;
import com.psd.dao.UserDao;
import com.psd.entity.Result;
import com.psd.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/minusFood")
public class minusFood extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();
            //获取参数
            String food_name = req.getParameter(Config.REQUEST_PARAMETER_FOOD_NAME);
            String user_id = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            if (user_id == null || user_id.trim().length() == 0 ) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("用户名或密码为空");
                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }

            boolean isMinus= new UserDao().minusFood(food_name,user_id);
            if (isMinus)
            {
                result.setCode(Config.STATUS_DELETE_FAVOURITE_SUCCESS);
                result.setMessage("取消食品成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("取消食品失败");

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


}
