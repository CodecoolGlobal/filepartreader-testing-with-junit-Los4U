import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader;
    String patchForTest2txt = "C:\\Users\\Kamil Woś\\IdeaProjects\\filepartreader-testing-with-junit-Los4U\\resources\\test2.txt";

    @BeforeEach
    void createNewFilePartReader() {
        this.filePartReader =  new FilePartReader();
    }

    @Test
    @DisplayName("Test READLINES method before setup")
    void testReadLinesBeforeSetup2() {
        assertThrows(NoSuchFileException.class, () -> this.filePartReader.readLines());
    }

    @Test
    @DisplayName("Test READLINES method with BAD setup")
    void testReadLinesWithBadSetup2() {
        this.filePartReader.setup("xxx", 2, 4);
        assertThrows(NoSuchFileException.class, () -> this.filePartReader.readLines());
    }

    @Test
    @DisplayName("Test SETUP method: (toLine < fromLine) ")
    void testSetup1() {
        assertThrows(IllegalArgumentException.class, () -> this.filePartReader.setup("", 2, 1));
    }

    @Test
    @DisplayName("Test SETUP method: (fromLine < 1) ")
    void testSetup2() {
        assertThrows(IllegalArgumentException.class, () -> this.filePartReader.setup("", 0, 1));
    }

    @Test
    @DisplayName("Test READLINES method: (toLine > EOF) ")
    void testSetup3() {
        this.filePartReader.setup(patchForTest2txt, 1, 678);
        assertThrows(IndexOutOfBoundsException.class, () -> this.filePartReader.readLines());
    }



    @Test
    @DisplayName("Test READ method, read ALL")
    void readAllText() throws IOException {
        this.filePartReader.setup(patchForTest2txt,1,3);
        String allLines = this.filePartReader.read();
        String expectedLines  = "In this assignment\n" + "we will work\n" + "with files ada";
        assertEquals(allLines, expectedLines);
    }

    @Test
    @DisplayName("Test READLINES method, read lines 1,2")
    void readLines_1_2() throws IOException {
        this.filePartReader.setup(patchForTest2txt,1,2);
        String allLines = this.filePartReader.readLines();
        String expectedLines  =   "In this assignment\n" + "we will work\n";
        assertEquals(expectedLines, allLines);
    }

    @Test
    @DisplayName("Test READLINES method, read lines 3")
    void readLines_3() throws IOException {
        this.filePartReader.setup(patchForTest2txt,3,3);
        String allLines = this.filePartReader.readLines();
        String expectedLines  =   "with files ada\n";
        assertEquals(expectedLines, allLines);
    }

}