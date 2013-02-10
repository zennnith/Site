/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.model;

/**
 *
 * @author ZenitH
 */
public class Favourite {
    private String favID;
    private String userID;
    private String itemID;

    public String getFavID() {
        return favID;
    }

    public void setFavID(String favID) {
        this.favID = favID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
    
}
