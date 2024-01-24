import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BasicGUI {
    public static void main(String[] args) {
        // Create a new JFrame container
        JFrame frame = new JFrame("Advanced GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel with GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.setPreferredSize(new Dimension(800, 400));

        // Create the import button with GridLayout
        JPanel firstPanel = new JPanel(new GridLayout(1, 1));
        firstPanel.setPreferredSize(new Dimension(800, 150));

        // Create and add components to the import button
        JButton importCSVButton = new JButton("Import CSV File here and Click the button to proceed with");
        importCSVButton.setPreferredSize(new Dimension(800, 100));
        firstPanel.add(importCSVButton);


        // Create the individual feedback button panel with GridLayout
        JPanel thirdPanel = new JPanel(new GridLayout(1, 1));
        thirdPanel.setPreferredSize(new Dimension(800, 100));

        // Create and add components to the panel
        JButton InFeedback = new JButton("Get Individual Feedback");
        InFeedback.setPreferredSize(new Dimension(790, 50));
        thirdPanel.add(InFeedback);

        JButton GFeedback = new JButton("Get Group Feedback");
        GFeedback.setPreferredSize(new Dimension(10, 50));
        thirdPanel.add(GFeedback);

        // Create the "4th" panel for adding labels under the buttons
        JPanel fourthPanel = new JPanel(new GridLayout(1,1));
        fourthPanel.setPreferredSize(new Dimension(800, 100));

        //components in the panel (label)
        JLabel label = new JLabel("Hope you enjoy the application", SwingConstants.CENTER);
        fourthPanel.add(label);

        // Add the panels to the main panel (buttons and label)
        mainPanel.add(firstPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        // Add the main panel to the frame
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        // Pack the frame and set its size and location
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 400);

        // Show the frame
        frame.setVisible(true);

        importCSVButton.addActionListener(new ActionListener() {   //button listeners to add functionaliy to the buttons
            @Override
            public void actionPerformed(ActionEvent e) {  //allowing file upload and saving
                if(e.getSource()==importCSVButton) {
                    JFileChooser fileChooser = new JFileChooser();

                    fileChooser.setCurrentDirectory(new File("."));

                    int response = fileChooser.showSaveDialog(null);
                    if(response == JFileChooser.APPROVE_OPTION) {

                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        String fileName = file.getName();
                        if (fileName.endsWith(".csv")) {
                            label.setText("Selected file is a CSV file: " + fileName);
                        } else {
                            label.setText("Selected file is not a CSV file: " + fileName);
                        }
                    }

                }
            }
        });

        GFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  // Upload a file into the GUI and save it before analysing it to give group feedback
                if(e.getSource()==GFeedback) {
                    JFileChooser fileChooser = new JFileChooser();

                    fileChooser.setCurrentDirectory(new File("."));
                    String filename = null;
                    int response = fileChooser.showSaveDialog(null);
                    if(response == JFileChooser.APPROVE_OPTION) {

                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        String fileName = file.getName();
                        if (fileName.endsWith(".csv")) {
                            label.setText("Selected file is a CSV file: " + fileName);
                        } else {
                            label.setText("Selected file is not a CSV file: " + fileName);
                        }
                    }


                }


            }


        });

        InFeedback.addActionListener(new ActionListener() {   //button listeners to add functionaliy to the buttons
            @Override
            public void actionPerformed(ActionEvent e) {  //allowing file upload and saving
                if(e.getSource()==InFeedback) {
                    JFileChooser fileChooser = new JFileChooser();

                    fileChooser.setCurrentDirectory(new File("."));

                    int response = fileChooser.showSaveDialog(null);
                    if(response == JFileChooser.APPROVE_OPTION) {

                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                        String fileName = file.getName();
                        if (fileName.endsWith(".csv")) {
                            label.setText("Selected file is a CSV file: " + fileName);
                        } else {
                            label.setText("Selected file is not a CSV file: " + fileName);
                        }
                    }

                }

            }
        });


    }
}