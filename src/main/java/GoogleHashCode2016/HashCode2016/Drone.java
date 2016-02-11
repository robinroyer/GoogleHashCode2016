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

    private int goTo (int r, int c) {
        // return time fo travel to position
        int time = getTime(this.r, this.c, r, c);
        this.endWorkTime += time;
        return time;
    }

    public void addProductDelivery (Product product, int r, int c, List <Warehouse> warehouses) {
        Warehouse commandWarehouse;
        commandWarehouse = findWarehous(product, warehouses);
        int timeToWarehouse = getTime(this.r, this.c, commandWarehouse.r, commandWarehouse.c);
        int timeToCommand = getTime(commandWarehouse.r, commandWarehouse.c, r, c);
        this.endWorkTime += timeToWarehouse + timeToCommand;
    }


}
