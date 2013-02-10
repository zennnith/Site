/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.dao;


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
public class ItemDAO {
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
    public static void insertItem(Item i){
         try{
            PreparedStatement insertItem = con.prepareStatement("INSERT INTO item (Title,itemType,Price,itemCondition,Warranty,Description,city,UserUserID,ImageName) Values(?,?,?,?,?,?,?,?,?)");
            insertItem.setString(1,i.getTitle());
            insertItem.setString(2,i.getType());
            insertItem.setString(3,i.getPrice());
            insertItem.setString(4,i.getCondition());
            insertItem.setString(5,i.getWarranty());
            insertItem.setString(6,i.getDescription());
            insertItem.setString(7,i.getCity());
            insertItem.setString(8,i.getUserID());
           insertItem.setString(9,i.getImageName());
            
            insertItem.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
       public  List<Item> getItems(){
       List<Item> items = new ArrayList<Item>();
                try {

            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM item");
            
            ResultSet rs = getItemstmt.executeQuery();
             while (rs.next()) {
                 Item item = new Item();
                 item.setId(rs.getString("ItemID"));
                 item.setTitle(rs.getString("Title"));
                 item.setType(rs.getString("itemType"));
                 item.setPrice(rs.getString("Price"));
                 item.setCondition(rs.getString("itemCondition"));
                 item.setDescription(rs.getString("Description"));
                 item.setImageName(rs.getString("ImageName"));
                 
                 items.add(item);
             }
             

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return items;
    }
       
       
       //.................................
       
       public static List<Item>  getItemAdvertiserID (String advertiser){
        List<Item> it = new ArrayList<Item>();
        try {
           
            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM item where UserUserID=?");
            getItemstmt.setString(1,advertiser);
            ResultSet rs = getItemstmt.executeQuery();
            while (rs.next()) {
                
              Item items = new Item();
                items.setId(rs.getString("ItemID"));
                items.setTitle(rs.getString("Title"));
                items.setType(rs.getString("itemType"));
                items.setPrice(rs.getString("Price"));
                items.setCondition(rs.getString("itemCondition"));
                items.setWarranty(rs.getString("Warranty"));
                items.setDescription(rs.getString("Description"));
                items.setUserID(rs.getString("UserUserID"));
                items.setImageName(rs.getString("ImageName"));
                
                
                it.add(items);
            }


        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return it;
    }
       

    
    public  List<Item> searchedItemsBrand(String brand){
       List<Item> items = new ArrayList<Item>();
                try {

            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM item WHERE itemType=?");
            getItemstmt.setString(1,brand);
            ResultSet rs = getItemstmt.executeQuery();
             while (rs.next()) {
                 Item item = new Item();
                 
                 item.setTitle(rs.getString("Title"));
                 item.setId(rs.getString("ItemID"));
                 item.setType(rs.getString("itemType"));
                 item.setPrice(rs.getString("Price"));
                 item.setCondition(rs.getString("itemCondition"));
                 item.setDescription(rs.getString("Description"));
                 item.setImageName(rs.getString("ImageName"));
                 items.add(item);
             }
             

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return items;
    }
    public static Item getItemByItemID(String itemID){
         Item item= new Item();
         try{
             
            PreparedStatement getItemstmt = con.prepareStatement("select * from item where ItemID=?");
            getItemstmt.setString(1,itemID);
            ResultSet rs = getItemstmt.executeQuery();
       
            while (rs.next()) {
                
               // user.setEmail(rs.getString("email"));
                item.setId(rs.getString("ItemID"));
                item.setTitle(rs.getString("Title"));
                item.setType(rs.getString("itemType"));
               
                item.setPrice(rs.getString("Price"));
                item.setCondition(rs.getString("itemCondition"));
                item.setWarranty(rs.getString("Warranty"));
                item.setCity(rs.getString("City"));
                item.setDescription(rs.getString("Description"));
                item.setImageName(rs.getString("ImageName"));
                
            } 
         }catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
         return item;
     }
    
 
}
