package GoogleHashCode2016.PracticeProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.internal.FinalArrayList;

/**
 *
 */
public class PracticeProblem {
	public static final Character NEED_TO_BE_PAINT = '#';
	
	public static final String LEARN_AND_TEACH_IN = "src/main/java/GoogleHashCode2016/PracticeProblem/learn_and_teach.in";
	public static final String LEARN_AND_TEACH_OUT = "src/main/java/GoogleHashCode2016/PracticeProblem/learn_and_teach.out";
	
	public static final String LOGO_IN = "src/main/java/GoogleHashCode2016/PracticeProblem/logo.in";
	public static final String LOGO_OUT = "src/main/java/GoogleHashCode2016/PracticeProblem/logo.out";
	
	public static final String RIGHT_ANGLE_IN = "src/main/java/GoogleHashCode2016/PracticeProblem/right_angle.in";
	public static final String RIGHT_ANGLE_OUT = "src/main/java/GoogleHashCode2016/PracticeProblem/right_angle.out";



    public static void main(String [] args) throws IOException {

        FileUtils fileUtils = new FileUtils(LEARN_AND_TEACH_IN, LEARN_AND_TEACH_OUT);

        fileUtils.parseFile();

        int row = fileUtils.getRow();
        int columns = fileUtils.getColumns();
        Character[][] picture = fileUtils.getPictureMatrix();

//        fileUtils.writeTofile(fakeSolution());
        fileUtils.writeTofile(easySolution(picture));
        System.out.println("-DONE");
    }


    public static List<String> fakeSolution(){
        List<String> strings = new ArrayList<>();

        strings.add("PAINT_SQUARE 2 3 1");
        strings.add("ERASE_CELL 2 3");
        strings.add("PAINT_SQUARE 0 4 0");
        strings.add("PAINT_SQUARE 4 2 0");

        return strings;
    }
    
    public static List<String> easySolution(Character[][] mat) {
    	 List<String> strings = new ArrayList<>();

    	 for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == NEED_TO_BE_PAINT){
					 // paint all unit case
					strings.add("PAINT_SQUARE " + i + " " + j + " 0 ");
				}
			}
		} 
        return strings;
		
	}
}
