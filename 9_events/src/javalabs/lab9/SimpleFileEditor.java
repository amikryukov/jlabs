package javalabs.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleFileEditor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple File Editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.LINE_AXIS));

        final JLabel status = new JLabel("Status");

        final JTextField fileName = new JTextField("");
        fileName.setSize(300, 50);
        menu.add(new JLabel("File Name: "));
        menu.add(fileName);

        final JTextArea textArea = new JTextArea();
        textArea.setToolTipText("Area to edit text");

        JButton uploadButton = new JButton("Upload");
        uploadButton.setSize(100, 50);
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("upload button event " + e.getActionCommand());
                String fileNameText = fileName.getText();
                if (fileNameText.isEmpty()) {
                    status.setText("Can not upload file with NO Name");
                    return;
                }
                try {
                    String content = new String(Files.readAllBytes(Paths.get(fileNameText)));
                    textArea.setText(content);
                    status.setText("file '" + fileNameText + "' uploaded");
                } catch (Exception ex) {
                    status.setText("Exception while uploading file '" + fileNameText + "\'. " +
                    ex.getMessage());
                }

            }
        });
        menu.add(uploadButton);

        JButton saveButton = new JButton("Save");
        saveButton.setSize(100, 50);
        saveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("save button event " + e.getActionCommand());
                String fileNameText = fileName.getText();
                if (fileNameText.isEmpty()) {
                    status.setText("Can not save to NOWHERE");
                    return;
                }
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(fileNameText);
                    String content = textArea.getText();
                    writer.write(content);
                    status.setText("'" + fileNameText + "' saved");
                } catch (Exception ex) {
                    status.setText("Exception while saving file '" + fileNameText + "\'. " +
                            ex.getMessage());
                } finally {
                    if(writer != null) {
                        writer.close();
                    }
                }
            }
        });
        menu.add(saveButton);

        frame.getContentPane().add(menu, BorderLayout.PAGE_START);

        frame.getContentPane().add(textArea, BorderLayout.CENTER);

        frame.getContentPane().add(status, BorderLayout.PAGE_END);


        frame.setVisible(true);
    }
}
