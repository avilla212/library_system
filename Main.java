import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;



public class Main {

    final static int TWO_SECONDS = 2000;
    public static void main(String[] args){
        
        getLibrary_card_info();
    }

    public static void welcome_message(){

        print("\nWelcome to the Library Management System");
        print("Please select an option from the following menu:");

    }

    public static void menu(){
        
        print("\n1. Add a book");
        print("\n2. Issue a book");
        print("\n3. Return a book");
        print("\n4. View all books");
        print("\n5. View all issued books");
        print("\n6. Exit");

    }

    public static void switch_case_for_menu(){
        
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        
        int choice;

        try {
            do {
                System.out.print("\nPlease select an option from the following menu: " );
                choice = scanner.nextInt();
                scanner.nextLine();
    
                switch (choice){
                    case 1 : {
                        System.out.print("\nEnter the title of the book: ");
                        String title = scanner.nextLine();
                        
                        System.out.print("\nEnter the author of the book: ");
                        String author = scanner.nextLine();
    
                        System.out.print("\nEnter the IBSN of the book: ");
                        String IBSN = scanner.nextLine();
    
                        System.out.print("\nAre you sure you want to add this book? (Y/N): ");
                        String confirmation = scanner.nextLine();
    
                        if(confirmation.toUpperCase().equals("Y")){
                            Book book = new Book(title, author, IBSN);
                            library.addBook(book);
                            System.out.println("Book added successfully!");
                        } else {
                            System.out.println("Book not added!");
                        }
                        
                        print("\nLoading..." + "\n");
                        sleep(TWO_SECONDS);
                        
                        menu();
                        break;

                    }
                    
                    // Check out book 
                    case 2 : {
                        
                        System.out.print("\nEnter the title of the book you want to issue: ");
                        String title = scanner.nextLine();
    
                        System.out.print("\nEnter the author of the book you want to issue: ");
                        String author = scanner.nextLine();
    
                        System.out.print("\nEnter the IBSN of the book you want to issue: ");
                        String IBSN = scanner.nextLine();
    
                        System.out.print("\nAre you sure you want to issue this book? (Y/N)");
                        String confirmation = scanner.nextLine();
                        
                        /*
                        * Using our checkOut method from the Library class we can check out a book
                        */
                        if(confirmation.toUpperCase().equals("Y")){
                            Book book = new Book(title, author, IBSN);
                            library.checkOut(book);
                        } else {
                            System.out.println("Book not issued!");
                        }
    
                        print("\nLoading..." + "\n");
                        sleep(TWO_SECONDS);
                        
                        menu();
                        break;
                    }
    
                    case 3 : {
                        
                        System.out.print("\nEnter the title of the book you want to return: ");
                        String title = scanner.nextLine();
    
                        System.out.print("\nEnter the author of the book you want to return: ");
                        String author = scanner.nextLine();
    
                        System.out.print("\nEnter the IBSN of the book you want to return: ");
                        String IBSN = scanner.nextLine();
    
                        System.out.print("\nAre you sure you want to return this book? (Y/N)");
                        String confirmation = scanner.nextLine();
    
                        if (confirmation.toUpperCase().equals("Y")){
                            Book book = new Book(title, author, IBSN);
                            library.returnBook(book);
                        } else {
                            System.out.println("Book not returned!");
                        }
    
                        print("\nLoading...");
                        sleep(TWO_SECONDS);
                        
                        menu();
                        break;
                    }
    
                    case 4 : {
                        print(library.getBooks_toString());
                        print("\nLoading..." + "\n");
                        
                        sleep(TWO_SECONDS);
                        menu();
                        
                        break;
                    }
    
                    case 5 : {
                        print(library.getIssuedBooks_toString());
    
                        print("\nLoading..." + "\n");
    
                        sleep(TWO_SECONDS);
                        menu();
                        
                        break;
                    }
    
                    case 6 : {
                       
                        print("Thank you for using the Library Management System!");
                        break;

                    }
    
                    default : {
                        print("Invalid option selected!");
                        print("\nLoading...\n");
                        
                        sleep(TWO_SECONDS);
                        menu(); 
            
                        break;
                    }
                }
            }  while (choice != 6);
    
            scanner.close();

        } catch (InputMismatchException e){
            
            print("Invalid option selected!");
            print("\nLoading...\n");
            
            sleep(TWO_SECONDS);
            menu();
            
            switch_case_for_menu();

        }
    }

    public static void print(Object o){
        System.out.print(o);
    }

    public static void sleep(int milliseconds){
        try{
            
            Thread.sleep(milliseconds);

        } catch (InterruptedException e){
           
            e.printStackTrace();

        }
    }

    public static void getLibrary_card_info(){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        print("\nBefore we begin, would you you like a libray card?\nUser's without a library card will only be able add books and view them");
        System.out.print("\nPlease enter Y for yes or N for no(Y/N): ");
        String choice = scanner.nextLine();

        try {
            if (choice.toUpperCase().equals("Y")){
                
                print("\nPlease enter your full name: ");
                String full_name = scanner.nextLine();

                print("\nPlease enter your address: ");
                String address = scanner.nextLine();

                int id = random.nextInt(1000000);
                print("\nGenerated ID: " + id);    

                Library_card libraryCard = new Library_card(full_name, address, id);
                print(libraryCard.toString());

                print("\nIs your name and phone number correct? (Y/N): ");
                String confirmation = scanner.nextLine();

                if(confirmation.toUpperCase().equals("Y")){
                    libraryCard.add_user_info_to_hashmap();
                    print("Library card created successfully!" + "\n");
                    
                    menu();
                    switch_case_for_menu();
        
                } else {
                    
                    print("Library card not created! Come back when you want to create one :D");
                
                }
            } else if (choice.toUpperCase().equals("N")){
                
                print("\nCome back when you want to create a library card!");
        
            } else {
                
                print("\nInvalid option selected!");
                print("\nLoading...\n");
                
                sleep(TWO_SECONDS);
                getLibrary_card_info();
            }

        scanner.close();

        } catch (InputMismatchException e){
            
            print("Invalid option selected!");
            print("\nLoading...\n");
            
            sleep(TWO_SECONDS);
            getLibrary_card_info();
        }
    }
}