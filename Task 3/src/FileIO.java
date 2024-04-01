import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileIO extends Frame implements ActionListener {
    private TextArea textArea;
    private File selectedFile;

    public FileIO() {
        setTitle("File I/O Program");
        setSize(500, 400);
        setLayout(new BorderLayout());

        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();
        Button openButton = new Button("Open File");
        Button saveButton = new Button("Save File");
        openButton.addActionListener(this);
        saveButton.addActionListener(this);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Open File")) {
            FileDialog fileDialog = new FileDialog(this, "Select File", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String filename = fileDialog.getFile();
            if (filename != null) {
                selectedFile = new File(fileDialog.getDirectory(), filename);
                readFile(selectedFile);
            }
        } else if (actionCommand.equals("Save File")) {
            if (selectedFile != null) {
                writeFile(selectedFile);
            } else {
                showMessage("No file is currently open.");
            }
        }
    }

    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            showMessage("Error reading file: " + e.getMessage());
        }
    }

    private void writeFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(textArea.getText());
            showMessage("File saved successfully.");
        } catch (IOException e) {
            showMessage("Error writing to file: " + e.getMessage());
        }
    }

    private void showMessage(String message) {
        JOptionPane JOptionPane = null;
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        FileIO program = new FileIO();
        program.setVisible(true);
    }
}
