public abstract class LearningExercises {
    protected String prompt;
    protected String correctAnswer;

    public LearningExercises(String prompt, String correctAnswer) {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean checkAnswer(String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }
}
