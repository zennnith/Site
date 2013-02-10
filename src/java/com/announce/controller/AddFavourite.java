/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.FavouriteDAO;
import com.announce.model.Favourite;
import com.announce.model.Item;
import com.announce.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ZenitH
 */
public class AddFavourite extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession sessions = request.getSession(false);
        User u = (User) sessions.getAttribute("currentUser");
        Item e =(Item)sessions.getAttribute("currentItem");
       String id= e.getId();
   
        Favourite f = new Favourite();
        f.setUserID(u.getUserID());
        f.setItemID(e.getId());
        
        FavouriteDAO obj = new FavouriteDAO();
        obj.insertFavourites(f);
        
        response.sendRedirect(response.encodeRedirectURL("DisplayFullAdd?id="+id));
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
      
        
    }
}
