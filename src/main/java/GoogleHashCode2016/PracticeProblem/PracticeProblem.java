package GoogleHashCode2016.PracticeProblem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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


    public static List<Operation>  easySolution(Character[][] mat){
        List<Operation> operationTreeSet = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == NEED_TO_BE_PAINT){
                    PaintSqare paintSqare = new PaintSqare(i,j,0);
                    // paint all unit case
                    operationTreeSet.add(paintSqare);
                }
            }
        }
        return operationTreeSet;
    }

    static abstract class Operation implements Comparable<Operation>{
        int R,C;

        public Operation(int r, int c) {
            R = r;
            C = c;
        }

        public int getR() {
            return R;
        }

        public int getC() {
            return C;
        }


    }

  static   class PaintSqare extends Operation {

        int S;

        public PaintSqare(int r, int c, int S) {
            super(r, c);
            this.S = S;
        }

        @Override
        public String toString() {
            return "PAINT_SQUARE " +R+" "+C+" "+S;
        }


        @Override
        public int compareTo(Operation o) {
            if(o instanceof PaintSqare){
                PaintSqare paintSqare = (PaintSqare) o;
                if(paintSqare.getR() == R) {
                    if(paintSqare.getC() == C){
                        return 0;
                    } else if(paintSqare.getC() > C){
                        return -1;
                    } else
                        return 1;
                } else if(paintSqare.getR() > R){
                    return -1;
                } else return 1;

            } else
            return 0;
        }
    }

  static   class PaintLine extends Operation {

        int R2,C2;

        public PaintLine(int r, int c,int r2,int c2) {
            super(r, c);
            this.R2 = r2;
            this.C2 = c2;
        }

        public int getC2() {
            return C2;
        }

        public int getR2() {
            return R2;
        }

        @Override
        public String toString() {
            return "PAINT_LINE "+R+" "+C+" "+R2+" "+C2;
        }

        @Override
        public int compareTo(Operation o) {
            //TODO ?
            return 0;
        }
    }

  static   class EraseCell extends Operation {
        public EraseCell(int r, int c) {
            super(r, c);
        }

        @Override
        public String toString() {
            return "ERASE_CELL "+R+" "+C;
        }

        @Override
        public int compareTo(Operation o) {
            //TODO ?
            return 0;
        }
    }
}
