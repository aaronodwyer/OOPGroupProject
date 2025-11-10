/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

import java.util.ArrayList;
import java.util.List;
import utilities.Randomiser;

/**
 *
 * @author Aaron
 */
public class MediumStrategy implements DifficultyStrategy {

    @Override
    public String getName() {
        return "Medium";
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
            int a = Randomiser.nextInt(2, 12);
            int b = Randomiser.nextInt(2, 12);
            Operation op = switch (Randomiser.nextInt(0, 2)) {
                case 0 ->
                    Operation.ADD;
                case 1 ->
                    Operation.SUB;
                default ->
                    Operation.MUL;
            };
            list.add(new ArithmeticQuestion(a, b, op));
        }
        return list;
    }
}
