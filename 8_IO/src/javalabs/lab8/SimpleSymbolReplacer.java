package javalabs.lab8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Reads content to String, then make replacement
 */
public class SimpleSymbolReplacer {

    protected static void showNewContent(String fileName, char oldChar, char newChar) throws IOException {
        String fileContent = new String(Files.readAllBytes(new File(fileName).toPath()));

        System.out.println(fileContent.replace(oldChar, newChar));
    }


}
