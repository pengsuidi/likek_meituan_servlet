package com.hwadee.dao;

import com.hwadee.entity.*;
import com.hwadee.util.JDBCUtil;

import java.util.List;

public class
UserDao {

    /**
     * 使用 JDBC 连接数据库，并对数据库进行操作，得到响应数据结果
     */

    public User selectPayPassword(int uid)throws ClassNotFoundException{
        return new JDBCUtil().selectOne(User.class, "select * from user where uid=?",uid);

    }
    public SellerInfo JudgeIfSeller(String userid)throws ClassNotFoundException{
        return new JDBCUtil().selectOne(SellerInfo.class, "select * from seller_info where user_id=?",userid);

    }
    public List<SellerInfo> GetSellerInfo(String userid)throws ClassNotFoundException{
        return new JDBCUtil().selectList(SellerInfo.class, "select * from seller_info where user_id=?",userid);

    }
    public boolean updatePayPassword(User buyer) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set pay_password=? where uid=?", buyer.getPay_password(),buyer.getUid());
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean update(User user) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set unickname=? where uid=?", user.getUnickname(),user.getUid());
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean UpdateShop(User user) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set unickname=? where uid=?", user.getUnickname(),user.getUid());
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }


    public boolean updateBirthday(String userid, String date) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set ubirthday=? where uid=?", date,userid);
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }

    public boolean updateNickname(String uid,String uname) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set unickname=? where uid=?", uname,uid);
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean updateOid(String oldoid,String newoid) throws ClassNotFoundException {
        return new JDBCUtil().execute("update totaloid set oid=? where oid=?", newoid,oldoid);
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean updatePayment(String food_name,String food_price,String total_price,String oid,String user_id,String shop_id,String shop_name)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into payment(shop_id,food_name,shop_name,food_price,total_price,oid,user_id)" +
                " values(?,?,?,?,?,?,?)",shop_id, food_name,shop_name,food_price,total_price,oid,user_id);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean Upload_socket_info(String socket_id)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into socket_info(socket_id)" +
                " values(?)",socket_id);


    }
    public boolean Update_socket_image64(String socket_id,String image64_addr)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("update socket_info set image64_addr = ?  where socket_id=?",
                image64_addr,socket_id);


    }
    public boolean Upload_food_menu(String food_name,String food_description,String food_price,String food_type,String food_image_addr,String shop_id)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into food_menu(food_name,food_description,food_price,food_type,food_image_addr,shop_id)" +
                " values(?,?,?,?,?,?)",food_name, food_description,food_price,food_type,food_image_addr,shop_id);


    }
    public boolean Update_shop_info(String shop_name,String shop_image_addr,String user_id,String shop_type)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into shop_info(shop_name,shop_image_addr,user_id,shop_type)" +
                " values(?,?,?,?)",shop_name, shop_image_addr,user_id,shop_type);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean Update_shop_grade(String shop_id,String new_grade)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("update shop_info set grade=? where shop_id=?"
                ,new_grade, shop_id);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean UploadUserImg(String userid,String user_img_addr)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set user_img_addr=? where uid=?"
                ,user_img_addr, userid);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean UpldateSocketRemark(String remark,String socket_id)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("update socket_info set remark=? where socket_id=?"
                ,remark,socket_id);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean BecomeSeller(String user_id)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into seller_info(user_id)" +
                " values(?)", user_id);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }
    public boolean insertBuyer(int user_id,String paypassword)
            throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set pay_password=?  where uid=?",
                paypassword ,user_id);

        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }

    public boolean updatePassword(User user) throws ClassNotFoundException {
        return new JDBCUtil().execute("update user set upassword=? where uid=?", user.getUpassword(),user.getUid());
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);

    }

    public User selectOne(String uid)throws ClassNotFoundException{
        return new JDBCUtil().selectOne(User.class, "select * from user where uid=?",uid);
    }
    public TotalOid getOID()throws ClassNotFoundException{
        return new JDBCUtil().selectOne(TotalOid.class, "select * from totaloid");
    }

    public boolean addsuggestion(Suggestion suggestion) throws ClassNotFoundException {
        return new JDBCUtil().execute("insert into suggestion(content) values(?)", suggestion.getSuggestion());}
    //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);








    public boolean upload_comment(String grade, String user_pic_addr, String user_pic, String shopid,
                                  String userid, String comment,String comment_img,String comment_img_addr)
            throws ClassNotFoundException {
        return new JDBCUtil().execute
                ("insert into user_comment(user_pic_addr,user_pic,new_comment,shop_id,user_id,grade,comment_img,comment_img_addr)" +
                        "values(?,?,?,?,?,?,?,?)", user_pic_addr, user_pic, comment, shopid, userid, grade,comment_img,comment_img_addr);

    }

    public User login(String name, String pass) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(User.class, "select * from user where uname=? and upassword=?", name, pass);
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }

    public boolean register(User user) throws ClassNotFoundException {
//        return new JDBCUtil().insert("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);
        return new JDBCUtil().execute("insert into user(uname,unickname,upassword,pay_password,user_img_addr) values(?,?,?,?,?)", user.getUname(), user.getUnickname(), user.getUpassword(),"123",user.getUser_img_addr());
        //return new JDBCUtil().register("insert into muser(uname,unickname,usex,upassword) values(?,?,?,?)", user);
    }

    public List<Shop_Info> GetShopInfoByUid(String userid) throws ClassNotFoundException {
        return new JDBCUtil().selectList(Shop_Info.class, "select * from shop_info where user_id=?", userid);
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }

    public ShopInfoBuy getCommentShopInfo(String shopid) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(ShopInfoBuy.class, "select * from shop where shop_id=?", shopid);
    }
    public User GetUserInfo(String userid) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(User.class, "select * from user where uid=?", userid);
    }
    public User getPaypassword(String userid) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(User.class, "select * from user where uid=?", userid);
    }
    //    public Shop selectShopid(String shop_name) throws ClassNotFoundException {
