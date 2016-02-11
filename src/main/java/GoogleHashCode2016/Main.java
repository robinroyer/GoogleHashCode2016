package GoogleHashCode2016;


import GoogleHashCode2016.HashCode2016.*;

public class Main {

    public static void main(String []args){
        System.out.println("Hash-Rocket");

        FileUtils2016 f = new FileUtils2016("" ,"");

        Product produit;
        Drone drone;
        int productId;

        for(Commands command : f.getCommandsList())
        {
            drone = Helpers.getFreeDrone(f.getDroneList());

            productId = command.getFirstProductId();
            produit = Helpers.getProduit(f.getProductList(), productId);

            if(produit != null)
            {
                drone.addProductDelivery(produit, command.r, command.c, f.getWarehouseArrayList());
            }
        }
    }
}
