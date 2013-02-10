/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.model;

/**
 *
 * @author ZenitH
 */
public class Bid {
    private String bidID;
    private String bidAmount;
    private String itemID;
    private String userID;

    public String getBidID() {
        return bidID;
    }

    public void setBidID(String bidID) {
        this.bidID = bidID;
    }

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
    
}
