/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

import java.time.LocalDate;

/**
 *
 * @author Aaron
 */
public class QuizResult {

    private final LocalDate date;
    private final String difficulty;
    private final int score;

    public QuizResult(LocalDate date, String difficulty, int score) {
        this.date = date;
        this.difficulty = difficulty;
        this.score = score;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }
}
