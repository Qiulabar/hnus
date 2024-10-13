package com.hnu.controller;

import com.hnu.dao.UserMgrImpl;
import com.hnu.dao.UserMgrInterface;
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

@WebServlet(name = "userListServlet", value = "/userList-servlet")
public class UserListServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // 模拟数据集
        List<User> users = new ArrayList<>();
        UserServiceInterface userservice = new UserServiceImpl();
        users = userservice.getUserAll();
        out.print(convertToJson(users));
    }

    private String convertToJson(List<User> users) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            json.append("{\"id\":\"").append(user.getId()).append("\",\"username\":\"").append(user.getUsername()).append("\",\"realName\":\"")
                    .append(user.getRealName()).append("\",\"gender\":\"").append(user.getGender())
                    .append("\",\"userType\":\"").append(user.getUserType()).append("\"}");
            if (i < users.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    public void destroy() {
    }
}