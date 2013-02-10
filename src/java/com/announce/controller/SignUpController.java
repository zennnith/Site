/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.model.User;
import com.announce.dao.UserDAO;
import com.announce.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZenitH
 */
public class SignUpController extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         RequestDispatcher view = request.getRequestDispatcher("/SignUpForm.jsp");
         view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        
        String enteredPassword= request.getParameter("password");
        String matchPassword =  request.getParameter("password2");
        String securityQt =  request.getParameter("securityQuestion");
        String securityAns =  request.getParameter("answer");
       
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPhone(phone);
        u.setPassword(enteredPassword);
        u.setSecurityQt(securityQt);
        u.setSecurityAns(securityAns);
       
        u.setPassword(enteredPassword);
        boolean result = UserService.passwordMatch(matchPassword, enteredPassword);
        
        UserDAO.insertUser(u);
          RequestDispatcher view = request.getRequestDispatcher("LoginForm.jsp");
        view.forward(request, response);
        
        
        

    }

}
