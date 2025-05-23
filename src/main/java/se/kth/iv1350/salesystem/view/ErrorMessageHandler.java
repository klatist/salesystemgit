package se.kth.iv1350.salesystem.view;

/**
 * This class is responsible for printing information about exceptions being thrown
 * during program execution to the <code>view</code>. The messages are meant to suit the user
 * of the program.
 */
public class ErrorMessageHandler 
{
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();

    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    } 

    /**
     * Prints a message about the error that has occured that is appropriate for users of the program.
     * 
     * @param message  represents the message that should be shown to the user about the error that has occured.
     */
    public void showErrorMessage(String message){
        System.out.println("Error: " + message);
    }
}
