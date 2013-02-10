/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;



import com.announce.dao.UserDAO;
import com.announce.model.User;
import com.announce.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZenitH
 */
@WebServlet(name = "EditUserController", urlPatterns = {"/EditUserController"})
public class EditUserController extends HttpServlet {

    
  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter o=response.getWriter();
        
         HttpSession session = request.getSession(false);
         User e = (User) session.getAttribute("currentUser");
         
         String currentUserID=e.getUserID();
         User u=UserDAO.getUserById(currentUserID);
            request.setAttribute("phone",u.getPhone());
            request.setAttribute("answer1",u.getSecurityAns());

         
//         o.print(e.getEmail());
        RequestDispatcher view = request.getRequestDispatcher("/EditUserAccount.jsp");
        view.forward(request, response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
        HttpSession session = request.getSession(false);
        User u = (User) session.getAttribute("currentUser");
        //u.getUserID();
        
       
     
        PrintWriter pr = response.getWriter();
        
        User ud = new User();
        
        String phone = request.getParameter("phone");
        String secQt = request.getParameter("securityQuestion");
        String secAns = request.getParameter("answer");
        
        
        ud.setPhone(phone);
        ud.setSecurityQt(secQt);
        ud.setSecurityAns(secAns);
        ud.setUserID(u.getUserID());
        
//        pr.print(request.getParameter("phone"));
//        pr.print(request.getParameter(""));
//        pr.print(request.getParameter("answer"));
        
        
              
            UserDAO.updateUser(ud);
        
        
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        
    }

   
}
