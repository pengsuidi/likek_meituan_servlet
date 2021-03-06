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


@WebServlet("/UploadPaymentServlet")
public class UploadPaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String food_name=req.getParameter(Config.REQUEST_PARAMETER_FOOD_NAME);
            String shop_name=req.getParameter(Config.REQUEST_PARAMETER_SHOPNAME);
            String food_price=req.getParameter(Config.REQUEST_PARAMETER_FOOD_PRICE);
            String total_price=req.getParameter(Config.REQUEST_PARAMETER_TOTAL_PRICE);
            String oid=req.getParameter(Config.REQUEST_PARAMETER_OID);
            String user_id=req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String shop_id=req.getParameter(Config.REQUEST_PARAMETER_SHOPID);


            boolean isUpdate = new UserDao().updatePayment(food_name,food_price,total_price,oid,user_id,shop_id,shop_name);
            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("更新payment成功");
                // System.out.println("User:" + user.toString());
                // System.err.println("修改成功");
                //TODO 返回响应：注册成功
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

                // resp.getWriter().write("修改成功");
            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("更新payment失败");
                result.setData(food_name+food_price+total_price+oid+user_id+shop_id);
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
