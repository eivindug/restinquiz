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

    import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eivin
 */
@Path("/quiz/")
public class Qservice {
    private static Map<String, Quiz> quiztable = new HashMap<String, Quiz>();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //adding quiz to quiztable
    public void addQuiz(Quiz q) {
       if(quiztable.containsKey(q.getName())) return;
       quiztable.put(q.getName(), q);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //get quiz data for datatable
    public Collection<Quiz> getQuiz() {
        return quiztable.values();
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON) //get user data for datatable
    public ArrayList<User> getUsers(@PathParam("name") String name){
        return quiztable.get(name).getUsers();
    }
    
    @POST
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON) //adds question to on quiz
    public void addQuestion(@PathParam("name") String name, Question q){
        quiztable.get(name).addQuestion(q);
        System.out.println(name);
    }
    
    @GET
    @Path("/{name}/{number}") 
    @Produces(MediaType.APPLICATION_JSON) //gets question data from one question in one quiz
    public String[] getQuestion(@PathParam("name") String name, @PathParam("number") String indeks ){
        String[] quest=new String[8];
        Question q= quiztable.get(name).getQuestion(Integer.parseInt(indeks));
        String[] answers= q.getAnswers();
        quest[0]=q.getText();
        quest[1]=Integer.toString(q.getTime());
        quest[2]=answers[0];
        quest[3]=answers[1];
        quest[4]=answers[2];
        quest[5]=answers[3];
        quest[6]=q.getCorrect();
        quest[7]= Integer.toString(quiztable.get(name).getQuestions().size());
        return quest;
    }
    @POST
    @Path("/{name}/{user}") //add user to quiz
    public void addUser(@PathParam("name") String name, @PathParam("user") String user ){
        if(quiztable.get(name).getUser(user)==null) quiztable.get(name).addUser(user);
    }
    @GET
    @Path("/username/{name}") //gets starttime
    public int getStart(@PathParam("name") String name){
        return quiztable.get(name).getStarttime();
    }
    @POST
    @Path("point/{name}/{user}") //gives point to one user
    public void givePoint(@PathParam("name") String name, @PathParam("user") String user){
        quiztable.get(name).getUser(user).givepoint();
    }
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON) // deletes a quiz from hashmap
    public void deleteQuiz(@PathParam("name") String name){
        quiztable.remove(name);
    }
    @DELETE
    @Path("/{name}/{user}") // deletes a user from quiz
    public void deleteUser(@PathParam("name") String name, @PathParam("user") String user ){
        quiztable.get(name).deleteUser(user);
    }
}


