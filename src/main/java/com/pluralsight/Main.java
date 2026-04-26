package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Product> inventory;
        inventory = getInventory();

        //System.out.println("The current list: ");

        for(int i = 0; i < inventory.size(); i++){
            Product n = inventory.get(i);

            System.out.printf("SKU: %s %s - Price:$%.2f %s\n ", n.getSku(), n.getName(), n.getPrice(), n.getDepartment());
        }


    }
    private static ArrayList<Product> getInventory(){
        ArrayList<Product> result = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("products.csv"));

            String line;

            //skip the header
            reader.readLine();


            //creating a loop that reads line by line.
            while((line = reader.readLine()) != null ){

                Product p = new Product(line);

                // Adds information to the Array list.
                result.add(p);
            }
            reader.close();

        } catch (Exception e) {

            System.out.println("Error: "+ e.getMessage());
        }
        return result;
    }
}
