package com.example.practical.controller.product;

import com.example.practical.entity.Products;
import com.example.practical.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        Double price = Double.parseDouble(req.getParameter("price"));
        Products obj = new Products(name, thumbnail, price);
        if (!obj.isValid()){
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }

        ProductModel productModel = new ProductModel();
        productModel.save(obj);
        resp.sendRedirect("/products/list");
    }
}
