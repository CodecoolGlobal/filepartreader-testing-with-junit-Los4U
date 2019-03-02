import java.io.File;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kamil Woś\\IdeaProjects\\filepartreader-testing-with-junit-Los4U\\resources\\test.txt";

        FilePartReader fpReader =  new FilePartReader();
        System.out.println(fpReader.readLines());

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
