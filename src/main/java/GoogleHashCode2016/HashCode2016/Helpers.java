package GoogleHashCode2016.HashCode2016;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

/**
 * Created by haidara on 11/02/16.
 */
import static java.lang.Math.*;

public class Helpers {
	public static List<String> outputList = new ArrayList<>();

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

    public static Warehouse findBestWarehouse (Product p, List<Warehouse>warehouses, int rDrone, int cDrone) {
        int distanceMin = 2147483647;
        Warehouse closestWarehouse = null;
        for (Warehouse warehouse : warehouses) {
            int distance = getTime(rDrone, cDrone, warehouse.r, warehouse.c);
            if(warehouse.hasProduct(p) && distance < distanceMin) {
                distanceMin = distance;
                closestWarehouse = warehouse;
            }
        }
        return closestWarehouse;
    }

    /**
     * retourne le premier drones libre
     * @param drones
     * @return
     */
    public static Drone getFreeDrone (List <Drone> drones, int maxTime) {
        int minTime = maxTime;
        Drone freeDrone = null;
        for (Drone drone : drones) {
            if(drone.endWorkTime<=maxTime && drone.endWorkTime< minTime) {
                freeDrone = drone;
                minTime = drone.endWorkTime;
            }
        }
        return freeDrone;
    }

    /**
     * retourn le produit en fonction de son id
     * @param list la liste de tous les produits
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

    /**
     * retourne la liste de tout les produits d'un stock
     * @param stock
     * @param allProducts List of all the products
     * @return
     */
    public static List<Product> stockToProductList(Map<Integer, Integer> stock, List<Product> allProducts)
    {
        List<Product> products = new ArrayList<>();

        for(int id : stock.keySet())
        {
            products.add(getProduit(allProducts, id));
        }

        return products;
    }
    /**
     * retourne le poid total du stock
     * @param stock
     * @param products List of products
     * @return
     */
    public static int sumWeight(Map<Integer, Integer> stock, List<Product> products)
    {
        int sumWeight = 0;
        for(Product produit : products)
        {
            sumWeight += produit.weight;
        }

        return sumWeight;
    }
    
    public static void FlyAndLoadProductTo(Drone drone, Warehouse warehouse, Product product, int quantity){
    	outputList.add( "" + drone.id + " L " + warehouse.id + " " + product.id + " " + quantity);
        System.out.println("" + drone.id + " L " + warehouse.id + " " + product.id + " " + quantity);
    }
    public static void FlyAndDeliverTo(Drone drone, Commands command, Product product, int quantity){
        outputList.add( "" + drone.id + " D " + command.id + " " + product.id + " " + quantity);
        System.out.println("" + drone.id + " D " + command.id + " " + product.id + " " + quantity);

    }
    public static void wait(Drone drone, int turnsToWait){
        outputList.add( "" + drone.id + " W " + turnsToWait);
    }
    public static List<String> getOutputStringList(){
    	return outputList;
    }

}

