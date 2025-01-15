package Manager;

import java.util.Scanner;
import Converter.JapanYearFormatConverter;

public class JapanEraConverterManager {
    
    public void DateConverterManager()
    {
        System.out.println("Enter a Date in Georgian"); 
        Scanner aScanner = new Scanner(System.in); 
        String aDate = aScanner.nextLine();
        System.out.println("Date entered is: " + aDate); 
        JapanYearFormatConverter aConverter = new JapanYearFormatConverter();
        aConverter.ConvertDateToJapaneseFormat(aDate);
        aScanner.close();
    }
}
