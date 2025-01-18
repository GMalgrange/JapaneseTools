package jptools.src.main.java.com.jptools.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jptools.src.main.java.com.jptools.Converter.YenConverter;
import jptools.src.main.java.com.jptools.Display.ConverterVisual;

public class ConverterManager {

    public void manageConverter(){
        ConverterVisual aVisual = new ConverterVisual();
            aVisual.setUpGUI();
            aVisual.getReplyButton().addActionListener(new ActionListener() {
                YenConverter aConverter = new YenConverter();
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the text from the text field
                    if(!aVisual.getTextAmount().getText().isEmpty())
                    {
                        String convertedJFormat = aConverter.convertEuroToYenWrapper(Long.valueOf(aVisual.getTextAmount().getText()), aVisual.getTextRate().getText());
                        aVisual.getResultField().setText("Converted Amount: " + convertedJFormat);    
                    }
                    else
                    {
                        aVisual.getResultField().setText("Please enter an amount"); 
                    }
                }
            });
    }
   
}
