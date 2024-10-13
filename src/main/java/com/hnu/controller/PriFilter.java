package com.hnu.controller;

import jakarta.servlet.*;
import java.io.IOException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "PriFilter",urlPatterns="/*")
public class PriFilter implements Filter {

    private static final String[] dir =
            {
                    "/student","/teacher","/admin"
            };
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = (req).getSession();
        String user = (String) session.getAttribute("user");
        String priv = (String) session.getAttribute("priv");
        String url = req.getRequestURI().substring(
                req.getContextPath().length());
        for (int i = 0; i < dir.length; i++) {
            if (url.startsWith(dir[i])) {
                if (user == null) {
                    request.getRequestDispatcher("../index.html")
                            .forward(request, response);
                } else if (Integer.parseInt(priv) != i) {
                    request.getRequestDispatcher("../error.html").forward(
                            request, response);
                }
            }
        }
        chain.doFilter(request, response);
    }
}

