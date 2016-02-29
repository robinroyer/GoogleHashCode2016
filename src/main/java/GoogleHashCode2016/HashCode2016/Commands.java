package GoogleHashCode2016.HashCode2016;

import java.util.*;

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

    private void removeProduct(int idProduct) {
        if(this.stock.isEmpty()) {
            return;
        }
        int quantity = this.stock.get(idProduct);

        if (quantity == 1) {
            this.stock.remove(idProduct);
        } else {
            this.stock.replace(idProduct, quantity - 1);
        }
        return;
    }


    private void removeProducts(List<Product> products) {
        for(Product product : products) {
            this.removeProduct(product.id);
        }
    }

    public List<Product> getBestLoading (List<Product> products) {
        int CommandWeight = Helpers.sumWeight(this.stock, products);
        if (CommandWeight < this.maxWeight) {
            this.stock.clear();
            return Helpers.stockToProductList(this.stock, products);
        }
        else {
            Map<Integer, Integer> newStock = new HashMap<Integer,Integer>(this.stock);
            List<Product> loading = getBestProductCombinaison(newStock, products, 0);
            System.out.println("END!");




            this.removeProducts(loading);
            return loading;
        }
    }

    private List<Product> getBetterProductCombinaison(List<Product> products) {
        List<Product> productList = new ArrayList<>();
        int weight = 0;
        Iterator it = this.stock.keySet().iterator();
        while (weight < this.maxWeight && it.hasNext()) {
            int idProduct = (int) it.next();
            Product product = Helpers.getProduit(products, idProduct);
            if(weight+product.weight < this.maxWeight) {
                weight +=product.weight;
                productList.add(product);
            }
        }
        for(Product productToRemove : productList) {
            this.removeProduct(productToRemove.id);
        }
        System.out.println("W : " + weight + " / MAX : " + maxWeight);
        return productList;
    }

    private List<Product> getBestProductCombinaison(Map<Integer, Integer> stock, List<Product> products, int maxItems) {
        //System.out.println(stock.size());
        int CommandWeight = Helpers.sumWeight(stock, products);
        if(CommandWeight < this.maxWeight) {
            System.out.println("BINGO");
            return Helpers.stockToProductList(stock, products);
        }
        else {
            //Iterator it = stock.keySet().iterator();
            List<Product> bestList = new ArrayList<>();
            System.out.println(stock.keySet());
            for (int key : stock.keySet()) {
                Map<Integer, Integer> newStock = new HashMap<Integer,Integer>(stock);
                newStock.remove(key);
                //List<Product> newList = getBestProductCombinaison(newStock, products, maxItems);
                return getBestProductCombinaison(newStock, products, maxItems);
                //System.out.println(this.id);
//                if(newList.size() == stock.size()-1) {
//                    System.out.println("CUT");
//                    return newList;
//                }
//                if(newList.size() == maxItems) {
//                    maxItems = newList.size();
//                    bestList = newList;
//                }
            }
            return bestList;
        }
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
