/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import com.announce.dao.ItemDAO;
import com.announce.dao.UserDAO;
import com.announce.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
//@WebServlet(name = "DisplayItemController", urlPatterns = {"/DisplayItemController"})
public class DisplayAllItemsController extends HttpServlet {

   



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        ItemDAO u=new ItemDAO();
         List<Item> itemDis= u.getItems();
          request.setAttribute("items", itemDis);
         
       RequestDispatcher view = request.getRequestDispatcher("MainPage.jsp");
        view.forward(request, response);
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   
     }
}
