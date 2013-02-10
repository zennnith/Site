/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.dao;

import com.announce.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZenitH
 */
@WebServlet(name = "UserDAO", urlPatterns = {"/UserDAO"})
public class UserDAO extends HttpServlet {

       private static String url;
       private static Connection con;


   static {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url = "jdbc:mysql://localhost/announce.lk";
            con = DriverManager.getConnection(url, "root", "123");
        }
        catch (Exception cnfe) // driver not found
        {
            System.err.println ("Unable to load database driver");
            System.err.println ("Details : " + cnfe);
            System.exit(0);
        }
   }
 
   public static User getUserByEmail(String email){
         User user= new User();
         try{
             
            PreparedStatement getItemstmt = con.prepareStatement("select * from user where email=?");
            getItemstmt.setString(1,email);
            ResultSet rs = getItemstmt.executeQuery();
       
            while (rs.next()) {
                user.setUserID(rs.getString("UserID"));
                user.setEmail(rs.getString("email"));
//                user.setName(rs.getString("Name"));
//                user.setPhone(rs.getString("ContactNo"));
               
                user.setPassword(rs.getString("Password"));
//                user.setSecurityQt("sequrityQT");
//                user.setSecurityAns("sequrityAn");
            } 
         }catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
         return user;
     }
   public static User getUserById(String id){
       User user =  new User();
       try{
           PreparedStatement getItemstmt = con.prepareStatement("select * from user where UserID=?");
           getItemstmt.setString(1, id);
           ResultSet rs = getItemstmt.executeQuery();
           
            while (rs.next()) {
                
                user.setUserID(rs.getString("UserID"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("ContactNo"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("Password"));
                user.setSecurityQt("sequrityQT");
                user.setSecurityAns("sequrityAn");
            } 
       }
       catch(Exception e){}
   
       return user;
   }
   
   public static void insertUser(User u){
         try{
            PreparedStatement insertUser = con.prepareStatement("INSERT INTO user (Email,Name,Password,ContactNo,SecurityQT,SecurityAns)Values(?,?,?,?,?,?)");
            
            
            insertUser.setString(1,u.getEmail());
            insertUser.setString(2,u.getName());
            insertUser.setString(3,u.getPassword());
            insertUser.setString(4,u.getPhone());
            insertUser.setString(5,u.getSecurityQt());
            insertUser.setString(6,u.getSecurityAns());
            
            insertUser.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
   
   public static void updateUser(User u){
   try {

            PreparedStatement getItemstmt = con.prepareStatement("UPDATE user SET ContactNo= ?,SecurityQT=?,SecurityAns=? WHERE UserID= ?");
           
            getItemstmt.setString(1, u.getPhone());
            getItemstmt.setString(2, u.getSecurityQt());
            getItemstmt.setString(3, u.getSecurityAns());
            getItemstmt.setString(4, u.getUserID());
            
            
            getItemstmt.executeUpdate();

        } catch (Exception e) {
        }
   
   
   }
   
   

    
}
