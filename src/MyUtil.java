import java.util.Scanner;

public class MyUtil {

    /***
     *
     * @param msg the message to prompt the user
     * @param last to determine if the read stream should be closed;
     * @return return the user input as a string
     */
    public static String getInput(String msg, int last) {
        Scanner reader = new Scanner(System.in);
        System.out.println(msg);
        String output = reader.next();
        if(last == 1) {
            reader.close();
        }
        return output;
    }

}

