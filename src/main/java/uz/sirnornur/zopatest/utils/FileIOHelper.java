package uz.sirnornur.zopatest.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for convenient writing/reading to/from text file.
 *
 * @author Siroj Matchanov (sirnornur@gmail.com, skype:sirnornur)
 */
public class FileIOHelper {
    public static String readFileContents(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = null;

        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line).append("\n");
        }

        bufferedReader.close();
        return builder.toString();
    }

}
