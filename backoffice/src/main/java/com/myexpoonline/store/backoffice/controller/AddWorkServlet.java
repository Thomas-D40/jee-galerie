/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myexpoonline.store.backoffice.controller;

import com.myexpoonline.store.core.entity.Author;
import com.myexpoonline.store.core.entity.Catalogue;
import com.myexpoonline.store.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tom
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddWorkServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddWorkServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                   
        int id = Catalogue.listOfWorks.size() + 1;
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String description = request.getParameter("description");
        String style = request.getParameter("style");
        Author author = new Author(request.getParameter("author"));
        
        Work work = new Work();
        
        work.setId(id);
        work.setTitle(title);
        work.setYear(year);
        work.setDescription(description);
        work.setStyle(style);
        work.setAuthor(author);
        
        for (Work work:Catalogue.listOfWorks) {
            if(title.equalsIgnoreCase(work.getTitle()) &&
                    style.equalsIgnoreCase(work.getStyle()) &&
                            author.getName().equalsIgnoreCase(work.getAuthor().getName()))
                    )
        }
        
        
        
        Catalogue.listOfWorks.add(work);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
            /* TODO output your page here. You may use following sample code. */
            
        out.println("<p>Ajout effectué</p>");         
        
        
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
