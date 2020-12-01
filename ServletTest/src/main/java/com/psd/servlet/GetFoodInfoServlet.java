package com.psd.servlet;

import com.alibaba.fastjson.JSONObject;
import com.psd.dao.UserDao;
import com.psd.entity.Food_Menu;
import com.psd.entity.Result;
import com.psd.util.Config;

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

@WebServlet("/GetFoodInfoServlet")
public class GetFoodInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Result result = new Result();

        String shopid = req.getParameter(Config.REQUEST_PARAMETER_SHOPID);

        try {
            UserDao foodDao = new UserDao();


            List<Food_Menu> foodMenuList = foodDao.selectList(shopid);

            result.setCode(Config.STATUS_SUCCESS);
            result.setMessage("网络请求成功");
            for(int i=0;i<foodMenuList.size();i++)
            {
                foodMenuList.get(i).setFood_image(image2byte(foodMenuList.get(i).getFood_image_addr()));
            }
            result.setData(foodMenuList);
            System.out.println("result:----"+JSONObject.toJSONString(result));
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
