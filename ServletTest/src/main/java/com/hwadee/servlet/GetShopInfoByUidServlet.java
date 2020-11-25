package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.ShopInfoBuy;
import com.hwadee.entity.Shop_Info;
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

/**
 * 登陆接口定义类
 */
@WebServlet("/GetShopInfoByUid")
public class GetShopInfoByUidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();

            System.out.println("在此处处理 LoginServlet 的 GET/POST 请求");

            //获取参数
            String userid = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);

            System.out.println(userid);
            System.out.println("GetShopInfoByUid:");
            //检测数据是否异常
            if (userid == null || userid.trim().length() == 0) {
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
                return;
            }
            List<Shop_Info> shopList = new UserDao().GetShopInfoByUid(userid);

            if (shopList == null) {

                System.err.println("空值JSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("成功!!");
                for(int i=0;i<shopList.size();i++)
                {
                    shopList.get(i).setShop_image(image2byte(shopList.get(i).getShop_image_addr()));
                }

                result.setData(shopList);


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
    public static byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }
}
