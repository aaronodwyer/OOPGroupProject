/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;
import java.util.List;
/**
 *
 * @author Aaron
 */
public interface DifficultyStrategy{
        String getName();
        List<Question> generateQuestions(int n);
}
    
    

