/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.dao;



import com.announce.model.Comment;
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
public class CommentDAO {
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
    
     public static void insertComment(Comment c){
         try{
            PreparedStatement insertComment= con.prepareStatement("INSERT INTO itemcomments (Comment,ItemItemID,UserUserID) Values(?,?,?)");
            insertComment.setString(1,c.getComment());
            insertComment.setString(2,c.getItemId());
            insertComment.setString(3, c.getUserId());
         
           // insertItem.setString(5,"Images/"+i.getContactNo());
            
            insertComment.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
     
      public  List<Comment> getComments(String id){
       List<Comment> comments = new ArrayList<Comment>();
                try {

            PreparedStatement getItemstmt = con.prepareStatement("SELECT * FROM itemcomments WHERE ItemItemID=? ");
            getItemstmt.setString(1,id);
            ResultSet rs = getItemstmt.executeQuery();
             while (rs.next()) {
                 Comment comment = new Comment();
                 comment.setComment(rs.getString("Comment"));
//                 comment.setComment(rs.getString("UserUserID"));
                 
                 comments.add(comment);
             }
             

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
        return comments;
    }
}
