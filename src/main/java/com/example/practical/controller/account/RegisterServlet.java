package com.example.practical.controller.account;

import com.example.practical.entity.User;
import com.example.practical.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class RegisterServlet extends HttpServlet {

    private UserModel accountModel = new UserModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean result = accountModel.save(user);
        if(result){
            resp.getWriter().println("Register success");
        }else {
            resp.getWriter().println("Errors!");
        }
    }
}
