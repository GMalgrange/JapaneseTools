package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Converter.*;

public class Prompt {
    
    private String inputAmount = ""; // Variable to store the text entered
    public interface TextSubmitListener {
        void onTextSubmit(String text);
    }

    private TextSubmitListener listener; // Callback listener

    // Method to register the callback listener
    public void setTextSubmitListener(TextSubmitListener listener) {
        this.listener = listener;
    }

    public void promptAmount(String oMessage) {

        // Method to create and display the GUI
            // Create a new JFrame (main window)
            JFrame frame = new JFrame("Euro to Yen Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container contentPane = frame.getContentPane();
            contentPane.setSize(400, 200);

            GridLayout layout = new GridLayout(0,2);
            contentPane.setLayout(layout);
    
            // Create a text field (text box)
            JTextField textFieldAmnt = new JTextField(20);
            JTextField textFieldRate = new JTextField(20);
    
            // Create a button
            JButton button = new JButton("Convert");
    
            // Create a label to display the result (optional)
            JLabel resultLabel = new JLabel(oMessage);
    
            // Add an action listener to the button
            button.addActionListener(new ActionListener() {
                YenConverter aConverter = new YenConverter();
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the text from the text field
                    inputAmount = textFieldAmnt.getText(); // Update the inputAmount variable
                    System.out.println("Text entered: " + inputAmount);
                    if(!inputAmount.isEmpty())
                    {
                        String convertedJFormat = aConverter.convertEuroToYenWrapper(Long.valueOf(inputAmount), textFieldRate.getText());
                        resultLabel.setText("Converted Amount: " + convertedJFormat);    
                    }
                    else
                    {
                        resultLabel.setText("Please enter an amount"); 
                    }
                                    // Notify the listener (if registered)
                if (listener != null) {
                    listener.onTextSubmit(inputAmount);
                }
                }
            });
    
            // Add components to the frame
            JLabel label1 = new JLabel("Enter Amount in Euro:");
            JLabel label2 = new JLabel("Enter Exchange rate: ");
            contentPane.add(label1);
            contentPane.add(textFieldAmnt);
            contentPane.add(label2);
            contentPane.add(textFieldRate);
            contentPane.add(button);
            contentPane.add(resultLabel);

            /************************************************* */
            frame.pack();
            // Make the frame visible
            frame.setVisible(true);
    }
    // Method to retrieve the input text

    
}
