import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class FileWordAnalyzer {
    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    List getWordsOrderedAlphabetically () throws IOException {
        String allLines  = filePartReader.readLines();
        return getTheWordsList(allLines);
    }

    List getWordsContainingSubstring (String subString ) throws IOException {
        String allLines  = filePartReader.readLines();
        List myList =  getTheWordsList(allLines);
        List listThatContainsSubString = new ArrayList<String>();

        for(Object word : myList ){
            if(((String)word).toLowerCase().contains(subString.toLowerCase())){
                listThatContainsSubString.add(word);
            }
        }
        return listThatContainsSubString;
    }

    List getStringsWhichPalindromes () throws IOException{
        String allLines  = filePartReader.readLines();

        List myList =  getTheWordsList(allLines);
        List palindromes = new ArrayList<String>();

        for(Object word : myList ){
            if(isPalindrome((String)word)){
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    boolean isPalindrome(String str) {
        return (str.toLowerCase()).equals(new StringBuilder(str.toLowerCase()).reverse().toString());
    }

    private List getTheWordsList(String allLines){
        String lines = allLines.replace("\n", " ").replace("\r", " ");
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(lines.split(" ")));
        Collections.sort(myList);

        myList.removeAll(Arrays.asList("", null));
        return myList;
    }

}
