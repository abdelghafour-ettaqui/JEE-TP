package com.example.jeetp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("heheheheheheh");
        String nom=request.getParameter("nom");
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<html><body>");
        out.println("<h3>"+nom+" test</h3>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
