package GoogleHashCode2016.HashCode2016;

import java.util.Map;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Warehouse {

    int id;
    int r;
    int c;
    Map<Integer, Integer> stock;

    public Warehouse(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }

    public void setProductStock (int idProduct, int quantity) {
        stock.put(idProduct, quantity);
    }

    public void removeXProduct (int idProduct, int quantity) {
        int oldQuantity = stock.get(idProduct);
        stock.put(idProduct, oldQuantity-quantity);
    }

    public int getProdutQuantity (int idProduct) {
        return stock.get(idProduct);
    }
}
