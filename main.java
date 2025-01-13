import Utils.Prompt;
public static void main(String[] args) {

    Prompt aPrompt = new Prompt();

    aPrompt.setTextSubmitListener(new Prompt.TextSubmitListener() {
        @Override
        public void onTextSubmit(String text) {
            // Handle the text submitted from the GUI
            System.out.println("Text received in Main: " + text);
        }
    });
    aPrompt.promptAmount("Please input a Value in Euro");
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
}
