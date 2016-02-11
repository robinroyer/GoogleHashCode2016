package GoogleHashCode2016.HashCode2016;

import GoogleHashCode2016.PracticeProblem.FileUtils;

import java.io.IOException;

/**
 * Created by haidara on 11/02/16.
 */
public class HashCode2016 {


    public static String BUSY_DAY_IN = "src/main/java/GoogleHashCode2016/HashCode2016/busy_day.in";
    public static String BUSY_DAY_OUT = "src/main/java/GoogleHashCode2016/HashCode2016/busy_day.out";


    public static String MOHTER_IN = "src/main/java/GoogleHashCode2016/HashCode2016/mother_of_all_warehouses.in";
    public static String MOHTER_OU = "src/main/java/GoogleHashCode2016/HashCode2016/mother_of_all_warehouses.out";





    public static void main(String [] args) throws IOException{

        FileUtils2016 fileUtils2016 = new FileUtils2016(BUSY_DAY_IN,BUSY_DAY_OUT);

        fileUtils2016.parseFile();






    }
}
