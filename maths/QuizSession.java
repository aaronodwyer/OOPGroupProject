/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;
//import java.time.LocalDateTime;

import java.util.*;

/**
 *
 * @author Aaron
 */
public class QuizSession {

    private final List<Question> questions;
    private final List<String> userAnswers;
    private int index = 0;

    public QuizSession(List<Question> questions) {
        this.questions = questions;
        this.userAnswers = new ArrayList<>(questions.size());
        for (int i = 0; i < questions.size(); i++) {
            userAnswers.add("");
        }
    }

    public Question getCurrentQuestion() {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public void submitAnswer(String answer) {
        if (index >= 0 && index < questions.size()) {
            userAnswers.set(index, answer);
        }
    }

    public void next() {
        if (index < questions.size() - 1) {
            index++;
        } else {
            index = questions.size();
        }
    }

    public int grade() {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            String ans = userAnswers.get(i);
            if (q.isCorrect(ans)) {
                score++;
            }
        }
        return score;
    }

    public boolean isFinished() {
        return index >= questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getCurrentIndex() {
        return index;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
