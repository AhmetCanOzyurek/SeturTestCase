package readers.textFiles;

import java.io.*;
import java.util.Scanner;

public class TextFileReader {
    public static String readTextFile(String fileName) {
        try {
            String file = "src/test/resources/datafiles/textFiles/" + fileName + ".txt";
            FileReader fileReader = new FileReader(file);

            Scanner sc = new Scanner(new File(file));
            String fileText = "";
            while (sc.hasNext()) {
                fileText = sc.nextLine();
            }
            return fileText;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeTextFile(String fileName, String text) {
        String file = "src/test/resources/datafiles/textFiles/" + fileName + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(text);

            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearTextFile(String fileName) {
        String filePath = "src/test/resources/datafiles/textFiles/" + fileName + ".txt";
        try {
            FileReader fr = new FileReader(filePath);
            File tempFile = new File("geciciDosya.txt");
            FileWriter fw = new FileWriter(tempFile);

            int karakter;

            while ((karakter = fr.read()) != -1) {

                fw.write("");
            }

            fr.close();
            fw.close();

            tempFile.renameTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
