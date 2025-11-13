import javax.swing.*;
import java.awt.*;

public class WritingPanelGUI extends JPanel {
    private JLabel sentenceLabel;
    private JTextArea typingArea;
    private JButton submitButton;
    private JLabel feedbackLabel;

    private String targetSentence = "A hug is always the right size.";

    public WritingPanelGUI() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(220, 230, 241));

        sentenceLabel = new JLabel("<html><h3>Type this exactly:</h3><p>" + targetSentence + "</p></html>");
        sentenceLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        add(sentenceLabel, BorderLayout.NORTH);

        typingArea = new JTextArea(4, 40);
        typingArea.setLineWrap(true);
        typingArea.setWrapStyleWord(true);
        typingArea.setFont(new Font("Serif", Font.PLAIN, 16));
        add(new JScrollPane(typingArea), BorderLayout.CENTER);

        submitButton = new JButton("Check");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(submitButton, BorderLayout.CENTER);
        bottomPanel.add(feedbackLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> checkTyping());
    }

    private void checkTyping() {
        String typedText = typingArea.getText().trim();
        if (typedText.equals(targetSentence)) {
            feedbackLabel.setText("Correct! Well done!");
            typingArea.setEditable(false);
            submitButton.setEnabled(false);
        } else {
            feedbackLabel.setText("Incorrect. Please try again.");
        }
    }
}
