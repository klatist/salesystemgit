package se.kth.iv1350.salesystem.view;

/**
 * This class is responsible for printing information about exceptions being thrown
 * during program execution to the <code>view</code>. The messages are meant to suit the user
 * of the program.
 */
class ErrorMessageHandler 
{
    /**
     * Prints a message about the error that has occured that is appropriate for users of the program.
     * 
     * @param message  represents the message that should be shown to the user about the error that has occured.
     */
    void showErrorMessage(String message){
        System.out.println("Error: " + message);
    }
}
