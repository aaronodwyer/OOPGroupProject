import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel contentPanel;
    private Library library;
    private User user;

    public MainMenu() {
        setTitle("Kid Learning App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        library = new Library();
        user = new User("Sophie");

        library.addReadingExercise(new ReadingExercises(
                "Tom Sawyer and his best friend Huckleberry Finn went fishing at the river.",
                "Who is Tom’s best friend?",
                "Huckleberry Finn"
        ));

        library.addReadingExercise(new ReadingExercises(
                "Tom yelled out “I Think I have a fish”, to which Huckleberry Finn replied “You gotta make sure you reel it in boy”.",
                "What did Huckleberry Finn tell Tom to do?",
                "reel it in"
        ));

        VocabularyExercises vocabExercise = new VocabularyExercises(
                "Words are, in my not-so-humble opinion, our most inexhaustible source of magic.",
                "inexhaustible",
                "What does 'inexhaustible' mean?",
                "Endless"
        );
        library.addVocabularyExercise(vocabExercise);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 1, 8, 8));
        buttonsPanel.setBackground(new Color(255, 249, 196));
        buttonsPanel.setPreferredSize(new Dimension(200, 1));

        JButton readingBtn = new JButton("Reading");
        JButton vocabBtn = new JButton("Vocabulary");
        JButton writingBtn = new JButton("Writing");

        readingBtn.setFont(new Font("Arial", Font.BOLD, 18));
        readingBtn.setBackground(new Color(174, 213, 129));
        vocabBtn.setFont(new Font("Arial", Font.BOLD, 18));
        vocabBtn.setBackground(new Color(255, 138, 128));
        writingBtn.setFont(new Font("Arial", Font.BOLD, 18));
        writingBtn.setBackground(new Color(249, 168, 212));

        buttonsPanel.add(readingBtn);
        buttonsPanel.add(vocabBtn);
        buttonsPanel.add(writingBtn);

        contentPanel = new JPanel(new BorderLayout());
        JLabel welcome = new JLabel("Welcome! Please pick an activity.", JLabel.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(welcome);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonsPanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        readingBtn.addActionListener(e -> showReading());
        vocabBtn.addActionListener(e -> showVocab());
        writingBtn.addActionListener(e -> showWriting());
    }

    private void showReading() {
        contentPanel.removeAll();
        if (!library.getReadingExercises().isEmpty())
            contentPanel.add(new ReadingPage(library.getReadingExercises(), user), BorderLayout.CENTER);
        else
            contentPanel.add(new JLabel("No reading exercises found.", JLabel.CENTER), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void showVocab() {
        contentPanel.removeAll();
        if (!library.getVocabularyExercises().isEmpty())
            contentPanel.add(new VocabularyPage(library.getVocabularyExercises().get(0), user), BorderLayout.CENTER);
        else
            contentPanel.add(new JLabel("No vocabulary exercises found.", JLabel.CENTER), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void showWriting() {
        contentPanel.removeAll();
        contentPanel.add(new WritingPanelGUI(), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
