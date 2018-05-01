package ar.edu.untref.aydoo;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class FibonacciWriter {

    public void write(String fileName, String text) {
        File aFile = createFile(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(aFile.getAbsoluteFile());
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File createFile(String fileName) {
        File aFile = new File(fileName);
        if (!aFile.exists()) {
            try {
                aFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return aFile;
    }
}