//        return new JDBCUtil().selectOne(Shop.class, "select * from shop where shop_name=?",shop_name );
//        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
//    }
    public FavouriteShop isFavourite(String name, String user_id) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(FavouriteShop.class, "select * from user_favorite_shop where shop_id=? and user_id =?", name, user_id);
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }

    public List<Food_Menu> selectList(String shopid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(Food_Menu.class,
                        "select * from food_menu where shop_id=?", shopid);
    }

    public List<UserComment> selectCommentList(String shopid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(UserComment.class,
                        "select * from user_comment where shop_id=?", shopid);
    }

    public List<OrderInfo> selectOrderesList(String userid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(OrderInfo.class,
                        "select * from payment where user_id=?", userid);
    }
///
    public List<OrderInfo> selectOrderesFoodList(String userid, String oid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(OrderInfo.class,
                        "select * from payment where user_id=? and oid=?", userid, Integer.parseInt(oid));
    }
    public List<UserComment> GetPersonComments(String userid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(UserComment.class,
                        "select * from user_comment where user_id=?", userid);
    }

    public List<ShoppingcarFood> selectOrderesFoodList(String userid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(ShoppingcarFood.class,
                        "select * from bought_food where user_id=?", userid);
    }
    public List<FavouriteShop> GetFavouriteList(String userid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(FavouriteShop.class,
                        "select * from user_favorite_shop where user_id=?", userid);
    }


    public ShopInfoBuy GetShopInfoByName(String shop_name) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(ShopInfoBuy.class, "select * from shop where shop_name=?", shop_name);
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }
    public List<Shop_Info> GetShopListByName(String shop_name) throws ClassNotFoundException {
        return new JDBCUtil().selectList(Shop_Info.class, "select * from shop_info where shop_name=?", shop_name);
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }
    public Shop_Info GetShopInfoByShopid(String shopid) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(Shop_Info.class, "select * from shop_info where shop_id=?", shopid
        );
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }
    public MySocket GetSocketInfoByid(String socket_id) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(MySocket.class, "select * from socket_info where socket_id=?", socket_id
        );
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }
    public List<SocketDayElec> GetElecDays(String socket_id,String year,String month) throws ClassNotFoundException {
        return new JDBCUtil().selectList(SocketDayElec.class,
                "select * from elec_day where socket_id=? and month=? and year=?"
                , socket_id,month,year
        );
    }
    public List<SocketMonthElec> GetEleMonths(String socket_id,String year ) throws ClassNotFoundException {
        return new JDBCUtil().selectList(SocketMonthElec.class,
                "select * from elec_month where socket_id=?  and year=?"
                , socket_id,year
        );
    }
    public User GetUserImg(String userid) throws ClassNotFoundException {
        return new JDBCUtil().selectOne(User.class, "select * from user where uid=?", userid
        );
        //return new JDBCUtil().login("select * from muser where uname=? and upassword=?", name, pass);
    }

    public boolean uploadFavouriteShop(String shop_id, String shop_name, String user_id) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("insert into user_favorite_shop(user_id,shop_id,shop_name)" +
                                "values(?,?,?)"
                        , user_id, shop_id, shop_name);
    }

    public boolean BuyFood(String foodname, String food_price, String user_id,String shop_name) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("insert into bought_food(food_name,food_price,user_id,shop_name)" +
                                "values(?,?,?,?)"
                        , foodname, food_price, user_id,shop_name);
    }

    public boolean deleteFavouriteShop(String shop_id, String user_id) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("delete from  user_favorite_shop where  user_id=? and shop_id=?"
                        , user_id, shop_id);
    }

    public boolean minusFood(String food_name, String user_id) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("delete from  bought_food where  user_id=? and food_name=?"
                        , user_id, food_name);
    }
    public boolean deleteBoughtFood(String user_id) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("delete from  bought_food where  user_id=?"
                        , user_id);
    }
    public boolean deleteComment(String comment_addr) throws ClassNotFoundException {
        return new JDBCUtil()
                .execute("delete from  user_comment where  comment_img_addr=?"
                        , comment_addr);
    }
}
