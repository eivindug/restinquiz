/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

/**
 *
 * @author eivin
 */
public class User {
    private String username;
    private int score=0;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }
    public void givepoint() {
        score+=1;
    }
    public User(){    
    }
}
