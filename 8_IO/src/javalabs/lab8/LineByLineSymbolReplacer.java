package javalabs.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads content line by line
 */
public class LineByLineSymbolReplacer {

    protected static void showNewContent(String fileName, char oldChar, char newChar) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            if (oldChar == '\n') {
                System.out.print(line + newChar);
            } else {
                System.out.println(line.replace(oldChar, newChar));
            }
        }
    }
}
