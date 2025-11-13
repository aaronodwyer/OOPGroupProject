import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VocabularyPage extends JPanel {
    private VocabularyExercises exercise;
    private User user;
    private JLabel quoteLabel;
    private JLabel wordLabel;
    private JPanel choicesPanel;
    private JLabel feedbackLabel;

    public VocabularyPage(VocabularyExercises exercise, User user) {
        this.exercise = exercise;
        this.user = user;
        setBackground(new Color(255, 218, 193)); // Soft orange

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        quoteLabel = new JLabel("<html><center>“Words are, in my not-so-humble opinion, our most inexhaustible source of magic.”<br>– Albus Dumbledore</center></html>");
        quoteLabel.setFont(new Font("Georgia", Font.ITALIC, 20));
        quoteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 18)));
        add(quoteLabel);

        wordLabel = new JLabel("What does ‘inexhaustible’ mean?");
        wordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 16)));
        add(wordLabel);

        // Multiple choice options
        choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(3, 1, 10, 10));
        choicesPanel.setMaximumSize(new Dimension(300, 120));
        JRadioButton option1 = new JRadioButton("Endless");
        JRadioButton option2 = new JRadioButton("Limited");
        JRadioButton option3 = new JRadioButton("Rare");
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        choicesPanel.add(option1);
        choicesPanel.add(option2);
        choicesPanel.add(option3);
        add(choicesPanel);

        JButton submitButton = new JButton("Check Answer");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(174, 213, 129));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 14)));
        add(submitButton);

        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        feedbackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(feedbackLabel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    feedbackLabel.setText("You are correct! ‘Endless’ is a another way to describe ‘inexhaustible’.");
                    user.updateScore(1);
                    submitButton.setEnabled(false);
                    option1.setEnabled(false);
                    option2.setEnabled(false);
                    option3.setEnabled(false);
                } else if (option2.isSelected() || option3.isSelected()) {
                    feedbackLabel.setText("Try again. Think of something that doesn't run out!");
                } else {
                    feedbackLabel.setText("Please choose an answer.");
                }
            }
        });
    }
}
