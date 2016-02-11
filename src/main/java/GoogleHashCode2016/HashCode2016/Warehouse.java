package GoogleHashCode2016.HashCode2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Warehouse {

    int id;
    int r;
    int c;
    Map<Integer, Integer> stock = new HashMap<>();

    public Warehouse(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }

    public void setProductStock (int idProduct, int quantity) {
        stock.put(idProduct, quantity);
    }

    public void removeProductQuantity (int idProduct, int quantity) {
        int oldQuantity = stock.get(idProduct);
        stock.put(idProduct, oldQuantity-quantity);
    }

    public int getProductQuantity (int idProduct) {
        return stock.get(idProduct);
    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", r=" + r +
                ", c=" + c +
                ", stock=" + stock +
                '}';
    }
}
