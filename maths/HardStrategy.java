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
public class HardStrategy implements DifficultyStrategy {

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Hard";
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
            int a = Randomiser.nextInt(4, 20);
            int b = Randomiser.nextInt(2, 12);
            Operation op = switch (Randomiser.nextInt(0, 3)) {
                case 0 ->
                    Operation.ADD;
                case 1 ->
                    Operation.SUB;
                case 2 ->
                    Operation.MUL;
                default ->
                    Operation.DIV;
            };
            if (op == Operation.DIV) {
                int prod = a * b;
                list.add(new ArithmeticQuestion(prod, a, Operation.DIV));
            } else {
                list.add(new ArithmeticQuestion(a, b, op));
            }
        }
        return list;
    }
}
