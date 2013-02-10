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

/**
 *
 * @author ZenitH
 */
@WebServlet(name = "PasswordRecoverController", urlPatterns = {"/PasswordRecoverController"})
public class PasswordRecoverController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
          String email= request.getParameter("email");
            User u=UserDAO.getUserByEmail(email);
            String id= u.getUserID();
            
            User u2 = UserDAO.getUserById(id);
             
             
            String password = u2.getPassword();
            String name = u2.getPassword();
            
        
        //String enteredPassword= request.getParameter("password");
         UserService d=new UserService();
         d.mailEmail( email,password,name);

}

  
    }

