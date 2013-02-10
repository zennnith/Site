/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.dao;

import com.announce.model.Bid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZenitH
 */
public class BidDAO {
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
      public static void insertBid(Bid b){
         try{
            PreparedStatement insertBid= con.prepareStatement("INSERT INTO  bids (BidAmount,ItemItemID,UserUserID) Values(?,?,?)");
            insertBid.setString(1,b.getBidAmount());
            insertBid.setString(2,b.getItemID());
            insertBid.setString(3,b.getUserID());
         
           // insertItem.setString(5,"Images/"+i.getContactNo());
            
            insertBid.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
      
       public static Bid getBid(String itemID){
       Bid bid=new Bid();
            try {

            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM bids WHERE ItemItemID=?");
            getItemstmt.setString(1,itemID);
            ResultSet rs = getItemstmt.executeQuery();
             while (rs.next()) {
                // Bid bid = new Bid();
                 
                bid.setBidAmount(rs.getString("BidAmount"));
                bid.setBidID(rs.getString("BidID"));
       
                 
             }
             
             

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return bid;
        
        
        
        
        
    }

  public static void updateHigherBid(Bid b){
         try{
            PreparedStatement insertBid= con.prepareStatement("UPDATE   bids SET BidAmount= ? WHERE ItemItemID =? ");
            insertBid.setString(1,b.getBidAmount());
            insertBid.setString(2,b.getItemID());
           
         
           // insertItem.setString(5,"Images/"+i.getContactNo());
            
            insertBid.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
  
  public static Bid bidsByItem(String item){
         Bid b=new Bid();
         try {
            PreparedStatement getBid = con.prepareStatement("SELECT * FROM bids where ItemItemID=? ");
             getBid.setString(1, item); 
            ResultSet rs = getBid.executeQuery();
             while (rs.next()) {
            b.setBidAmount(rs.getString("BidAmount"));
            b.setUserID(rs.getString("UserUserID"));
            b.setItemID(rs.getString("ItemItemID"));
           
            
             }

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return b;
    }
  
  
}