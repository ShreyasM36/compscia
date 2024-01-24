import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.io.File;

public class csia {
    private JTextArea importCSVFileHereTextArea;
    private JPanel ImportCsvFile;
    private JButton induvidualFeedbackButton;
    private JButton groupFeedbackButton;
    private JButton uploadCSVHereButton;

    public csia() {
        induvidualFeedbackButton.addActionListener(new ActionListener() {  //creates a button that when clicked, performs and gives induvidual feedback
            @Override
            public void actionPerformed(ActionEvent e) {
                //*ItemController.load();

            }
        });
        groupFeedbackButton.addActionListener(new ActionListener() {     //creates a button that when clicked, performs a gives group feedback
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        uploadCSVHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==uploadCSVHereButton) {
                    JFileChooser fileChooser = new JFileChooser();

                    fileChooser.setCurrentDirectory(new File("."));

                    int response = fileChooser.showSaveDialog(null);
                    if(response == JFileChooser.APPROVE_OPTION) {

                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                    }

                }
              /*  JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fileChooser.setCurrentDirectory(new File(".")); //sets current directory
                    int response = fileChooser.showSaveDialog(null); //select file to save

                    if(response == JFileChooser.APPROVE_OPTION) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                        System.out.println(file);
                    }

                } */
            }
        });
    }
}
