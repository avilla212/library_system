public class Book {

    String title;
    String author;
    String ISBN;

    public Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getISBN(){
        return this.ISBN;
    }

    public String toString() {
        return this.getTitle() + " by " + this.getAuthor() + " with ISBN " + this.getISBN();
    }
    

}