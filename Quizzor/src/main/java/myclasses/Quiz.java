/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import java.util.ArrayList;


public class Quiz {
    private ArrayList<Question> questions = new ArrayList<Question>();
    private ArrayList<User> users = new ArrayList<User>();
    private int players=0;
    private String name;
    private String maker;
    private int starttime;

    public Quiz(String name, String maker, int starttime){
        this.name=name;
        this.maker=maker;
        this.starttime=starttime;
    }

    public int getPlayers() {
        return players;
    }
    
    public Quiz(){   
    }

    public String getName() {
        return name;
    }

    public int getStarttime() {
        return starttime;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }


    public String getMaker() {
        return maker;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }
    public void addQuestion(String text, int time, String[] answers, String correct){
        questions.add(new Question(text, time, answers, correct));
                
    }
    public void addQuestion(Question q){
        questions.add(q);
                
    }
    public Question getQuestion(int indeks){
        return questions.get(indeks);
    }
    public void addUser(String username){
        users.add(new User(username));
        players+=1;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    
    public User getUser(String username){
        for(int x=0; x<users.size(); x++){
            if(username.equals(users.get(x).getUsername())) return users.get(x);
        }
        return null;
    }
    public void deleteUser(String username){
        for(int x=0; x<users.size(); x++){
            if(username.equals(users.get(x).getUsername())){
               users.remove(x);
               players-=1;
               return;
            }         
        }
    }
    
    
}

