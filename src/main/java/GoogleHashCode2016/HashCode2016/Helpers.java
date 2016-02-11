package GoogleHashCode2016.HashCode2016;

import java.util.List;

import static java.lang.Math.*;

/**
 * Created by haidara on 11/02/16.
 */
import static java.lang.Math.*;

public class Helpers {

    /**
     * retourne le temps que va prendre un drone à allez à un endroit
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static int getTime (int x1, int y1, int x2, int y2) {
        //
        double distance = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return (int)ceil(distance);
    }

    /**
     * trouve un warehouse qui à le produit chercher
     * @param p
     * @param warehouses
     * @return
     */
    public static Warehouse findWarehous (Product p, List<Warehouse> warehouses) {
        for (Warehouse warehouse : warehouses) {
            if(warehouse.hasProduct(p)) {
                return warehouse;
            }
        }
        return null;
    }

    /**
     * retourne le premier drones libre
     * @param drones
     * @return
     */
    public static Drone getFreeDrone (List <Drone> drones) {
        int min = -1;
        Drone freeDrone = null;
        for (Drone drone : drones) {
            if(min == -1 || drone.endWorkTime<=min) {
                freeDrone = drone;
                min = drone.endWorkTime;
            }
        }
        return freeDrone;
    }

    /**
     * retourne le produit en fonction de son id
     * @param list
     * @param idProduct
     * @return
     */
    public static Product getProduit(List<Product> list, int idProduct)
    {
        for(Product p : list)
        {
            if(p.id == idProduct)
                return p;
        }
        return null;
    }

    
    public static String FlyAndLoadProductTo(Drone drone, Warehouse warehouse, Product product, int quqntity){return null;}
    public static String FlyAndDeliverTo(Drone drone, Commands command, Product product){return null;}
    
}
