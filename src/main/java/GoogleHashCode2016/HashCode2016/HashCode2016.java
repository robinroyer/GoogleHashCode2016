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

    public static String REDUNDANCY_IN = "src/main/java/GoogleHashCode2016/HashCode2016/Redundancy.in";
    public static String REDUNDANCY_OUT = "src/main/java/GoogleHashCode2016/HashCode2016/Redundancy.out";


    public static String MOHTER_IN = "src/main/java/GoogleHashCode2016/HashCode2016/mother_of_all_warehouses.in";
    public static String MOHTER_OU = "src/main/java/GoogleHashCode2016/HashCode2016/mother_of_all_warehouses.out";


    public static void main(String [] args) throws IOException{

        FileUtils2016 fileUtils2016 = new FileUtils2016(REDUNDANCY_IN,REDUNDANCY_OUT);

        fileUtils2016.parseFile();

        List<Warehouse> warehousesList = fileUtils2016.warehouseArrayList;
        List<Drone> droneList = fileUtils2016.droneList;
        List<Commands> commandsList = fileUtils2016.commandsList;
        List<Product> productList = fileUtils2016.productList;
        int maxTime = fileUtils2016.getTurns();
        //int maxTime = 100000;

        Product produit;
        Drone drone;
        int productId;

        int commandesTraitee = 0;
        int stockSize = 0;
        for(Commands command : commandsList)
        {
            while(command.hasProducts())
            {
                productId = command.getFirstProductId();
                produit = Helpers.getProduit(productList, productId);
                System.out.println(productId);
                drone = Helpers.getFreeDrone(droneList, maxTime);

                if(drone != null && produit != null) {
                    drone.addProductDelivery(produit, command, warehousesList, maxTime);
                }
            }
        }
        System.out.println("MAX TIME : " + maxTime);
        for(Drone enddrone : droneList) {
            System.out.println(enddrone.endWorkTime);
        }
        fileUtils2016.writeToFile(Helpers.getOutputStringList());

    }
}
