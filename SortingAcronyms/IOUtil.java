import java.io.IOException;

public class IOUtil {

    /**
     * Asks for a string and returns it as the value of the function
     * @param   prompt    String to print, asking a question
     * @return  The string the user entered (maximum 100 chars long)
     */
    public static String getString(String prompt)
    {
        String stringInput;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer,0,200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        stringInput = new String(buffer);
        stringInput = stripTerminators(stringInput);
        return stringInput;
    }

    /**
     * Asks for an integer and returns it as the value of the function
     * @param   prompt    String to print, asking a question
     * @return value entered. If not an integer, prints an error message
     * and returns -999
     */
    public static int getInteger(String prompt)
    {
        int value = -999;
        String stringInput;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.println(prompt);
        try
        {
            readBytes = System.in.read(buffer,0,200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        stringInput = new String(buffer);
        stringInput = stripTerminators(stringInput);
        try
        {
            value = Integer.parseInt(stringInput);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered");
        }
        return value;
    }

    /**
     * Check for both Windows and Linux terminators. Remove both
     * \r and \n
     * @param fullString    String from the keyboard
     * @return string without terminators
     */
    private static String stripTerminators(String fullString)
    {
        int pos = fullString.indexOf("\r");
        if (pos < 0) // no carriage return
            pos = fullString.indexOf("\n"); // check linefeed
        if (pos >= 0)  // if either terminator
            fullString = fullString.substring(0,pos);
        // chop off the terminator(s)
        return fullString;
    }


}
