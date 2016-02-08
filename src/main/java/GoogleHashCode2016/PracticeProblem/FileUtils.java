package GoogleHashCode2016.PracticeProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * A simple class to parse files for the practice problem
 */
public class FileUtils {

    private final String inputFile;

    private final String outputFile;

    private int row;

    private int columns;

    private Character[][] pictureMatrix;


    public FileUtils(String inputFile, String outputFile) {
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
            pictureMatrix = new Character[row][columns];


            for (int i = 0; i < row; i++) {
                current_line = bufferedReader.readLine();
                pictureMatrix[i] = current_line.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            }
        }
    }


    /**
     * Write a list of operations in the outputfile
     */
    public void writeTofile(List<String> operations) throws IOException {
        writeToFile(operations, outputFile);
    }

    /**
     * Write a list of operations in the fileName
     */
    public static void writeToFile(List<String> operations, String fileName) throws IOException {
        Path path = Paths.get(fileName);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {

            // write the number of operations
            bufferedWriter.write(String.valueOf(operations.size()));
            bufferedWriter.write("\n");

            for (String operation : operations) {
                bufferedWriter.write(operation);
                bufferedWriter.write("\n");
            }
        }
    }

    public Character[][] getPictureMatrix() {
        return pictureMatrix;
    }

    public int getRow() {
        return row;
    }

    public int getColumns() {
        return columns;
    }

}
