package com.psd.servlet;

import com.alibaba.fastjson.JSONObject;
import com.psd.dao.UserDao;
import com.psd.entity.*;
import com.psd.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetShoppingcarServlet")
public class GetShoppingcarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Result result = new Result();

        String userid = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);


        System.out.println("---------userid:"+userid);
        try {
            UserDao OrdersDao = new UserDao();
            List<ShoppingcarFood> ShoppingcarFoodList = OrdersDao.selectOrderesFoodList(userid);
            result.setCode(Config.STATUS_SUCCESS);
            result.setMessage("网络请求成功");
            result.setData(ShoppingcarFoodList);
            System.out.println("abc:"+JSONObject.toJSONString(result));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //TODO 异常响应
            result.setCode(Config.STATUS_ERROR);
            result.setMessage(e.getMessage());
        } finally {
            resp.getWriter().write(JSONObject.toJSONString(result));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }


}
