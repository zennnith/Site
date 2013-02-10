/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.announce.model;

/**
 *
 * @author ZenitH
 */
public class Comment {
    private String commentId;
    private String comment;
    private String itemId;
    private String userId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
