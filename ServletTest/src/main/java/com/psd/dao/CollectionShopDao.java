package com.psd.dao;

import com.psd.entity.CollectionShop;
import com.psd.util.JDBCUtil;

import java.util.List;

public class CollectionShopDao {

    public List<CollectionShop> selectList(String user_id) throws ClassNotFoundException {
        return new JDBCUtil().selectList(CollectionShop.class, "select * from user_favorite_shop where user_id=?",user_id);
    }
}
