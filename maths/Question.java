/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;
import java.util.*;
/**
 *
 * @author Aaron
 */
public abstract class Question {
    protected final String id = UUID.randomUUID().toString();
    protected String prompt;
    protected String correctAnswer;
    
    public String getId(){
        return id;
    }
    public String getPrompt(){
        return prompt;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }
    
    public boolean isCorrect(String input){
        if(input == null) return false;
        return correctAnswer.trim().equalsIgnoreCase(input.trim());
    }
}
