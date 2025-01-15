package Converter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
// import java.util.Scanner;
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
        map.put(1865, "Meiji");
        return Collections.unmodifiableMap(map);
    }; 

    public String ConvertDateToJapaneseFormat(String iDate)
    {
        //We use Reference year to set up an interval between the start of an era and it's end
        String aConvertedYear = "";
        Integer aReferenceYear = Year.now().getValue();
        System.out.println(aReferenceYear);
        Integer aDateAsInteger = Integer.parseInt(iDate);
        for(Map.Entry<Integer,String> pair : kJapaneseCalendar.entrySet())
        {
            if((aDateAsInteger - pair.getKey() == 0))
            {
                aConvertedYear = pair.getValue() +" 0";
                break;
            }
            else if(((aDateAsInteger - pair.getKey()) > 0)
            && (aDateAsInteger - aReferenceYear) < 0)
            {
                System.out.println("Map year: "+pair.getKey());
                aReferenceYear = pair.getKey();
                aConvertedYear = pair.getValue() +" "+ String.valueOf(aDateAsInteger - aReferenceYear);
            }
        }

        System.out.println(aConvertedYear);

        return aConvertedYear;
    }
}
