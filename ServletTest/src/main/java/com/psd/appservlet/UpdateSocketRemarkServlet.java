package com.psd.appservlet;

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


@WebServlet("/UpdateSocketRemarkServlet")
public class UpdateSocketRemarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String socket_id=req.getParameter(Config.REQUEST_PARAMETER_SOCKET_ID);
            String remark=req.getParameter(Config.REQUEST_PARAMETER_SOCKET_REMARK);

            boolean isUpload = new UserDao().UpldateSocketRemark(remark,socket_id);

            if (isUpload) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("更新socket_info成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("更新socket_info失败");
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
