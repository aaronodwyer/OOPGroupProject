public class User {
    private String name;
    private int score;

    public User(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points;
    }

    public void resetScore() {
        score = 0;
    }
}
