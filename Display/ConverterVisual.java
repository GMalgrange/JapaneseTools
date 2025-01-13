package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Converter.*;


public class ConverterVisual {
    private static JFrame mainFrame;
    private static JButton replyButton;
    private static JTextField textFieldAmnt;
    private static JTextField textFieldRate;
    private static JTextField resultLabel;
    
   // private String inputAmount = ""; // Variable to store the text entered
    public interface TextSubmitListener {
        void onTextSubmit(String text);
    }

    public JButton getReplyButton()
    {
        return replyButton;
    }

    public JTextField getTextAmount()
    {
        return textFieldAmnt;
    }

    public JTextField getTextRate()
    {
        return textFieldRate;
    }

    public JTextField getResultField()
    {
        return resultLabel;
    }

    // private void manageButtonListener()
    // {
    //         // Add an action listener to the button
    //         getReplyButton().addActionListener(new ActionListener() {
    //             YenConverter aConverter = new YenConverter();
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 // Get the text from the text field
    //                 if(!textFieldAmnt.getText().isEmpty())
    //                 {
    //                     String convertedJFormat = aConverter.convertEuroToYenWrapper(Long.valueOf(textFieldAmnt.getText()), textFieldRate.getText());
    //                     getResultField().setText("Converted Amount: " + convertedJFormat);    
    //                 }
    //                 else
    //                 {
    //                     getResultField().setText("Please enter an amount"); 
    //                 }
    //             }
    //         });
    // }

    public void setUpGUI()
    {
            // Method to create and display the GUI
            mainFrame = new JFrame("Euro to Yen Converter");
            mainFrame.setSize(400, 200);

            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container contentPane = mainFrame.getContentPane();
            contentPane.setSize(300, 180);

            GridBagLayout layout = new GridBagLayout();
            contentPane.setLayout(layout);
            GridBagConstraints gbc = new GridBagConstraints();

            // Create 2 text field and their labels
            JLabel label1 = new JLabel("Enter Amount in Euro:");
            textFieldAmnt = new JTextField(20);
            JLabel label2 = new JLabel("Enter Exchange rate: ");
            textFieldRate = new JTextField(20);
    
            // Create a Submit button
            replyButton = new JButton("Convert");
    
            // The results is displayed in a TextField to be selectable
            resultLabel = new JTextField ();
            resultLabel.setEditable(false);
            resultLabel.setBorder(null);
            resultLabel.setForeground(UIManager.getColor("Label.foreground"));
            resultLabel.setFont(UIManager.getFont("Label.font"));
    
            // gbc.fill = GridBagConstraints.HORIZONTAL;
            // gbc.gridx = 0;
            // gbc.gridy = 0;

            // Manage the Grid Layout
            gbc.gridx = 0;
            gbc.gridy = 0;
            contentPane.add(label1, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            contentPane.add(textFieldAmnt, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;
            contentPane.add(label2, gbc);
            gbc.gridx = 1;
            gbc.gridy = 1; 
            contentPane.add(textFieldRate, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;      
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 2;
            contentPane.add(replyButton, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 2;
            gbc.ipady = 20; 
            gbc.gridx = 1;
            gbc.gridy = 3;
            contentPane.add(resultLabel, gbc);

            /************************************************* */
            mainFrame.pack();
            // Make the frame visible
            mainFrame.setVisible(true);
    }
}
