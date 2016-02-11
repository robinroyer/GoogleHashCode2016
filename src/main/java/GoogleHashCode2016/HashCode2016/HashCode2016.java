package GoogleHashCode2016.HashCode2016;

import GoogleHashCode2016.PracticeProblem.FileUtils;

import java.io.IOException;
import java.util.List;

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

        List<Warehouse> warehousesList = fileUtils2016.warehouseArrayList;
        List<Drone> droneList = fileUtils2016.droneList;
        List<Commands> commandsList = fileUtils2016.commandsList;
        List<Product> productList = fileUtils2016.productList;









    }
}
