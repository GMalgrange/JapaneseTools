package Converter;

import java.text.DecimalFormat;
import java.util.Map;

public class YenConverter {
    private static final Float kExchangeRateEuroToYen = Float.valueOf(160) ;

    private static final String kYenSymbol = "円";
    private static final Map<Integer, String> kJapaneseUnitMap = Map.ofEntries(
        Map.entry(3,"百"),
        Map.entry(4,"千"),
        Map.entry(5,"万"),
        Map.entry(9,"億"));

    private  String convertEuroToYen(Long iAmountToConvert, Float iExchangeRate)
    {
        //We don't want Yen decimal, truncate at 0
        return String.valueOf(new DecimalFormat("#").format(iAmountToConvert*iExchangeRate));
    }

    private String convertToJapaneseFormat(String iStringToConvert)
    {
        String oJapaneseFormat = kYenSymbol;
        for (int i = 1; i < iStringToConvert.length()+1; i++)
        {
            if((kJapaneseUnitMap.containsKey(i))
            && (iStringToConvert.charAt(iStringToConvert.length()-i) != '0'))
            {
                oJapaneseFormat= iStringToConvert.charAt(iStringToConvert.length()-i)+kJapaneseUnitMap.get(i) + oJapaneseFormat;
            }
            else{
                oJapaneseFormat=iStringToConvert.charAt(iStringToConvert.length()-i) + oJapaneseFormat;
            }
        }
        return oJapaneseFormat;
    }
    public String convertEuroToYenWrapper(Long iAmountToConvert, String iExchangeRate){

        Float aExchangeRate = Float.valueOf(0);
        if(!iExchangeRate.isEmpty() && (iExchangeRate != ""))
        {
            aExchangeRate = Float.parseFloat(iExchangeRate);
        }
        else{
            aExchangeRate = kExchangeRateEuroToYen;
        }

        String convertedAmount = convertEuroToYen(iAmountToConvert, aExchangeRate);
        System.out.println(convertedAmount);
        String aJapaneseFormat = "";
        aJapaneseFormat = convertToJapaneseFormat(convertedAmount);
        // System.out.println(aJapaneseFormat);
        return aJapaneseFormat;
    }
}