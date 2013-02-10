/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.BidDAO;
import com.announce.dao.ItemDAO;
import com.announce.model.Bid;
import com.announce.model.Item;
import com.announce.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class BidsViewer extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter o=response.getWriter();
        
         String s="";
        HttpSession session=request.getSession(false);
        User u=(User)session.getAttribute("currentUser");
        if(u!=null){
         String userId = u.getUserID(); 
         
      List<Bid> bidsAll= new ArrayList<Bid>();
       List<Item> it=ItemDAO.getItemAdvertiserID(userId);

       for(int i=0;i<it.size();i++){
        bidsAll.add(BidDAO.bidsByItem(it.get(i).getId()));
        
       }
       request.setAttribute("bidsView", bidsAll);
      
        }
        else
            request.setAttribute("userError", "login and try");
        
        

       
       RequestDispatcher a=request.getRequestDispatcher("BidAmounts.jsp");
       a.forward(request, response);
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
}
