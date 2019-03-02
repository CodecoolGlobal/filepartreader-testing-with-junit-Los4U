import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically (){
        String allLines  = filePartReader.readLines();

        List myList =  getTheWordsList(allLines);

        return myList;
    }

    public List getWordsContainingSubstring (String subString ){
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

    public List getStringsWhichPalindromes (){
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

    public static boolean isPalindrome(String str) {
        return (str.toLowerCase()).equals(new StringBuilder(str.toLowerCase()).reverse().toString());
    }

    public List getTheWordsList(String allLines){
        String lines = allLines.replace("\n", " ").replace("\r", " ");
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(lines.split(" ")));
        Collections.sort(myList);

        myList.removeAll(Arrays.asList("", null));
        return myList;
    }

}
