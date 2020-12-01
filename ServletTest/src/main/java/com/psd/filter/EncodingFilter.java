package com.psd.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码格式过滤器
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //编码过滤
        //过滤请求的编码
        req.setCharacterEncoding("UTF-8");
        //过滤响应的编码
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");


        //通过过滤器拦截，继续向后执行
        super.doFilter(req, res, chain);//chain.doFilter(req, res);
    }
}
