import java.awt.*;
import java.awt.event.*;

public class OnlineVotingSystem extends Frame implements ActionListener {
    private String[] candidates = {"Candidate 1", "Candidate 2", "Candidate 3"};
    private int[] votes = new int[candidates.length];
    private Choice candidateChoice;
    private TextArea resultsArea;

    public OnlineVotingSystem() {
        setTitle("Online Voting System");
        setSize(400, 300);
        setLayout(new BorderLayout());

        Panel votePanel = new Panel();
        votePanel.setLayout(new FlowLayout());
        candidateChoice = new Choice();
        for (String candidate : candidates) {
            candidateChoice.add(candidate);
        }
        Button voteButton = new Button("Vote");
        voteButton.addActionListener(this);
        votePanel.add(candidateChoice);
        votePanel.add(voteButton);
        add(votePanel, BorderLayout.NORTH);

        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        add(resultsArea, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCandidate = candidateChoice.getSelectedItem();
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i].equals(selectedCandidate)) {
                votes[i]++;
                break;
            }
        }
        displayResults();
    }

    private void displayResults() {
        StringBuilder resultText = new StringBuilder("Voting Results:\n");
        for (int i = 0; i < candidates.length; i++) {
            resultText.append(candidates[i]).append(": ").append(votes[i]).append(" votes\n");
        }
        resultsArea.setText(resultText.toString());
    }

    public static void main(String[] args) {
        OnlineVotingSystem system = new OnlineVotingSystem();
        system.setVisible(true);
    }
}
