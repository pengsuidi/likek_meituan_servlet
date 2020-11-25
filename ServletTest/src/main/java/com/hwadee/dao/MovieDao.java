package com.hwadee.dao;

import com.hwadee.entity.Movie;
import com.hwadee.util.JDBCUtil;

import java.util.List;

public class MovieDao {

    public Movie selectOne(int mid) throws ClassNotFoundException {
        return new JDBCUtil()
                .selectOne(Movie.class,
                        "select * from tmovies where mid=?",
                        mid);
    }

    public List<Movie> selectList() throws ClassNotFoundException {
        return new JDBCUtil()
                .selectList(Movie.class,
                        "select * from tmovies");
    }

    public List<Movie> selectListByPage(int currentPage, int pageSize) {
        return null;
    }

    public List<Movie> selectListBySearch(String word) throws ClassNotFoundException {
        String searchWord = "%" + word + "%";
        return new JDBCUtil()
                .selectList(Movie.class,
                        "SELECT * FROM tmovies WHERE mname LIKE ? OR maliasname LIKE ? OR leadingactor LIKE ? OR director LIKE ? OR screenwriter LIKE ?",
                        searchWord, searchWord, searchWord, searchWord, searchWord);
    }
}
