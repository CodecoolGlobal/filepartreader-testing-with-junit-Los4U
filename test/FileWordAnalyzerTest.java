import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;
    private String patchForTest2txt = "C:\\Users\\Kamil Woś\\IdeaProjects\\filepartreader-testing-with-junit-Los4U\\resources\\test2.txt";

    @BeforeEach
    void createNewFilePartReader() {
        this.filePartReader =  new FilePartReader();
        this.filePartReader.setup(patchForTest2txt,1,3);
        this.fileWordAnalyzer = new FileWordAnalyzer(this.filePartReader);

    }

    @Test
    @DisplayName("Test Alphabetically method, returns words in Alphabetically order")
    void getWordsOrderedAlphabetically() throws IOException {
        List<String> expectedList = Arrays.asList("In", "ada", "assignment", "files", "this", "we", "will", "with", "work");
        List actualList = fileWordAnalyzer.getWordsOrderedAlphabetically();

        assertEquals(actualList, expectedList);
    }

    @Test
    @DisplayName("Test Substring method, returns list with words containing substring")
    void getWordsContainingSubstring() throws IOException {
        List<String> expectedList = Arrays.asList("files", "will");
        List actualList = fileWordAnalyzer.getWordsContainingSubstring("il");

        assertEquals(actualList, expectedList);
    }

    @Test
    @DisplayName("Test Substring method, returns EMPTY list if NO containing substring")
    void getWordsContainingSubstring2() throws IOException {
        List<String> expectedList = new ArrayList<String>();
        //expectedList.add("codecool");
        List actualList = fileWordAnalyzer.getWordsContainingSubstring("codecool");

        assertEquals(actualList, expectedList);
    }


    @Test
    @DisplayName("Test Palindrome method, returns list of words with palindromes. ")
    void getStringsWhichPalindromes() throws IOException {
        List<String> expectedList = Arrays.asList(new String[]{"ada" });
        List actualList = fileWordAnalyzer.getStringsWhichPalindromes();

        assertEquals(actualList, expectedList);
    }

    @Test
    @DisplayName("Test isPalindrome method, check one word if it is palindrome. ")
    void isPalindrome() {
        assertTrue(fileWordAnalyzer.isPalindrome("geeksskeeg"));
        assertFalse(fileWordAnalyzer.isPalindrome("geeksskeeg2"));
    }


}