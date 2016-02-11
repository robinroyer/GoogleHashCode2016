package GoogleHashCode2016.HashCode2016;

import java.util.ArrayList;
import java.util.List;

import static GoogleHashCode2016.HashCode2016.Helpers.*;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Drone {
    public int id;
    public int r;
    public int c;
    public int maxWeight;
    public int endWorkTime;
    public List <Commands> commands;

    public Drone(int id, int r, int c, int maxWeight) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.maxWeight = maxWeight;
        this.endWorkTime = 0;
        this.commands = new ArrayList<Commands>();
    }

    /**
     *
     * @param r
     * @param c
     * @return
     */
    private int goTo (int r, int c) {
        // return time fo travel to position
        int time = getTime(this.r, this.c, r, c);
        this.endWorkTime += time;
        return time;
    }

    /**
     * ajout le produit au drone
     * @param product
     * @param r et c la position de la commande
     * @param warehouses
     */
    public void addProductDelivery (Product product, int r, int c, List <Warehouse> warehouses) {
        Warehouse commandWarehouse;
        commandWarehouse = findWarehous(product, warehouses);
        // +1 because it takes to to load the product
        int timeToWarehouse = getTime(this.r, this.c, commandWarehouse.r, commandWarehouse.c)+1;
        // +1 because it takes to to unload the product
        int timeToCommand = getTime(commandWarehouse.r, commandWarehouse.c, r, c)+1;
        //GOTOWAREHOUSE&PICKOBJECTWAREHOUSE
        //GOTOCLIENT&PUSHPRODUCT
        this.endWorkTime += timeToWarehouse + timeToCommand;
    }


}
