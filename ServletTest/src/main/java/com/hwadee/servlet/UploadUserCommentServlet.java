package com.hwadee.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hwadee.dao.UserDao;
import com.hwadee.entity.Result;
import com.hwadee.entity.UserComment;
import com.hwadee.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * 登陆接口定义类
 */
@WebServlet("/UserCommentServlet")
public class UploadUserCommentServlet extends HttpServlet {
    private String FOLDER = "/root/CommentImg/";
//    private String FOLDER = "C:\\Users\\Administrator\\Desktop\\pic\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Result result = new Result();

            System.out.println("在此处处理 LoginServlet 的 GET/POST 请求");

            //获取参数
            String img64 = req.getParameter(Config.REQUEST_PARAMETER_CommentIMG_BASE64);
            System.out.println("img64:"+img64);
            String shopid = req.getParameter(Config.REQUEST_PARAMETER_SHOPID);
            String userid = req.getParameter(Config.REQUEST_PARAMETER_USER_ID);
            String comment = req.getParameter(Config.REQUEST_PARAMETER_COMMENT);
            String grade = req.getParameter(Config.REQUEST_PARAMETER_GRADE);
            //String user_pic_addr = req.getParameter(Config.REQUEST_PARAMETER_USER_PIC_ADDR);
            //String user_pic = req.getParameter(Config.REQUEST_PARAMETER_USER_PIC);
            String user_pic = null;
            String user_pic_addr = null;
            //把image_64转化为图片保存在文件夹中,把路径保存在数据库中;
            //对二进制数组进行编码

            String name = "_" + shopid + "_" + userid + "_" + System.currentTimeMillis();
            String comment_img_addr;
            String comment_img = null;
            String path =FOLDER; //所创建文件目录
            File f = new File(path);
            if(!f.exists()){
                f.mkdirs(); //创建目录
            }
            if(img64!=null&&img64.trim()!=null)
            {
                savePicture(img64,name);
                comment_img_addr = FOLDER + name + ".jpg";
                System.out.println("没有图片!");
            }
            else {
                comment_img_addr = null;
                System.out.println("有图片!");
            }

            System.out.println("!!path:" + user_pic_addr);

            boolean isUpload = new UserDao().upload_comment(grade, user_pic_addr, user_pic, shopid, userid, comment,comment_img,comment_img_addr);
            System.out.println(shopid + isUpload + "asd" + isUpload);

            //检测数据是否异常
            if (isUpload) {
                result.setCode(Config.STATUS_SUCCESS);
                result.setMessage("上传成功");
                //TODO 返回响应：注册成功
                System.out.println("qweqweJSON -> " + JSONObject.toJSONString(result));
            } else {
                result.setCode(Config.STATUS_FAILURE);
                result.setMessage("上传失败");

                //TODO 返回响应：注册失败
                System.err.println("zxczxcJSON -> " + JSONObject.toJSONString(result));
            }
            //更新shop_info里面的评分
            UserDao commentDao = new UserDao();
            List<UserComment> comments = commentDao.selectCommentList(shopid);
            Float new_grade=0.0f;
            for(int i=0;i<comments.size();i++)
            {
                new_grade+=Float.parseFloat(comments.get(i).getGrade());
            }
            new_grade/=comments.size();
            Boolean isupdate=commentDao.Update_shop_grade(shopid,new_grade.toString());
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
