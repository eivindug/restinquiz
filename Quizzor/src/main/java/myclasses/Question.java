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
public class Question {
    private String[] answers;
    private String text;
    private int time; 
    private String correct;

    public Question(String text, int time, String[] answers, String correct) {
        this.text = text;
        this.time = time;
        this.answers=answers;
        this.correct= correct;
    }
    public String[] getAnswers(){
        return answers;   
    }

    public String getCorrect() {
        return correct;
    }

    public Question() {
    }
        
    public String getText() {
        return text;
    }

    public int getTime() {
        return time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
