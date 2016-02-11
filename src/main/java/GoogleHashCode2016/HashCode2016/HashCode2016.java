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

        FileUtils2016 fileUtils2016 = new FileUtils2016(MOHTER_IN,MOHTER_OU);

        fileUtils2016.parseFile();

        List<Warehouse> warehousesList = fileUtils2016.warehouseArrayList;
        List<Drone> droneList = fileUtils2016.droneList;
        List<Commands> commandsList = fileUtils2016.commandsList;
        List<Product> productList = fileUtils2016.productList;

        Product produit;
        Drone drone;
        int productId;

        int commandesTraitee = 0;
        int stockSize = 0;
        for(Commands command : commandsList)
        {
            commandesTraitee++;
            System.out.println(commandesTraitee + " " + commandsList.size() + " " + command.getStock().size());

            while(command.hasProducts())
            {
                drone = Helpers.getFreeDrone(droneList);

                productId = command.getFirstProductId();
                produit = Helpers.getProduit(productList, productId);

                if(produit != null)
                {
                    drone.addProductDelivery(produit, command, warehousesList);
                }

                if(command.getStock().size() == 1)
                    System.out.println("coucou");
            }
            if(commandesTraitee == 393)
                System.out.println("coucou");
        }

        fileUtils2016.writeToFile(Helpers.getOutputStringList());

    }
}
