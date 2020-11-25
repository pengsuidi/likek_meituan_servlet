package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.User;
import com.hwadee.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/UPLOAD_FOOD_MENU")
public class UploadFoodMenuServlet extends HttpServlet {
    private String FOLDER = "/root/FoodImg/";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");

            String food_name=req.getParameter(Config.REQUEST_PARAMETER_FOOD_NAME);
            String food_price=req.getParameter(Config.REQUEST_PARAMETER_FOOD_PRICE);
            String shop_id=req.getParameter(Config.REQUEST_PARAMETER_SHOPID);
            String food_description=req.getParameter(Config.REQUEST_PARAMETER_FOOD_DESCRIPTION);
            String img64=req.getParameter(Config.REQUEST_PARAMETER_FOOD_IMG_64);
            String food_type=req.getParameter(Config.REQUEST_PARAMETER_FOOD_TYPE);

            String food_img_addr=null;

            String name = "food:"+"_" + shop_id  + "_" + System.currentTimeMillis();
            String path =FOLDER; //所创建文件目录
            File f = new File(path);
            if(!f.exists()){
                f.mkdirs(); //创建目录
            }
            if(img64!=null&&img64.trim()!=null)
            {
                savePicture(img64,name);
                food_img_addr = FOLDER + name + ".jpg";
                System.out.println("没有图片!");
            }
            else {
                food_img_addr = null;
                System.out.println("有图片!");
            }


            boolean isUpdate = new UserDao().Upload_food_menu(food_name,food_description,food_price,food_type,food_img_addr,shop_id);

            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("更新food_menu成功");
                System.out.println("JSON -> " + JSONObject.toJSONString(result));
                System.err.println("修改成功!");
            } else {

                 System.err.println("修改失败!");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("更新food_menu失败");
                System.err.println("JSON -> " + JSONObject.toJSONString(result));
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
    public static byte[] image2byte(String path) {
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
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    public void savePicture(String head_photo, String name) {
//        BASE64Decoder decoder = new BASE64Decoder();

        FileOutputStream output = null;
        File file = new File(FOLDER + name + ".jpg");
        try {


            byte[] bytes1 = Base64.decode(head_photo);
            output = new FileOutputStream(file);


            for (int i = 0; i < bytes1.length; i++) {
                output.write(bytes1[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
