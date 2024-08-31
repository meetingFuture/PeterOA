package com.peter.oa.controller;

import com.peter.oa.entity.User;
import com.peter.oa.service.UserService;
import com.peter.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ResponseUtils responseUtils = null;
        try {
            User user = userService.checkLogin(username, password);
            System.out.println(user.toString());
            responseUtils = new ResponseUtils().put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils().put(e.getClass().getName(), e.getMessage());
        }
        resp.getWriter().write(responseUtils.toJsonString());
    }
}
