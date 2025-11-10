package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/*
  WritingSwingUI
  Example of my writing and spelling GUI, where spelling exercises would give a 
  scrambled word where kids would have to put it in order and get appropriate score and 
  afterwards for the writing part, they would get a prompt asking them random question, where they would have to answer 
  with 20 or more words.
 */
public class WritingSwingUI extends JFrame {

    private static final String WORD_SCRAMBLED = "C A T";
    private static final String WORD_HINT      = "animal that purrs";
    private static final String WORD_CORRECT   = "cat";
    private static final int    MIN_WORDS      = 20;

    private final JFrame mainMenuRef;
    private final CardLayout cards = new CardLayout();
    private final JPanel root = new JPanel(cards);

    private final JLabel lblScrambled = bigCenter("Unscramble: " + WORD_SCRAMBLED);
    private final JLabel lblHint      = center("Hint: " + WORD_HINT);
    private final JTextField txtAnswer = new JTextField();
    private final JButton btnSubmitSpell = new JButton("Submit Spelling");

    private final JLabel lblPrompt = boldCenter("Write about your best day (min " + MIN_WORDS + " words)");
    private final JTextArea txtResponse = new JTextArea(6, 32);
    private final JButton btnSubmitWriting = new JButton("Submit Writing");

    private final JLabel lblScore = center("Score: 0");
    private final JButton btnBack = new JButton("Back to Main Menu");

    private int score = 0;

    public WritingSwingUI(JFrame mainMenuRef) {
        super("Writing & Spelling");
        this.mainMenuRef = mainMenuRef;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(580, 460);
        setLocationRelativeTo(null);

        setContentPane(buildContent());
        wireEvents();
        showSpelling();
    }

    private JPanel buildContent() {
        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        content.setBackground(new Color(255, 247, 200)); // warm bright background

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(content.getBackground());
        top.add(lblScore, BorderLayout.CENTER);
        top.add(btnBack, BorderLayout.EAST);
        content.add(top, BorderLayout.NORTH);

        root.add(buildSpellingPanel(content.getBackground()), "SPELL");
        root.add(buildWritingPanel(content.getBackground()), "WRITE");
        content.add(root, BorderLayout.CENTER);

        return content;
    }

    private JPanel buildSpellingPanel(Color bg) {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(bg);

        JPanel north = new JPanel(new GridLayout(2, 1, 6, 6));
        north.setBackground(bg);
        north.add(lblScrambled);
        north.add(lblHint);
        p.add(north, BorderLayout.NORTH);

        txtAnswer.setFont(new Font("SansSerif", Font.PLAIN, 24)); // bigger text
        txtAnswer.setHorizontalAlignment(JTextField.CENTER);
        txtAnswer.setToolTipText("Type the word here");
        p.add(txtAnswer, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.setBackground(bg);
        south.add(btnSubmitSpell);
        p.add(south, BorderLayout.SOUTH);

        return p;
    }

    private JPanel buildWritingPanel(Color bg) {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(bg);

        p.add(lblPrompt, BorderLayout.NORTH);

        txtResponse.setFont(new Font("SansSerif", Font.PLAIN, 18)); // larger typing font
        txtResponse.setLineWrap(true);
        txtResponse.setWrapStyleWord(true);
        txtResponse.setToolTipText("Write your answer here…");
        p.add(new JScrollPane(txtResponse), BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.setBackground(bg);
        south.add(btnSubmitWriting);
        p.add(south, BorderLayout.SOUTH);

        return p;
    }

    private void wireEvents() {
        txtAnswer.registerKeyboardAction(
            e -> btnSubmitSpell.doClick(),
            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
            JComponent.WHEN_FOCUSED
        );

        btnSubmitSpell.addActionListener(e -> {
            String answer = txtAnswer.getText().trim().toLowerCase();
            if (answer.equals(WORD_CORRECT)) addScore(10, "Nice! +10 points");
            else info("Good try — the word was '" + WORD_CORRECT + "'.");
            txtAnswer.setText("");
            showWriting();
        });

        btnSubmitWriting.addActionListener(e -> {
            int words = wordCount(txtResponse.getText());
            if (words >= MIN_WORDS) {
                addScore(20, "Great job! +20 points");
                txtResponse.setText("");
                backToMenu();
            } else {
                info("Try to write at least " + MIN_WORDS + " words 🙂");
            }
        });

        btnBack.addActionListener(e -> backToMenu());
    }

    private void showSpelling() {
        lblScrambled.setText("Unscramble: " + WORD_SCRAMBLED);
        lblHint.setText("Hint: " + WORD_HINT);
        txtAnswer.requestFocusInWindow();
        cards.show(root, "SPELL");
    }

    private void showWriting() {
        lblPrompt.setText("Write about your best day (min " + MIN_WORDS + " words)");
        txtResponse.requestFocusInWindow();
        cards.show(root, "WRITE");
    }

    private void backToMenu() {
        dispose();
        if (mainMenuRef != null) mainMenuRef.setVisible(true);
    }

    private static JLabel center(String s) {
        JLabel l = new JLabel(s, SwingConstants.CENTER);
        l.setFont(new Font("SansSerif", Font.PLAIN, 16));
        return l;
    }

    private static JLabel bigCenter(String s) {
        JLabel l = center(s);
        l.setFont(new Font("SansSerif", Font.BOLD, 26));
        return l;
    }

    private static JLabel boldCenter(String s) {
        JLabel l = center(s);
        l.setFont(new Font("SansSerif", Font.BOLD, 20));
        return l;
    }

    private void addScore(int delta, String message) {
        score += delta;
        lblScore.setText("Score: " + score);
        info(message);
    }

    private static int wordCount(String text) {
        String t = text == null ? "" : text.trim();
        return t.isEmpty() ? 0 : t.split("\\s+").length;
    }

    private static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    
}
