
import java.util.HashMap;


/*
 * We are going to use this library card class to store the information of the library card 
 * We will use strings to store the information of the library card
 * 
 * User will set name, address and be given a generated ID in the Main.java file 
 */

 public class Library_card {
    private String full_name;
    private String address;
    private int card_id;

    // User info will be store into a hashmap 
    HashMap<Integer, String> library_card_info = new HashMap<Integer, String>();

    // Constructor
    public Library_card(String full_name, String address, int card_id){
        this.full_name = full_name;
        this.address = address;
        this.card_id = card_id;
    }

    // Getters
    public String get_full_name(){
        return this.full_name;
    }

    public String get_address(){
        return this.address;
    }

    public int get_card_id(){
        return this.card_id;
    }

    public String toString(){
        return "\nFull name: " + this.full_name + "\nAddress: " + this.address + "\nCard ID: " + this.card_id;
    }

    // Setters
    public void set_full_name(String full_name){
        this.full_name = full_name;
    }

    public void set_address(String address){
        this.address = address;
    }

    public void set_card_id(int card_id){
        this.card_id = card_id;
    }

    // Method to add user info to the hashmap
    public void add_user_info_to_hashmap(){
 
        library_card_info.put(this.card_id, this.full_name);
        library_card_info.put(this.card_id, this.address);
    }

    // Method to print the user info
    public void print_user_info(){
        System.out.println("Full name: " + this.full_name);
        System.out.println("Address: " + this.address);
        System.out.println("Card ID: " + this.card_id);
    }

}

// show me some basic hashmap commands and how to use them

