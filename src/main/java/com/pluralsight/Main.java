package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Product> inventory;
        inventory = getInventory();

       //DisplayProducts(inventory);
        DisplayCart(Cart(inventory));
       //Cart(inventory);

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
    private static void DisplayProducts(ArrayList<Product> inventory){
        for(int i = 0; i < inventory.size(); i++){
            Product n = inventory.get(i);

            System.out.printf("SKU: %s %s - Price:$%.2f %s\n ", n.getSku(), n.getName(), n.getPrice(), n.getDepartment());
        }
    }
    private static ArrayList<Product> Cart(ArrayList<Product> inventory){
        ArrayList<Product> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What items would you like to add to cart? ");
        String item = scanner.nextLine();


        for(int i = 0; i < inventory.size(); i++){
            Product p = inventory.get(i);

            if(p.getSku().equalsIgnoreCase(item)){
                result.add(p);
                System.out.println("Add to cart: " + p.getName());
            }

        }
        return result;
    }

    private static void DisplayCart(ArrayList<Product> cart){
        for(int i = 0; i < cart.size(); i++) {
            Product n = cart.get(i);

            if(cart.isEmpty()){
                System.out.println("You cart is empty!");
            }else{
                System.out.printf("SKU: %s %s - Price:$%.2f %s\n ", n.getSku(), n.getName(), n.getPrice(), n.getDepartment());
            }
        }
    }
}
