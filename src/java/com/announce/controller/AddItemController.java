/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

import com.announce.dao.ItemDAO;
import com.announce.model.Item;
import com.announce.model.Item;
import com.announce.model.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.*;
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
@WebServlet(name = "AddItemController", urlPatterns = {"/AddItemController"})
public class AddItemController extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//       
//         RequestDispatcher view = request.getRequestDispatcher("/AddItem.jsp");
//         view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
          PrintWriter pr = response.getWriter();
          HttpSession session = request.getSession(true);
        User u = (User) session.getAttribute("currentUser");
        String title="",type="", price="",condition="",warranty="",description="",location ="",fileName="";
        if(u!=null)
        {
            
            try{
                File file;
                int maxFileSize=5000*1024;
                int maxMemSize=5000*1024;
                String filepath="//C://temp";
                if(ServletFileUpload.isMultipartContent(request))
               {
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    factory.setSizeThreshold(maxMemSize);
                    factory.setRepository(new File(filepath));

                    ServletFileUpload upload = new ServletFileUpload(factory);
                    upload.setSizeMax(maxMemSize);

                    List fileItems = upload.parseRequest(request);
                    Iterator i = fileItems.iterator();

                    while (i.hasNext()){
                        FileItem fi = (FileItem)i.next();
                        if(!fi.isFormField()){
                            fileName = u.getEmail()+(new Date()).getTime()+ fi.getName();
                            file=new File("C:\\temp\\"+fileName);
                            fi.write(file);
                        }
                        else if (fi.isFormField()) {

                            String fieldname = fi.getFieldName();
                            String fieldvalue = fi.getString();

                            if(fieldname.equals("title")){
                                title = fieldvalue;
                            }
                            else if(fieldname.equals("type")){
                                type = fieldvalue;
                            }
                            else if(fieldname.equals("price")){
                                price = fieldvalue;
                            }
                            else if(fieldname.equals("condition")){
                                condition = fieldvalue;
                            }
                            else if(fieldname.equals("warranty")){
                                warranty = fieldvalue;
                            }
                            else if(fieldname.equals("description")){
                                description = fieldvalue;
                            }
                            else if(fieldname.equals("location")){
                                location = fieldvalue;
                            }

                       } 
                }
        
        }
        }catch(Exception e){
            e.printStackTrace();
            
            
        }
          
         
       
        
        Item i = new Item();
     
        i.setUserID(u.getUserID());
        i.setTitle(title);
        i.setType(type);
        i.setPrice(price);
        i.setCondition(condition);
        i.setWarranty(warranty);
        i.setDescription(description);
        i.setCity(location);
        i.setImageName(fileName);
        
        
        ItemDAO.insertItem(i);
        
      }
        else
        {
            pr.print("please log-in");
        }
    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
    }

   
}
