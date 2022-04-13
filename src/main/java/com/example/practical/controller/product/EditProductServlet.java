package com.example.practical.controller.product;

import com.example.practical.entity.Products;
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
        Products obj = model.findById(id);
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
        Products obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else {
            String name = req.getParameter("name");
            String thumbnail = req.getParameter("thumbnail");
            Double price = Double.parseDouble(req.getParameter("price"));
            int status = Integer.parseInt(req.getParameter("status"));
            obj.setName(name);
            obj.setThumbnail(thumbnail);
            obj.setPrice(price);
            obj.setStatus(status);
            model.update(id, obj);
            resp.sendRedirect("/products/list");
        }
    }
}
