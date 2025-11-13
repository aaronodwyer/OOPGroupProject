public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        User user = new User("Sophie");

        ReadingExercises re1 = new ReadingExercises(
                "Tom Sawyer and his best friend Huckleberry Finn went fishing at the river. Tom yelled out “I Think I have a fish”, to which Huckleberry Finn replied “You gotta make sure you reel it in boy”.",
                "Who is Tom’s best friend?",
                "Huckleberry Finn"
        );
        library.addReadingExercise(re1);

        VocabularyExercises ve1 = new VocabularyExercises(
                "Tom yelled out “I Think I have a fish”, to which Huckleberry Finn replied “You gotta make sure you reel it in boy”.",
                "replied",
                "What does 'replied' mean?",
                "To say something back in response"
        );
        library.addVocabularyExercise(ve1);

        System.out.println("Reading Exercise:");
        System.out.println(re1.getPassage());
        System.out.println("Question: " + re1.getPrompt());
        String userAnswer1 = "Huckleberry Finn";
        if (re1.checkAnswer(userAnswer1)) {
            user.updateScore(1);
            System.out.println("Correct!");
        } else {
            System.out.println("Try again!");
        }

        System.out.println("---");

        System.out.println("Vocabulary Exercise:");
        System.out.println(ve1.getSentence());
        System.out.println("Question: " + ve1.getPrompt());
        String userAnswer2 = "To say something back in response";
        if (ve1.checkAnswer(userAnswer2)) {
            user.updateScore(1);
            System.out.println("Correct!");
        } else {
            System.out.println("Try again!");
        }

        System.out.println("Final score for " + user.getName() + ": " + user.getScore());
    }
}
