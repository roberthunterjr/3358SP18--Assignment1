import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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

    public static List<String> getLines(String relativePath){
        Charset cs = Charset.defaultCharset();
        try {
            List<String> lines = Files.readAllLines(Paths.get(relativePath), cs);
            return lines;
        } catch (IOException e){
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}

