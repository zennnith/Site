/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.BidDAO;
import com.announce.dao.CommentDAO;
import com.announce.dao.ItemDAO;
import com.announce.model.Bid;
import com.announce.model.Comment;
import com.announce.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DisplayFullAddController extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ItemDAO u=new ItemDAO();
            String id= request.getParameter("id");
            Item i = new Item();
            i.setId(id);
            HttpSession session = request.getSession(true);
            session.setAttribute("currentItem", i);
            
            PrintWriter pr = response.getWriter();
//           pr.print();
         
            CommentDAO c=new CommentDAO();
            List<Comment> result= c.getComments(id);
            request.setAttribute("styles", result);
           
            
             String outs="No previouse Bids!!Be the first";
        
         
         BidDAO bid = new BidDAO();
            Bid highest = bid.getBid(id);
          String bidAmount=highest.getBidAmount();
          String currentHigh= "Enter a bid more than "+bidAmount;
          pr.print(currentHigh);
       
          if(bidAmount ==null){
            
             request.setAttribute("maxbidValues","no available bids");    
            // out.print("null");
            }
          else{
              request.setAttribute("maxbidValues",currentHigh); 
             // out.print("0");
            }

           
            Item items= u.getItemByItemID(id);
           request.setAttribute("item", items);
             request.setAttribute("handleErroe", request.getParameter("handle"));
          
           RequestDispatcher view = request.getRequestDispatcher("DisplayWholeAdd.jsp");
        view.forward(request, response);
    
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher view = request.getRequestDispatcher("DisplayWholeAdd.jsp");
//        view.forward(request, response);
    }
    

    
}
