package GoogleHashCode2016.HashCode2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Commands {
    public int id;

    //Location de la commande
    public int r;
    public int c;


    public Map<Integer, Integer> stock = new HashMap<>();

    public Commands(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }

    public int getFirstProductId () {
        int idProduct = this.stock.keySet().iterator().next();
        int quantity = this.stock.get(idProduct);
        if (quantity == 1) {
            this.stock.remove(idProduct);
        } else {
            this.stock.replace(idProduct, quantity - 1);
        }
        return idProduct;
    }


    public Map<Integer, Integer> getStock() {
        return stock;
    }
}
