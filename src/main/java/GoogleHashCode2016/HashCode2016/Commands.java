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

    //Produit et nb de produit voulus
    public Map<Integer, Integer> stock = new HashMap<>();

    public Commands(int id, int r, int c){
        this.id = id;
        this.r = r;
        this.c = c;
    }

    /**
     * Récupère le premier produit de la commande et le retourne
     * décrémente la quantité de ce produit dans  la commmande
     * @return
     */
    public int getFirstProductId () {
        if(this.stock.isEmpty()) {
            return -1;
        }
        int idProduct = this.stock.keySet().iterator().next();
        int quantity = this.stock.get(idProduct);
        if (quantity == 1) {
            this.stock.remove(idProduct);
        } else {
            this.stock.replace(idProduct, quantity - 1);
        }
        return idProduct;
    }

    /**
     * retourne la stock de toutes la commande
     * @return
     */
    public Map<Integer, Integer> getStock() {
        return stock;
    }

}
