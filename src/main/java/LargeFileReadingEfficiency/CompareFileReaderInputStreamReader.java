package LargeFileReadingEfficiency;

import java.io.*;

public class CompareFileReaderInputStreamReader  {
    public static void fileReader(String fileName) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(fileName);
            int i;
            while((i=fileReader.read())!=-1);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void inputStreamReader(String fileName) throws FileNotFoundException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
            int i;
            while((i=inputStreamReader.read())!=-1);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        String file="largefile.txt";

        long startTime = System.currentTimeMillis();
        fileReader(file);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by fileReader: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        inputStreamReader(file);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by InputStreamReader: " + (endTime - startTime));
    }
}


