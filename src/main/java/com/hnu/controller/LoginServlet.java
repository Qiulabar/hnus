package com.hnu.controller;

import java.io.*;

import com.hnu.service.UserServiceImpl;
import com.hnu.service.UserServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserServiceInterface userService = new UserServiceImpl();
        int userType  = userService.verifyUser(username, password);
        switch (userType) {
            case -1:
                request.getRequestDispatcher(
                                "index.html")
                        .forward(request, response);
                break;
            case 2:
                session.setAttribute("priv", "2");
                session.setAttribute("user", username);
                request.getRequestDispatcher("/admin/admin.html").forward(request,
                        response);
                break;
            case 1:
                session.setAttribute("priv", "1");
                session.setAttribute("user", username);
                request.getRequestDispatcher("/teacher/teacher.html").forward(request,
                        response);
                break;
            case 0:
                session.setAttribute("priv", "0");
                session.setAttribute("user", username);
                request.getRequestDispatcher("/student/student.html").forward(request,
                        response);
        }
    }

    public void destroy() {
    }
}