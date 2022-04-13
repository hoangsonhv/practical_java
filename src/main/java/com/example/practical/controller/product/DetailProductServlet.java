package com.example.practical.controller.product;

import com.example.practical.entity.Products;
import com.example.practical.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

public class DetailProductServlet extends HttpServlet {

    private ProductModel model = new ProductModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Products obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else {
            HttpSession session = req.getSession();
            HashSet<Products> recentReviewProduct = (HashSet<Products>) session.getAttribute("recentReviewProduct");
            boolean exitsting = false;
            if (recentReviewProduct == null ){
                recentReviewProduct = new HashSet<>();
            }
            recentReviewProduct.add(obj);
            session.setAttribute("recentReviewProduct", recentReviewProduct);
            req.setAttribute("obj", obj);
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }
}
