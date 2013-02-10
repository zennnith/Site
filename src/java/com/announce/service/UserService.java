/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.service;

import com.announce.dao.UserDAO;
import com.announce.model.User;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ZenitH
 */
public class UserService {
    public static boolean passwordMatch(String password,String reEnteredPassword){
        
        if(password.equals(reEnteredPassword))
        {
            return true;
        
        }
        else
        {
            return false;
        }
   
    }
      public static boolean authenticate(String email, String epw){
            
        User user= UserDAO.getUserByEmail(email);
        
        
        if(epw.equals(user.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    public static void mailEmail(String email,String password,String name ){
        String em=email;
        String pas=password;
        String na= name;
   
        try{
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                            "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication("announcelk@gmail.com","12345678j"); 
                            }
                    });

            try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("announcelk@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(email));
                    message.setSubject("Password Reminder");
                    message.setText("Dear User," +
                                    "\n\n   This is a reminder of your current password at announce.lk.\n Dear,"+na+"\n  Your username is - '"+email +"'\n   Your password is - '"+pas+"'\n\nThank you,\nManagement\n announce.lk");

                    Transport.send(message);

                    System.out.println("Done");
                   

            } catch (MessagingException e) {
                   
                    throw new RuntimeException(e);
                    
            }
        }
        catch(Exception ex)
        {
          
            System.out.println(ex.getMessage());
        }
       
    }
    
    
    
    }

