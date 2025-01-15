import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.*;

public class JapanYearFormatConverter {
    // private static final Map<Integer ,String> kJapaneseCalendar = Map.ofEntries(
    //     Map.entry(2018, "令和"),
    //     Map.entry(1989, "平成"),
    //     Map.entry(1922, "昭和"),
    //     Map.entry(1912, "大正")
    // ); 
    private static final Map<Integer ,String> kJapaneseCalendar = initMap();
    private static Map<Integer, String> initMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(2019, "Reiwa");
        map.put(1989, "Heisei");
        map.put(1926, "Shouwa");
        map.put(1912, "Taishou");
        return Collections.unmodifiableMap(map);
    }; 

    private String ConvertDateToJapaneseFormat(String iDate)
    {
        String aConvertedYear = "";
        Integer aReferenceYear = Year.now().getValue();
        System.out.println(aReferenceYear);
        Integer aDateAsInteger = Integer.parseInt(iDate);
        for(Map.Entry<Integer,String> pair : kJapaneseCalendar.entrySet())
        {
            if(((aDateAsInteger - pair.getKey()) > 0)
            && (aDateAsInteger - aReferenceYear) < 0)
            {
                System.out.println("Map year: "+pair.getKey());
                aReferenceYear = pair.getKey();
                aConvertedYear = String.valueOf(aDateAsInteger - aReferenceYear) + pair.getValue();
            }
        }
        // String aDateJpFormat = String.valueOf();
        // Date myDate;
        // String aDate = iDate;
        // DateFormat df = DateFormat.getDateInstance();
        // try {
        //     myDate = df.parse(aDate);
        // } catch (ParseException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        System.out.println(aConvertedYear);

        return aConvertedYear;
    }

    public void DateConverterManager()
    {
        System.out.println("Enter a Date in Georgian"); 
        Scanner aScanner = new Scanner(System.in); 
        String aDate = aScanner.nextLine();  // Read user input
        System.out.println("Date entered is: " + aDate); 
        ConvertDateToJapaneseFormat(aDate);
        aScanner.close();
    }
}
