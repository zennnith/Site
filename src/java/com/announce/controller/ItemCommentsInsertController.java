/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.CommentDAO;
import com.announce.model.Comment;
import com.announce.model.Item;
import com.announce.model.User;
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
public class ItemCommentsInsertController extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         
        HttpSession sessions = request.getSession(false);
        User u = (User) sessions.getAttribute("currentUser");
        Item e =(Item)sessions.getAttribute("currentItem");
        
        String id = e.getId();
        String us= u.getUserID();
       
        String comment = request.getParameter("comment");
//        PrintWriter pr= response.getWriter();
//        pr.print(id);
////      pr.print(us);
////      pr.print(comment);
        
        CommentDAO obj = new CommentDAO();
        Comment c = new Comment();
        c.setComment(comment);
       
        c.setItemId(id);
        c.setUserId(us); 
        obj.insertComment(c );
        
         response.sendRedirect(response.encodeRedirectURL("DisplayFullAdd?id="+id));
         

//         RequestDispatcher view = request.getRequestDispatcher("DisplayWholeAdd.jsp");
//  
//        
//         view.forward(request, response);
//        
    }

    
}
