/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author ZenitH
 */
public class ServeImages extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imgName=request.getParameter("imgName"); //key value pairs 
        String filepath="//C://temp//";
        try{
         File image = new File(filepath+imgName);
		      InputStream is = new FileInputStream(image);
		     
		      IOUtils.copy(is, response.getOutputStream());
		      response.flushBuffer();
        } catch (IOException ex) {
		      
            //throw new RuntimeException("IOError writing file to output stream");
            ex.printStackTrace();
	}
    }

   
}
