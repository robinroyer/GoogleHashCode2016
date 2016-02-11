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
     * @param command la position de la commande
     * @param warehouses
     */
    public void addProductDelivery (Product product, Commands command, List <Warehouse> warehouses) {
        Warehouse commandWarehouse;

        commandWarehouse = findWarehous(product, warehouses);

        commandWarehouse.removeProduct(product);

        Helpers.FlyAndLoadProductTo(this, commandWarehouse, product, 1);
        Helpers.FlyAndDeliverTo(this, command, product, 1);

        int timeToWarehouse = getTime(this.r, this.c, commandWarehouse.r, commandWarehouse.c)+1;
        int timeToCommand = getTime(commandWarehouse.r, commandWarehouse.c, command.r, command.c)+1;
        this.endWorkTime += timeToWarehouse + timeToCommand;
    }


}
