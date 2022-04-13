package com.example.practical.controller.product;

import com.example.practical.entity.Products;
import com.example.practical.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        List<Products> listObject = productModel.findAll();
        req.setAttribute("listObject", listObject);
        req.getRequestDispatcher("/admin/products/index.jsp").forward(req, resp);
    }
}
