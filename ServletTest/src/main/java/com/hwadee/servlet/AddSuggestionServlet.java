package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.Suggestion;
import com.hwadee.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addSuggestion")
public class AddSuggestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();

            System.out.println("在此处处理 addSuggetionServlet 的 GET/POST 请求");

            //获取参数
            String content = req.getParameter("content");
           // String id=req.getParameter("id");

            //检测数据是否异常
            if (content == null || content.trim().length() == 0 ) {
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("反馈为空");

                //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;
            }


            Suggestion suggestion = new Suggestion();
            suggestion.setContent(content);
            //suggestion.setId(id);
            boolean isAdd = new UserDao().addsuggestion(suggestion);

            if (isAdd ) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("发送成功");

                //TODO 返回响应：登陆失败
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
            } else {
                //TODO 返回响应：登陆成功；保存用户信息
              //  req.getSession().setAttribute("suggestion", suggestion);

                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("发送失败");

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
