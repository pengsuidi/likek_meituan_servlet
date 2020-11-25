package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploadFavourite")
public class uploadFavouriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();
            //获取参数
            String shop_id = req.getParameter(Config.REQUEST_PARAMETER_SHOPID);
            String user_id = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String shop_name = req.getParameter(Config.REQUEST_PARAMETER_SHOPNAME);
            if (shop_id == null || shop_id.trim().length() == 0 ) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("用户名或密码为空");
                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }

            boolean isFavourite= new UserDao().uploadFavouriteShop(shop_id,shop_name,user_id);
            if (isFavourite)
            {
                result.setCode(Config.STATUS_UPLOAD_FAVOURITE_SUCCESS);
                result.setMessage("收藏成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("收藏失败");

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
