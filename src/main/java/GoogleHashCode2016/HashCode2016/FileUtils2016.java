package GoogleHashCode2016.HashCode2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haidara on 11/02/16.
 */
public class FileUtils2016 {

    private final String inputFile;

    private final String outputFile;

    int row;

    int columns;


    int drones;

    int turns;

    int payload;

    List<Integer> list_of_product_type;

    int nb_warehouse;


    int nb_orders;


    List<Warehouse> warehouseArrayList = new ArrayList<>();

    List<Commands> commandsList = new ArrayList<>();

    List<Product> productList = new ArrayList<>();


    public FileUtils2016(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }


    /**
     * Parse file
     *
     * @throws IOException
     */
    public void parseFile() throws IOException {
        Path path = Paths.get(inputFile);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {

            String current_line = bufferedReader.readLine();

            String[] splited_string = current_line.split(" ");

            row = Integer.parseInt(splited_string[0]);
            columns = Integer.parseInt(splited_string[1]);


            drones = Integer.parseInt(splited_string[2]);
            turns = Integer.parseInt(splited_string[3]);

            payload = Integer.parseInt(splited_string[4]);


         /*   System.out.println(row);
            System.out.println(columns);
            System.out.println(drones);
            System.out.println(turns);
            System.out.println(payload); */


            current_line = bufferedReader.readLine();

            int nb_product = Integer.parseInt(current_line);

            list_of_product_type = new ArrayList<>();

            String[] id_products = bufferedReader.readLine().split(" ");

            for (int i = 0; i < id_products.length; i++) {
                list_of_product_type.add(Integer.parseInt(id_products[i]));
                Product product = new Product(i,Integer.parseInt(id_products[i]));


                productList.add(product);

            }


            current_line = bufferedReader.readLine();
            nb_warehouse = Integer.parseInt(current_line);


            for (int i = 0; i < nb_warehouse; i++) {
                String first = bufferedReader.readLine();
                String[] first_splitted = first.split(" ");


                int rowWareHouse = Integer.parseInt(first_splitted[0]);
                int columWareHouse = Integer.parseInt(first_splitted[1]);
                Warehouse warehouse = new Warehouse(i, rowWareHouse, columWareHouse);

                List<Integer> dispo_produit = new ArrayList<>();

                String second = bufferedReader.readLine();

                // System.out.println(second);

                String[] second_splitted = second.split(" ");

                for (int j = 0; j < second_splitted.length; j++) {
                    warehouse.setProductStock(i, Integer.parseInt(second_splitted[i]));
                }

                warehouseArrayList.add(warehouse);

            }


            current_line = bufferedReader.readLine();

            nb_orders = Integer.parseInt(current_line);




            for (int i = 0; i < nb_orders; i++) {
                String first = bufferedReader.readLine();
                int roworder, columOrder;
                String[] splitted_first = first.split(" ");

                roworder = Integer.parseInt(splitted_first[0]);
                columOrder = Integer.parseInt(splitted_first[1]);
                Commands commands = new Commands(i,roworder,columOrder);

                String second = bufferedReader.readLine();
                int nb = Integer.parseInt(second);


                String third = bufferedReader.readLine();
                String[] thirs_splitted = third.split(" ");
                for (int j = 0; j < nb; j++) {

                }



                commandsList.add(commands);


            }


        }
    }
}
