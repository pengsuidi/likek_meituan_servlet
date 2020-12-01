package com.psd.servlet;

import com.alibaba.fastjson.JSONObject;
import com.psd.dao.UserDao;
import com.psd.entity.Result;
import com.psd.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/UPLOAD_ShopInfo")
public class UploadShopInfoServlet extends HttpServlet {
    private String FOLDER = "/root/img/";
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try{

            Result result = new Result();

            System.out.println("在此处处理 UpdateServlet 的 GET/POST 请求");


            String shop_name=req.getParameter(Config.REQUEST_PARAMETER_SHOPNAME);
            String shop_type=req.getParameter(Config.REQUEST_PARAMETER_SHOPTYPE);
            String img64=req.getParameter(Config.REQUEST_PARAMETER_SHOPIMG_BASE64);
            String user_id=req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String shop_img_addr=null;

            String name = "_" + user_id + "_" + shop_name + "_" + System.currentTimeMillis();
            String path =FOLDER; //所创建文件目录
            File f = new File(path);
            if(!f.exists()){
                f.mkdirs(); //创建目录
            }
            if(img64!=null&&img64.trim()!=null)
            {
                savePicture(img64,name);
                shop_img_addr = FOLDER + name + ".jpg";
                System.out.println("没有图片!");
            }
            else {
                shop_img_addr = null;
                System.out.println("有图片!");
            }


            boolean isUpdate = new UserDao().Update_shop_info(shop_name,shop_img_addr,user_id,shop_type);

            if (isUpdate) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("更新shop_info成功");
                System.out.println("JSON -> " + JSONObject.toJSONString(result));

                // resp.getWriter().write("修改成功");
            } else {
                // System.err.println("修改失败");
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("更新shop_info失败");
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
