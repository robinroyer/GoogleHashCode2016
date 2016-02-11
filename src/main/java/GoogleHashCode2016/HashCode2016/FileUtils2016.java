package GoogleHashCode2016.HashCode2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by haidara on 11/02/16.
 */
public class FileUtils2016 {

    private final String inputFile;

    private final String outputFile;

    int row;

    int columns;


    int drones;

    int turns;

    int payload;


    int product_type;





    public FileUtils2016(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }


    /**
     * Parse file
     *
     * @throws IOException
     */
    public void parseFile() throws IOException {
        Path path = Paths.get(inputFile);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            String current_line = bufferedReader.readLine();

            String[] splited_string = current_line.split(" ");

            row = Integer.parseInt(splited_string[0]);
            columns = Integer.parseInt(splited_string[1]);


            drones = Integer.parseInt(splited_string[2]);
            turns = Integer.parseInt(splited_string[3]);

            payload = Integer.parseInt(splited_string[4]);







        }
    }
}
