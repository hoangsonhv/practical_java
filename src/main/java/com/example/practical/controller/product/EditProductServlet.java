package com.example.practical.controller.product;

import com.example.practical.entity.Product;
import com.example.practical.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProductServlet extends HttpServlet {

    private ProductModel model = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else {
            req.setAttribute("obj", obj);
            req.getRequestDispatcher("/admin/products/edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else {
            String name = req.getParameter("name");
            Double price = Double.parseDouble(req.getParameter("price"));
            int amount = Integer.parseInt(req.getParameter("amount"));
            String details = req.getParameter("details");
            obj.setName(name);
            obj.setPrice(price);
            obj.setAmount(amount);
            obj.setDetails(details);
            model.update(id, obj);
            resp.sendRedirect("/products/list");
        }
    }
}
