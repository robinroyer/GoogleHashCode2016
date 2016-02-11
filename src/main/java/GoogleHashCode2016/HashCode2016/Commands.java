package GoogleHashCode2016.HashCode2016;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Commands {
    public int id;

    //Location de la commande
    public int r;
    public int c;

    public ArrayList<Product> listProduct = new ArrayList<>();

    public Map<Integer, Integer> stock;

    public Commands(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }


    public ArrayList<Product> getListProduct() {
        return listProduct;
    }
}
