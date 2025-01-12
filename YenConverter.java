//This is the project root
import java.util.Scanner;
// import Utils.Prompt;
// import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Map;
// import java.util.StringTokenizer;

public static final Float kExchangeRateEuroToYen = Float.valueOf(160) ;
public static final Map<Integer, String> kUnitMap = Map.ofEntries(
    Map.entry(3,"H"),
    Map.entry(4,"S"),
    Map.entry(5,"M"),
    Map.entry(9,"O"));

public static String convertEuroToYen(Long iAmountToConvert, Float iExchangeRate)
{
    return String.valueOf(new DecimalFormat("#").format(iAmountToConvert*iExchangeRate));
}
// private static String aAmount = "Amount";
public static void main(String[] args) {

    // Prompt aPrompt = new Prompt();

    // aPrompt.setTextSubmitListener(new Prompt.TextSubmitListener() {
    //     @Override
    //     public void onTextSubmit(String text) {
    //         // Handle the text submitted from the GUI
    //         System.out.println("Text received in Main: " + text);
    //         aAmount = text;
    //     }
    // });
    // aPrompt.promptAmount("Please input a Value in Euro");
    // new Thread(() -> {
    //     try {
    //         // Wait until the user submits text
    //         while (aAmount.isEmpty()) {
    //             Thread.sleep(100); // Check periodically
    //         }

    //         // Once the text is available, process it
    //         System.out.println("Processing the submitted text: " + aAmount);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }).start();

    System.out.println("Enter the current exchange rate");

    Scanner in1 = new Scanner(System.in);
    String aInputExchangeRate = in1.nextLine();
    Float aExchangeRate = Float.valueOf(0);
    if(aInputExchangeRate != "")
    {
        aExchangeRate = Float.parseFloat(aInputExchangeRate);
    }
    else{
        aExchangeRate = kExchangeRateEuroToYen;
    }
    
    System.out.println("Enter a value in euro");
    Scanner in2 = new Scanner(System.in);
    String aInputValue = in2.nextLine();
    Long aValueEuro = Long.parseLong(aInputValue);


    String convertedAmount = convertEuroToYen(aValueEuro, aExchangeRate);
    System.out.println(convertedAmount);
    // StringTokenizer aTokenizer = new StringTokenizer(convertedAmount,".");
    String aJapaneseFormat = "";
    for (int i = 1; i < convertedAmount.length()+1; i++)
    {
        if(kUnitMap.containsKey(i))
        {
            aJapaneseFormat= convertedAmount.charAt(convertedAmount.length()-i)+kUnitMap.get(i) + aJapaneseFormat;
        }
        else{
            aJapaneseFormat=convertedAmount.charAt(convertedAmount.length()-i) + aJapaneseFormat;
        }
    }
    System.out.println(aJapaneseFormat);
    in2.close();
    in1.close();
}