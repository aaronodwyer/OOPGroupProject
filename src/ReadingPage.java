import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ReadingPage extends JPanel {
    private List<ReadingExercises> exercises;
    private User user;
    private int currentIndex = 0;

    private JTextArea passageArea;
    private JTextArea questionArea;
    private JTextField answerField;
    private JButton submitButton;
    private JLabel feedbackLabel;

    public ReadingPage(List<ReadingExercises> exercises, User user) {
        this.exercises = exercises;
        this.user = user;

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(255, 249, 196));

        passageArea = new JTextArea();
        passageArea.setWrapStyleWord(true);
        passageArea.setLineWrap(true);
        passageArea.setEditable(false);
        passageArea.setFont(new Font("Arial", Font.PLAIN, 16));
        passageArea.setBackground(new Color(255, 255, 224));
        passageArea.setPreferredSize(new Dimension(550, 120));
        passageArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(passageArea, BorderLayout.NORTH);

        questionArea = new JTextArea();
        questionArea.setWrapStyleWord(true);
        questionArea.setLineWrap(true);
        questionArea.setEditable(false);
        questionArea.setFont(new Font("Arial", Font.BOLD, 16));
        questionArea.setBackground(new Color(255, 249, 196));
        questionArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        questionArea.setPreferredSize(new Dimension(550, 60));
        add(questionArea, BorderLayout.CENTER);

        JPanel answerPanel = new JPanel();
        answerPanel.setBackground(new Color(255, 249, 196));
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.PLAIN, 16));
        answerField.setAlignmentX(Component.LEFT_ALIGNMENT);
        answerPanel.add(answerField);
        answerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        submitButton = new JButton("Submit Answer");
        submitButton.setBackground(new Color(174, 213, 129));
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        answerPanel.add(submitButton);
        answerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        feedbackLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        answerPanel.add(feedbackLabel);

        add(answerPanel, BorderLayout.SOUTH);

        loadQuestion();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText().trim();
                if (userAnswer.isEmpty()) {
                    feedbackLabel.setText("Please enter an answer.");
                    return;
                }
                ReadingExercises currentExercise = exercises.get(currentIndex);
                if (currentExercise.checkAnswer(userAnswer)) {
                    user.updateScore(1);
                    feedbackLabel.setText("Correct!");
                    currentIndex++;
                    if (currentIndex < exercises.size()) {
                        loadQuestion();
                    } else {
                        feedbackLabel.setText("Well done! You have completed all reading questions.");
                        submitButton.setEnabled(false);
                        answerField.setEditable(false);
                    }
                } else {
                    feedbackLabel.setText("Try again!");
                }
                answerField.setText("");
            }
        });
    }

    private void loadQuestion() {
        ReadingExercises current = exercises.get(currentIndex);
        passageArea.setText(current.getPassage());
        questionArea.setText("Question: " + current.getPrompt());
        feedbackLabel.setText(" ");
        answerField.setText("");
        answerField.requestFocusInWindow();
    }
}
