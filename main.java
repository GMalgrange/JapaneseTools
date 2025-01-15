import java.util.Scanner;

import Manager.ConverterManager;
import Manager.JapanEraConverterManager;

public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Choose an option\n1 for Euro to Yen Converter\n2 For Japanese Year system Converter");

    String option = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + option);
    if(option.equals("1"))
    {
        System.out.println("Booting Euro to Yen Converter");
        ConverterManager aManager = new ConverterManager();
        aManager.manageConverter();
    }
    else if(option.equals("2")){
        System.out.println("Booting Year format Converter");
        JapanEraConverterManager aConverter = new JapanEraConverterManager();
        aConverter.DateConverterManager();
    }
    myObj.close();
}
