package jptools.src.main.java.com.jptools.Display;

import javax.swing.*;
import java.awt.*;

public class EraConverterVisual {
    private static JTextField resultLabel;
    private static JFrame mainFrame;
    private static JTextField inputYear;
    private static JButton replyButton;

    public JTextField getResultField()
    {
        return resultLabel;
    }

    public JTextField getInputYearField()
    {
        return inputYear;
    }

    public JButton getReplyButton()
    {
        return replyButton;
    }

    public void setUpGUI()
    {
        mainFrame = new JFrame("Era Converter");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);

        GridBagLayout layout = new GridBagLayout();
        mainFrame.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label1 = new JLabel("Enter the year to convert");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainFrame.add(label1, gbc);
        inputYear = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainFrame.add(inputYear, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        replyButton = new JButton("Convert");
        
        mainFrame.add(replyButton, gbc);

        resultLabel = new JTextField ();
        resultLabel.setEditable(false);
        resultLabel.setBorder(null);
        resultLabel.setForeground(UIManager.getColor("Label.foreground"));
        resultLabel.setFont(UIManager.getFont("Label.font"));
        // resultLabel.setText(iLabel);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainFrame.add(resultLabel, gbc);

        /************************************************* */
        mainFrame.pack();
        // Make the frame visible
        mainFrame.setVisible(true);
    }
}
