import java.util.ArrayList;

public class Library extends Main {

    
    ArrayList<Book> books;
    ArrayList<Book> issuedBooks;

    public Library(){
        this.books = new ArrayList<Book>();
        this.issuedBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public ArrayList<Book> getIssuedBooks(){
        return this.issuedBooks;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    
    public void issueBook(Book book){
        this.issuedBooks.add(book);
    }

    public String getBooks_toString() {

        if (this.books.size() == 0) {
            return "\nNo books are available!";
        }

        String available_books = "\nBooks that are available: ";

        for (Book book : this.books){
            available_books += "\n" + book.toString();
        }
        
        return available_books;
    }
    

    public String getIssuedBooks_toString(){
            
            if (this.issuedBooks.size() == 0) {
                return "\nNo books have been checked out!";
            }

            String checked_out_books = "\nBooks that have been checked out: ";

            for (Book book : this.issuedBooks){
                checked_out_books += book.toString() + "\n";
            }
            
            return checked_out_books;
        }
     
    public boolean isBookIssued(Book book){
        return this.issuedBooks.contains(book);
    }

    public void checkOut(Book book){
        // binary search our books arraylist to see if the book is available
        // and remove it from the books arraylist if it is
        int start = 0;
        int end = this.books.size() - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            if (this.books.get(mid).getISBN().equals(book.getISBN())){
                this.issueBook(book);
                this.books.remove(mid);
                break;
            } else if (this.books.get(mid).getISBN().compareTo(book.getISBN()) < 0){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    public void returnBook(Book book){
        // binary search our issued books array to return the book 
        // if no book exists by the ISBN, then the book was never checked out

        int start = 0;
        int end = this.issuedBooks.size() - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            if (this.issuedBooks.get(mid).getISBN().equals(book.getISBN())){
                this.addBook(book);
                this.issuedBooks.remove(mid);
                break;
            } else if (this.issuedBooks.get(mid).getISBN().compareTo(book.getISBN()) < 0){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    

    public static void print(Object o){
        System.out.println(o);
    }

    
    
}
