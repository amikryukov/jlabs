package javalabs.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Console application to replace symbols in file and show result on console
 */
public class App {
    private final static String USAGE =
            "3 parameters should be present : [fileName] [symbolToReplace] [symbolToSet]";

    public static void main(String[] args) {
        System.out.println(new File(".").getAbsoluteFile());

        String fileName = null;
        try {
            fileName = args[0];
            char toReplace = parseChar(args[1]);
            char replacement = parseChar(args[2]);

            SimpleSymbolReplacer.showNewContent(fileName, toReplace, replacement);

            System.out.println("<><><><><><><><><><>");
            LineByLineSymbolReplacer.showNewContent(fileName, toReplace, replacement);
        } catch (IllegalArgumentException|IndexOutOfBoundsException e) {
            System.err.println(USAGE);
        } catch (FileNotFoundException e) {
            System.err.println("Can not find file '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unexpected error while reading file: " + e.getMessage());
        }
    }

    /**
     * Parses String as single char
     * @param str input string
     * @return parsed character
     * @throws java.lang.IllegalArgumentException in case if string length is not 1
     */
    private static char parseChar(String str) throws IllegalArgumentException {
        if(str.length() != 1) {
            throw new IllegalArgumentException();
        }
        return str.charAt(0);
    }
}
