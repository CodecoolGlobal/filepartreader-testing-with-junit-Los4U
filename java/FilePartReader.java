import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "bad.txt";
        this.fromLine = -1;
        this.toLine = -15;
    }

    void setup (String filePath, int fromLine, int toLine) throws IllegalArgumentException{
        if((toLine < fromLine) || (fromLine < 1)){
            throw new IllegalArgumentException("Bad conditions");
        } else{
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    String read () throws IOException {
        StringBuilder builder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(this.filePath));

        for (String line : lines) {
            builder.append(line);
            builder.append("\n");
        }
        String allText = builder.toString();
        allText = allText.substring(0, allText.length() - 1);
        return allText;
    }

    String readLines () throws IOException, IndexOutOfBoundsException {
        StringBuilder builder = new StringBuilder();

        String allLines = read();
        List<String> myList = new ArrayList<>(Arrays.asList(allLines.split("\n")));

        for (int i = fromLine-1; i < toLine; i++) {
            builder.append(myList.get(i));
            builder.append("\n");
        }
        return builder.toString();
    }

}
