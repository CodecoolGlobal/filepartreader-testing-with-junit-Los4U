import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    String filePath;
    int fromLine;
    int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = -1;
        this.toLine = -15;
    }

    public void setup (String filePath, int fromLine, int toLine) throws IllegalArgumentException{
        if((toLine < fromLine) || (fromLine < 1)){
            throw new IllegalArgumentException("Bad conditions");
        } else{
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read (){
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();

       // if(file.exists()) {
            try {
                URI uri = this.getClass().getResource(file.getName()).toURI();
                List<String> lines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());

                for (String line : lines) {
                    builder.append(line);
                    builder.append("\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
//        else {
//            System.out.println("The file does not exist");
//        }
        return builder.toString();
    }

    public String readLines (){
        StringBuilder builder = new StringBuilder();

        String allLines = read();
        List<String> myList = new ArrayList<String>(Arrays.asList(allLines.split("\n")));

        for (int i = fromLine-1; i < toLine; i++) {
            builder.append(myList.get(i));
            builder.append("\n");
        }
        return builder.toString();
    }

}
