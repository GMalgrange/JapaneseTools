import Converter.YenConverter;
import Display.ConverterVisual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import javax.swing.JTextField;
public static void main(String[] args) {

    ConverterVisual aPrompt = new ConverterVisual();
    aPrompt.setUpGUI();   
    aPrompt.getReplyButton().addActionListener(new ActionListener() {
        YenConverter aConverter = new YenConverter();
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the text from the text field
            if(!aPrompt.getTextAmount().getText().isEmpty())
            {
                String convertedJFormat = aConverter.convertEuroToYenWrapper(Long.valueOf(aPrompt.getTextAmount().getText()), aPrompt.getTextRate().getText());
                aPrompt.getResultField().setText("Converted Amount: " + convertedJFormat);    
            }
            else
            {
                aPrompt.getResultField().setText("Please enter an amount"); 
            }
        }
    });
}
