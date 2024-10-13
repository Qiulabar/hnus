package com.hnu.controller;

import com.hnu.entity.User;
import com.hnu.service.UserServiceImpl;
import com.hnu.service.UserServiceInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.valueOf(request.getParameter("id"));
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        UserServiceInterface userservice = new UserServiceImpl();
        User user = userservice.findUser(id);
        out.print(convertToJson(user));
    }

    private String convertToJson(User user) {
        StringBuilder json = new StringBuilder("[");
        json.append("{\"id\":\"").append(user.getId()).append("\",\"username\":\"").append(user.getUsername()).append("\",\"realName\":\"")
                    .append(user.getRealName()).append("\",\"gender\":\"").append(user.getGender())
                    .append("\",\"userType\":\"").append(user.getUserType()).append("\"}");
        json.append("]");
        return json.toString();
    }

    public void destroy() {
    }
}