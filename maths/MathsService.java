/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maths;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaron
 */
public class MathsService {

    private DifficultyStrategy strategy = new EasyStrategy();
    private static final String RESULTS_PATH = "results_math.csv";

    public void setStrategy(DifficultyStrategy s) {
        this.strategy = s;
    }

    public String getStrategyName() {
        return strategy.getName();
    }

    public QuizSession newQuiz(int n) {
        List<Question> qs = strategy.generateQuestions(n);
        return new QuizSession(qs);
    }

    public void saveResult(QuizResult r) {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"date", "difficulty", "score"});
        rows.add(new String[]{
            r.getDate().toString(),
            r.getDifficulty(),
            String.valueOf(r.getScore())
        });
        //CsvStore.append(RESULTS_PATH, rows, true);
    }

    /*public List<QuizResult> loadHistory() {
        List<QuizResult> results = new ArrayList<>();
        List<String[]> rows = CsvStore.read(RESULTS_PATH);
        for (String[] row : rows) {
            if (row.length < 3) continue;
            if ("date".equalsIgnoreCase(row[0])) continue; // skip header
            try {
                results.add(new QuizResult(
                        java.time.LocalDate.parse(row[0]),
                        row[1],
                        Integer.parseInt(row[2])
                ));
            } catch (Exception ignored) {}
        }
        return results;
    }*/
}
