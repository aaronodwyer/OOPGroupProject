import java.util.ArrayList;

public class Library {
    private ArrayList<ReadingExercises> readingExercises = new ArrayList<>();
    private ArrayList<VocabularyExercises> vocabularyExercises = new ArrayList<>();

    public void addReadingExercise(ReadingExercises exercise) {
        readingExercises.add(exercise);
    }

    public void addVocabularyExercise(VocabularyExercises exercise) {
        vocabularyExercises.add(exercise);
    }

    public ArrayList<ReadingExercises> getReadingExercises() {
        return readingExercises;
    }

    public ArrayList<VocabularyExercises> getVocabularyExercises() {
        return vocabularyExercises;
    }
}
