public class ReadingExercises extends LearningExercises {
    private String passage;

    public ReadingExercises(String passage, String question, String correctAnswer) {
        super(question, correctAnswer);
        this.passage = passage;
    }

    public String getPassage() {
        return passage;
    }
}
