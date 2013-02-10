/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.model;

/**
 *
 * @author ZenitH
 */
public class User {
    private String userID;
    private String name;
    private String email;
    private String phone;
  
    private String password;
    private String securityQt;
    private String securityAns;
    
     public  User(){
  
    }
    public User(String email){
        this.email=email;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQt() {
        return securityQt;
    }

    public void setSecurityQt(String securityQt) {
        this.securityQt = securityQt;
    }

    public String getSecurityAns() {
        return securityAns;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
