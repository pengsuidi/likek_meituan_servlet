package com.psd.util;

public class Config {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8";
// ////   public static final String JDBC_URL = "jdbc:mysql://140.143.38.249:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8";
    public static final String JDBC_URL = "jdbc:mysql://106.54.87.185:3306/mydatabase?useUnicode=true&characterEncoding=UTF-8";
//
    public static final String JDBC_USER = "psd";
//    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "barrett";
//    public static final String JDBC_PASSWORD = "barrett";

    public static final int STATUS_UPLOAD_FAVOURITE_SUCCESS = 101;
    public static final int STATUS_DELETE_FAVOURITE_SUCCESS = 102;
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_FAILURE = 0;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAVOURITE_SUCCESS = 100;
    public static final int STATUS_NOT_FOUND = 123;
    //请求参数名常量
    public static final String REQUEST_PARAMETER_COMMENT_ADDR = "comment_addr";
    public static final String REQUEST_PARAMETER_SOCKET_ID ="socket_id";
    public static final String REQUEST_PARAMETER_SOCKET_REMARK ="socket_remark";
    public static final String REQUEST_PARAMETER_SOCKET_IMAGE64 ="socket_image64";
    public static final String REQUEST_QUERY_STRING = "query_string";
    public static final String REQUEST_PARAMETER_FOOD_TYPE ="foodtype" ;
    public static final String REQUEST_PARAMETER_FOOD_DESCRIPTION = "food_description";
    public static final String REQUEST_PARAMETER_FOOD_IMG_64 ="foodimg64";
    public static final String REQUEST_PARAMETER_FOOD_NAME = "foodname";
    public static final String REQUEST_PARAMETER_FOOD_PRICE ="foodprice" ;
    public static final String REQUEST_PARAMETER_FOOD_IMG ="foodimg" ;
    public static final String REQUEST_PARAMETER_SHOPID ="shopid";
    public static final String REQUEST_PARAMETER_SHOPIMG_BASE64 ="shopimg_base64";
    public static final String REQUEST_PARAMETER_CommentIMG_BASE64 ="commentimg_base64";
    public static final String REQUEST_PARAMETER_UserIMG_BASE64 ="userimg_base64";

    public static final String REQUEST_PARAMETER_SHOPNAME ="shopname";
    public static final String REQUEST_PARAMETER_SHOPTYPE ="shoptype";

    public static final String REQUEST_PARAMETER_UID = "uid";
    public static final String REQUEST_PARAMETER_USERNAME = "uname";
    public static final String REQUEST_PARAMETER_PASSWORD = "upassword";
    public static final String REQUEST_PARAMETER_FOOD_DISCRIPTION = "food_discription";
    public static final String REQUEST_PARAMETER_FOOD_MENU_obj ="food_menu_obj";
    public static final String REQUEST_PARAMETER_NICKNAME = "unickname";
    public static final String REQUEST_PARAMETER_MONTH = "month";
    public static final String REQUEST_PARAMETER_YEAR = "year";

    public static final String REQUEST_PARMETER_ORDER_ID = "oid";


//    public static final String REQUEST_PARMETER_SHOP_ID = "shop_id";
    public static final String REQUEST_PARMETER_FOOD_IMAGE = "food_image";

    public static final String REQUEST_PARMETER_OTIME = "otime";


    public static final String REQUEST_PARAMETER_METHOD = "method";
    public static final String REQUEST_PARAMETER_FOOD_ID = "food_id";

    //请求参数值常量
    public static final String REQUEST_VALUE_METHOD_LIST_BY_PAGE = "list_by_page";
    public static final String REQUEST_VALUE_METHOD_LIST = "list";
    public static final String REQUEST_VALUE_METHOD_ONE = "one";
    public static final String REQUEST_PARAMETER_COMMENT = "comment";
    public static final String REQUEST_PARAMETER_USER_ID = "userid";

    //请求参数值常量


    public static final String REQUEST_PARAMETER_GRADE ="grade";
    public static final String REQUEST_PARAMETER_TOTAL_PRICE = "totalprice";

    public static final String REQUEST_PARAMETER_OID = "oid";
    public static final String REQUEST_PARAMETER_NEWOID = "newoid";
    public static final String REQUEST_PARAMETER_OLDOID = "oldoid";
}
