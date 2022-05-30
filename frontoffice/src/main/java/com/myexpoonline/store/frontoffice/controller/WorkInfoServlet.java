/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myexpoonline.store.frontoffice.controller;

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
@WebServlet(name = "WorkInfoServlet", urlPatterns = {"/work-infos"})
public class WorkInfoServlet extends HttpServlet {

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
            out.println("<title>Servlet WorkInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WorkInfoServlet at " + request.getContextPath() + "</h1>");
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

        PrintWriter out = response.getWriter();

//        for (Work work : Catalogue.listOfWorks) {
//
//            if (work.getId() == Integer.parseInt(request.getParameter("id"))) {
//                out.println("<h1>" + work.getTitle() + "</h1><br />");
//
//                out.println(work.getStyle() + "<br />");
//                out.println(work.getYear() + "<br />");
//                out.println(work.getAuthor().getName() + "<br />");
//                out.println(work.getDescription() + "<br />");
//                break;
//            }
//
//        }
        Work myWork = Catalogue.listOfWorks.stream()
                .filter(work -> work.getId() == Integer.parseInt(request.getParameter("id")))
                .findFirst().get();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + myWork.getTitle() + "</title>");
        out.println("</head>");
        out.println("<h1>" + myWork.getTitle() + "</h1><br />");

        out.println(myWork.getStyle() + "<br />");
        out.println(myWork.getYear() + "<br />");
        out.println(myWork.getAuthor().getName() + "<br />");
        out.println(myWork.getDescription() + "<br />");
        out.println("<a href='/frontoffice/catalogue'>Retour à notre catalogue</a>");

        out.println("</body>");
        out.println("</html>");
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
        processRequest(request, response);
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
