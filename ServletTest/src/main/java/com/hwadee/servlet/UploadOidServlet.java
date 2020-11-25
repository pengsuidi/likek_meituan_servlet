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


@WebServlet("/UploadOidServlet")
public class UploadOidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String new_oid=req.getParameter(Config.REQUEST_PARAMETER_NEWOID);
            String old_oid=req.getParameter(Config.REQUEST_PARAMETER_OLDOID);


            System.out.println("new_oid:"+new_oid);
            //检测数据是否异常
            if (new_oid == null || new_oid.trim().length() == 0) {
                //TODO 返回响应：数据为空；不继续操作
                result.setCode(Config.STATUS_ERROR);
                result.setMessage("昵称或名字为空");

                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                resp.getWriter().write(JSONObject.toJSONString(result));
                return;

            }

            boolean isUpdate = new UserDao().updateOid(old_oid,new_oid);

            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("成功");
                // System.out.println("User:" + user.toString());
                // System.err.println("修改成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

                // resp.getWriter().write("修改成功");
            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("失败");
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
