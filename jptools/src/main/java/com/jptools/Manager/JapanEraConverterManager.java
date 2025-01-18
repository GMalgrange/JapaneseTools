package jptools.src.main.java.com.jptools.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jptools.src.main.java.com.jptools.Converter.JapanYearFormatConverter;
import jptools.src.main.java.com.jptools.Display.EraConverterVisual;

public class JapanEraConverterManager {
    
    public void DateConverterManager()
    {
        EraConverterVisual aVisual = new EraConverterVisual();
        aVisual.setUpGUI();
        aVisual.getReplyButton().addActionListener( new ActionListener() {
            JapanYearFormatConverter aConverter = new JapanYearFormatConverter();    
            @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the text from the text field
                    if(!aVisual.getInputYearField().getText().isEmpty())
                    {
                        String convertedJFormat = aConverter.ConvertDateToJapaneseFormat(aVisual.getInputYearField().getText());
                        System.out.println(convertedJFormat);
                        aVisual.getResultField().setText("Converted Date: " + convertedJFormat);    
                    }
                    else
                    {
                        aVisual.getResultField().setText("Please enter an Year"); 
                    }
                }
            });

        // System.out.println("Enter a Date in Georgian convention"); 
        // Scanner aScanner = new Scanner(System.in); 
        // String aDate = aScanner.nextLine();
        // System.out.println("Date entered is: " + aDate); 
        
        // aScanner.close();
        // aVisual.setUpGUI(aConverter.ConvertDateToJapaneseFormat(aDate));

    }
}
