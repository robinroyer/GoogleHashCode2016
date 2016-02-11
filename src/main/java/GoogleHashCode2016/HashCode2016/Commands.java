package GoogleHashCode2016.HashCode2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lisa on 11/02/2016.
 */
public class Commands {
    public int id;

    //Location de la commande
    public int r;
    public int c;

    public int maxWeight;

    //Produit et nb de produit voulus
    public Map<Integer, Integer> stock = new HashMap<>();

    public Commands(int id, int r, int c, int maxWeight){
        this.id = id;
        this.r = r;
        this.c = c;
        this.maxWeight = maxWeight;
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

    public List<Product> getBestLoading () {
        int maxWeight = Helpers.sumWeight(this.stock)
        if (Helpers.sumWeight(this.stock) < this.maxWeight) {
            return Helpers.stockToProductsList(stock);
        }
        else {
            return getBetterProductCombinaison(this.stock, null, );
        }

        return null;
    }

    public List<Product> getBetterProductCombinaison(Map<Integer, Integer> stock, Map<Integer, Integer> betterCombinaison, int minWeight) {
        for()
        return null;
    }


    /**
     * retourne la stock de toutes la commande
     * @return
     */
    public Map<Integer, Integer> getStock() {
        return stock;
    }

    public boolean hasProducts() {
        return !this.stock.isEmpty();
    }
}
