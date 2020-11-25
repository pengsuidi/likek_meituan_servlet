package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.MovieDao;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.*;
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
import java.util.List;

@WebServlet("/GetPersonCommentsServlet")
public class GetPersonCommentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Result result = new Result();

        String userid = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
        try {
            UserDao OrdersDao = new UserDao();
            List<UserComment> list = OrdersDao.GetPersonComments(userid);
            result.setCode(Config.STATUS_SUCCESS);
            result.setMessage("网络请求成功");
            result.setData(list);
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
