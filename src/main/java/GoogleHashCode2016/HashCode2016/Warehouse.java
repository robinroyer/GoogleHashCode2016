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

    public boolean hasProduct(Product p) {
        System.out.println("P.ID" + p.id);
        return ((stock.get(p.id) != null) && (stock.get(p.id) > 0));
    }

    public void removeProduct(Product p) {
        int idProduct = p.id;
        int quantity = this.stock.get(idProduct);
        System.out.println("W" + this.id + "P" + idProduct + "S" + this.stock.get(idProduct));
        this.stock.replace(idProduct, quantity - 1);
        System.out.println("W" + this.id + "P" + idProduct + "S" + this.stock.get(idProduct));
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
