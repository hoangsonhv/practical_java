package com.example.practical.controller.account;

import com.example.practical.entity.User;
import com.example.practical.model.UserModel;
import com.example.practical.util.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {

    private UserModel accountModel = new UserModel();

    private static final int MAX_COUNT = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = accountModel.findAccountByUsername(username);
        if (user == null){
//            resp.getWriter().println("Invalid Information");
            resp.sendRedirect("/login");
            return;
        }
        boolean result = PasswordHandler.checkPassword(password, user.getPassword());
        if (result){
            HttpSession session = req.getSession();
            session.setAttribute("currenUser", user);
            resp.sendRedirect("/products/list");
        }else {
            resp.getWriter().println("Account is not valid!");
            resp.sendRedirect("/login");
        }
    }
}
