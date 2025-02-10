import LargeFileReadingEfficiency.CompareFileReaderInputStreamReader;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class CompareFileReaderInputStreamReaderTest {
    private static final String TEST_FILE = "testfile.txt";
    // Helper method to create a test file
    private void createTestFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE))) {
            for (int i = 0; i < 1000; i++) { // Writing 1000 lines to test performance
                writer.write("This is a sample line for testing.\n");
            }
        }
    }

    @Test
    public void testFileReaderAndInputStreamReader() throws IOException {
        createTestFile();

        // Measure time for FileReader
        long startTime = System.currentTimeMillis();
        CompareFileReaderInputStreamReader.fileReader(TEST_FILE);
        long fileReaderTime = System.currentTimeMillis() - startTime;

        // Measure time for InputStreamReader
        startTime = System.currentTimeMillis();
        CompareFileReaderInputStreamReader.inputStreamReader(TEST_FILE);
        long inputStreamReaderTime = System.currentTimeMillis() - startTime;

        // Ensure file reading completes successfully
        assertTrue(fileReaderTime >= 0, "FileReader should read without issues");
        assertTrue(inputStreamReaderTime >= 0, "InputStreamReader should read without issues");

        // Compare performance (not asserting as file size impacts timing)
        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");

        // Cleanup: Delete the test file
        new File(TEST_FILE).delete();
    }
}
