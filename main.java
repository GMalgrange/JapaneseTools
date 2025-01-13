import Manager.ConverterManager;

public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Choose an option\n 1 for Euro to Yen Converter");

    String option = myObj.nextLine();  // Read user input
    System.out.println("Username is: " + option);
    if(option.equals("1"))
    {
        System.out.println("Booting Euro to Yen Converter");
        ConverterManager aManager = new ConverterManager();
        aManager.manageConverter();
    }
    myObj.close();
}
