package GoogleHashCode2016.PracticeProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PracticeProblem {



    public static void main(String [] args) throws IOException {

        FileUtils fileUtils = new FileUtils("learn_and_teach.in","learn_and_teach.out");

        fileUtils.parseFileBufferedReader();

        int row = fileUtils.getRow();
        int columns = fileUtils.getColumns();
        Character[][] picture = fileUtils.getPictureMatrix();

        fileUtils.writeTofile(fakeSolution());
    }


    public static List<String> fakeSolution(){
        List<String> strings = new ArrayList<>();

        strings.add("PAINT_SQUARE 2 3 1");
        strings.add("ERASE_CELL 2 3");
        strings.add("PAINT_SQUARE 0 4 0");
        strings.add("PAINT_SQUARE 4 2 0");

        return strings;
    }
}
