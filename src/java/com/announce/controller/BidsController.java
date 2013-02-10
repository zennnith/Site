/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.BidDAO;
import com.announce.model.Bid;
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
public class BidsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      PrintWriter o=response.getWriter();
     String notLoged="";
        HttpSession sessions = request.getSession(false);
        User u = (User)sessions.getAttribute("currentUser");
        Item e =(Item)sessions.getAttribute("currentItem");
        String item = e.getId();
        if(u==null)
        {
            notLoged = "You have to be loged-in to bid";
        
        }
        else
        {
            String user= u.getUserID();
           
            String value = request.getParameter("bid");
 
            
            Bid bid= BidDAO.getBid(item);
            if(bid.getBidAmount()==null){
//                 o.print(bid.getBidAmount());
                bid.setBidAmount(value);
                bid.setItemID(item);
                bid.setUserID(user);
                BidDAO.insertBid(bid);
            }

               int savedMax= Integer.parseInt(bid.getBidAmount());
               int currentBid=Integer.parseInt(value);
            if (savedMax < currentBid) {
                    
                    Bid b = new Bid();
                    b.setUserID(user);
                    b.setItemID(item);
                    b.setBidAmount(value);
                    BidDAO.updateHigherBid(b);
    }
                else
                {
                    
                   
                    notLoged = "Your bid is low than the current highest bid  "; 
                
                }
      
      
        }
        response.sendRedirect(response.encodeRedirectURL("DisplayFullAdd?id="+item +"&handle="+notLoged));
        
    }
  
    

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

}