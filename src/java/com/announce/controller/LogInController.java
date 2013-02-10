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
import javax.jms.Session;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZenitH
 */
public class LogInController extends HttpServlet {
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        User e = (User) session.getAttribute("currentUser");
        if(e!=null)
        {
            out.print("u are alrdy logged in");
        }
        else
        {
        RequestDispatcher view = request.getRequestDispatcher("/LoginForm.jsp");
        view.forward(request, response);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String next="index.jsp";
        HttpSession session = request.getSession(true);
        User u = (User)session.getAttribute("currentUser");

        if(u==null){
        String email= request.getParameter("email");
        String enteredPassword= request.getParameter("password");
        
        boolean result = UserService.authenticate(email, enteredPassword);
        
        
        if(result==true)
        {  
           User u2=UserDAO.getUserByEmail(email);
            String id=u2.getUserID();
            User u1 = UserDAO.getUserById(id);
                   
            out.print(u1);
          session.setAttribute("currentUser", u1);
        }
        else
        {   
            request.setAttribute("error", "Enter the user name and password again");
             
           next=("LoginForm.jsp");
            

        }
        }
        else{
        
        
        }
           RequestDispatcher view = request.getRequestDispatcher(next);
            view.forward(request, response);
        
        
        }

  

  
}


