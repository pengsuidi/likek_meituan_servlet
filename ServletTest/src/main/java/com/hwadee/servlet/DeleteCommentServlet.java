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

@WebServlet("/DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Result result = new Result();
        //获取参数
        String comment_addr = req.getParameter(Config.REQUEST_PARAMETER_COMMENT_ADDR);
        if (comment_addr == null || comment_addr.trim().length() == 0 ) {
            result.setCode(Config.STATUS_ERROR);
            result.setMessage("地址为空");
            //TODO 将响应规范对象 转换为 JSON 格式字符串回传；在客户端解析 JSON 格式字符串，并构建实体对象
            System.err.println("JSON -> " + JSONObject.toJSONString(result));
            resp.getWriter().write(JSONObject.toJSONString(result));
            return;
        }
        boolean isMinus=true;
//            boolean isMinus= new UserDao().deleteComment(comment_addr);
        if (isMinus)
        {
            result.setCode(Config.STATUS_SUCCESS);
            result.setMessage("删除成功");
            //TODO 返回响应：注册成功
            System.out.println("JSON -> " + JSONObject.toJSONString(result));
        } else {
            result.setCode(Config.STATUS_FAILURE);
            result.setMessage("删除失败");

            //TODO 返回响应：注册失败
            System.err.println("JSON -> " + JSONObject.toJSONString(result));
        }

        resp.getWriter().write(JSONObject.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }


}
