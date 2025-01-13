package Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Converter.*;

public class Prompt {
    
    private String inputText = ""; // Variable to store the text entered
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
            JFrame frame = new JFrame("Text Box Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new FlowLayout());
    
            // Create a text field (text box)
            JTextField textFieldAmnt = new JTextField(20);
            JTextField textFieldRate = new JTextField(20);
    
            // Create a button
            JButton button = new JButton("Submit");
    
            // Create a label to display the result (optional)
            JLabel resultLabel = new JLabel(oMessage);
    
            // Add an action listener to the button
            button.addActionListener(new ActionListener() {
                YenConverter aConverter = new YenConverter();
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the text from the text field
                    inputText = textFieldAmnt.getText(); // Update the inputText variable
                    System.out.println("Text entered: " + inputText);
                    String convertedJFormat = aConverter.convertEuroToYenWrapper(Long.valueOf(inputText), textFieldRate.getText());
                    resultLabel.setText("Converted Amount: " + convertedJFormat);

                                    // Notify the listener (if registered)
                if (listener != null) {
                    listener.onTextSubmit(inputText);
                }
                }
            });
    
            // Add components to the frame
            frame.add(new JLabel("Enter some text:"));
            frame.add(textFieldAmnt);
            frame.add(textFieldRate);
            frame.add(button);
            frame.add(resultLabel);
    
            // Make the frame visible
            frame.setVisible(true);
    }
    // Method to retrieve the input text

    
}
