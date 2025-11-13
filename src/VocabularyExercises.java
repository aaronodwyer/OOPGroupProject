public class VocabularyExercises extends LearningExercises {
    private String sentence;
    private String word;

    public VocabularyExercises(String sentence, String word, String question, String correctAnswer) {
        super(question, correctAnswer);
        this.sentence = sentence;
        this.word = word;
    }

    public String getSentence() {
        return sentence;
    }

    public String getWord() {
        return word;
    }
}
