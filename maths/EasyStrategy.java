/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

import utilities.Randomiser;
import java.util.*;

/**
 *
 * @author Aaron
 */
public class EasyStrategy implements DifficultyStrategy {

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Easy";
    }

    /**
     *
     * @param n
     * @return
     */
    @Override
    public List<Question> generateQuestions(int n) {
        List<Question> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Randomiser.nextInt(0, 10);
            int b = Randomiser.nextInt(0, 10);
            Operation op = (Randomiser.nextInt(0, 1) == 0) ? Operation.ADD : Operation.SUB;
            list.add(new ArithmeticQuestion(a, b, op));
        }
        return list;
    }
}
