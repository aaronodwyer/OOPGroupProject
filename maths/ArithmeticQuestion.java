/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

/**
 *
 * @author Aaron
 */
public class ArithmeticQuestion extends Question {

    private final Operation op;
    private final int left;
    private final int right;

    public ArithmeticQuestion(int left, int right, Operation op) {
        this.left = left;
        this.right = right;
        this.op = op;
        this.prompt = left + " " + op.getSymbol() + " " + right + "=?";
        this.correctAnswer = switch (op) {
            case ADD ->
                String.valueOf(left + right);
            case SUB ->
                String.valueOf(left - right);
            case MUL ->
                String.valueOf(left * right);
            case DIV ->
                String.valueOf(left / right);
        };
    }

    public Operation getOperation() {
        return op;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
