/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.dao;

import com.announce.model.Favourite;
import com.announce.model.Item;
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
public class FavouriteDAO {
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
    
    public void insertFavourites(Favourite f){
    
        try{
            PreparedStatement insertItem = con.prepareStatement("INSERT INTO favourites (UserUserID,ItemItemID) Values(?,?)");
            insertItem.setString(2,f.getItemID());
            insertItem.setString(1,f.getUserID());
          
            
            insertItem.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
    
    
    }
   public static List<Favourite>  getFavouritesByUserID(String userID){

       List<Favourite> favs = new ArrayList<Favourite>();
                try {

            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM favourites WHERE UserUserID=?");
            getItemstmt.setString(1,userID);
            ResultSet rs = getItemstmt.executeQuery();
            while (rs.next()) {
                 Favourite fav = new Favourite();
                 
                 fav.setItemID(rs.getString("ItemItemID"));
               
                 
                 favs.add(fav);
             }
             

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return favs;
    }
   
   public static void removeListItem(String listItem){
        try {

            PreparedStatement getItemstmt = con.prepareStatement("DELETE FROM favourites WHERE ItemItemID=?");
            getItemstmt.setString(1, listItem);
            getItemstmt.executeUpdate();
          
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
    }
    
    
}
