package com.example.practical.controller.account;

import com.example.practical.entity.User;
import com.example.practical.model.AccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {

    private AccountModel accountModel = new AccountModel();

    private static final int MAX_COUNT = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User account = accountModel.findAccountByUsername(username);
        if (account == null){
//            resp.getWriter().println("Invalid Information");
            resp.sendRedirect("/login");
            return;
        }
        if (account.getStatus() == 2){
            if (LocalDateTime.now().compareTo(account.getLockTime()) > 0){
                account.setStatus(1);
                account.setFailureCount(0);
                accountModel.updateLock(account.getUsername(), account);
            }else {
                resp.getWriter().println("Errors!");
                return;
            }
        }
        boolean result = PasswordHandler.checkPassword(password, account.getPasswordHash(), account.getSalt());
        if (result){
            HttpSession session = req.getSession();
            session.setAttribute("currenAccount", account);
            resp.sendRedirect("/");
        }else {
            account.setFailureCount(account.getFailureCount() + 1);
            if (account.getFailureCount() == MAX_COUNT){
                account.setStatus(2);
                account.setLockTime(LocalDateTime.now().plusMinutes(5));
                accountModel.updateLock(account.getUsername(), account);
            }
            resp.getWriter().println("Account is lock 5 minute!");
            resp.sendRedirect("/login");
        }
    }
}
