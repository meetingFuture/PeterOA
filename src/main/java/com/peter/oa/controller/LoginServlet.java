package com.peter.oa.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peter.oa.entiry.User;
import com.peter.oa.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        // Take user input
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // Business logic
        Map ret = new LinkedHashMap<>();
        try {
            User user = userService.checkLogin(username, password);
            ret.put("code", "0");
            ret.put("message", "success");
            Map data = new LinkedHashMap();
            ret.put("data", data);
        }catch (Exception e) {
            e.printStackTrace();
            ret.put("code", e.getClass().getSimpleName());
            ret.put("message", e.getMessage());
        }
        // Return json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = objectMapper.writeValueAsString(ret);
        resp.getWriter().write(json);

    }
}
