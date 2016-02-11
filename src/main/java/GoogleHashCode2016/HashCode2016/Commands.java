package GoogleHashCode2016.HashCode2016;

import java.util.ArrayList;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Commands {
    public int id;
    //Location de la commande
    public int r;
    public int c;
    public ArrayList<Product> listProduct;

    public Commands(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }


}
