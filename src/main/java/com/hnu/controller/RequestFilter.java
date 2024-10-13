package com.hnu.controller;

import jakarta.servlet.*;
import java.io.IOException;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "PriFilter",urlPatterns="/*")
public class RequestFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            request.setCharacterEncoding("GBK");
                    response.setContentType("text/html;charset=GBK");
            response.setCharacterEncoding("GBK");
                    chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
