import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Kamil Woś\\IdeaProjects\\filepartreader-testing-with-junit-Los4U\\resources\\test.txt";

        FilePartReader fpReader =  new FilePartReader();

        try{
            System.out.println(fpReader.readLines());
        }catch (Exception e){e.printStackTrace();}

        System.out.println("------------------------------------------------------");


        fpReader.setup(path, 1,50);
        System.out.println(fpReader.readLines());

        System.out.println("Alphabetically:");
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(fpReader);
        System.out.println(" - List: " + fileWordAnalyzer.getWordsOrderedAlphabetically());

        System.out.println("------------------------------------------------------");
        System.out.println("LIST WITH SUBSTRING:");
        System.out.println(" - List: " + fileWordAnalyzer.getWordsContainingSubstring("tion"));


        System.out.println("------------------------------------------------------");
        System.out.println("PALINDROMES:");
        System.out.println(" - List: " + fileWordAnalyzer.getStringsWhichPalindromes());







    }

}
