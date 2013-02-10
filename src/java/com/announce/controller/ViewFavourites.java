/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.FavouriteDAO;
import com.announce.dao.ItemDAO;
import com.announce.model.Favourite;
import com.announce.model.Item;
import com.announce.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ViewFavourites", urlPatterns = {"/ViewFavourites"})
public class ViewFavourites extends HttpServlet {
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter p=response.getWriter();
       HttpSession session = request.getSession(true);
        User e = (User) session.getAttribute("currentUser");
        e.getUserID();
      if(e!=null){
      
      
            ItemDAO dao = new ItemDAO();
            List<Favourite> favDis = FavouriteDAO.getFavouritesByUserID( e.getUserID());
            
            List<Item> favItemList = new ArrayList<Item>();
              
            for(int i=0;i<favDis.size();i++)
            {
               favItemList.add( ItemDAO.getItemByItemID(favDis.get(i).getItemID()));
                p.println(favDis.get(i).getItemID());
            
            }
////             for(int i=0;i<favItemList.size();i++)
////            {
////             p.print(favItemList.get(i).getId());
////            
////            }
           // List<Item> itemDis= u.getItems();
            request.setAttribute("favs", favItemList);
         
            RequestDispatcher view = request.getRequestDispatcher("ViewFavourites.jsp");
            view.forward(request, response);
      }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }

   
}
