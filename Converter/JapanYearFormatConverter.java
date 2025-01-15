package Converter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.time.*;

public class JapanYearFormatConverter {
    //     Map.entry(2018, "令和"),
    //     Map.entry(1989, "平成"),
    //     Map.entry(1922, "昭和"),
    //     Map.entry(1912, "大正"),
    //     Map.entry(1865, "明治")
    // map.put(2019, "Reiwa");
    // map.put(1989, "Heisei");
    // map.put(1926, "Shouwa");
    // map.put(1912, "Taishou");
    // map.put(1865, "Meiji");

    private static final Map<Integer ,String> kJapaneseCalendar = initMap();
    private static Map<Integer, String> initMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(2019, "令和");
        map.put(1989, "平成");
        map.put(1926, "昭和");
        map.put(1912, "大正");
        map.put(1865, "明治");
        return Collections.unmodifiableMap(map);
    }; 

    public String ConvertDateToJapaneseFormat(String iDate)
    {
        //We use Reference year to set up an interval between the start of an era and it's end
        String aConvertedYear = "";
        Integer aReferenceYear = Year.now().getValue();
        Integer aDateAsInteger = Integer.parseInt(iDate);
        if((aDateAsInteger > aReferenceYear)
        || (aDateAsInteger < 1865))
        {
            return "Invalid Date";
        }
        for(Map.Entry<Integer,String> pair : kJapaneseCalendar.entrySet())
        {
            System.out.println("Ref year "+aReferenceYear);
            System.out.println("Map Year "+pair.getKey());
            if((aDateAsInteger - pair.getKey() == 0))
            {
                aConvertedYear = pair.getValue() +" 0";
                break;
            }
            else if(((aDateAsInteger - pair.getKey()) > 0)
            && (aDateAsInteger - aReferenceYear) < 0)
            {
                aReferenceYear = pair.getKey();
                aConvertedYear = pair.getValue() +" "+ String.valueOf(aDateAsInteger - aReferenceYear);
            }
        }

        System.out.println(aConvertedYear);

        return aConvertedYear;
    }
}
