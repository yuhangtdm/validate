package com.dity.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:yuhang
 * @Date:2018/8/15
 */
@WebServlet(urlPatterns = "/ajax",name = "ajax")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ha = req.getParameter("ha");
        System.out.println(ha);

//        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println("呵呵");
    }
}
