import java.util.Scanner;

class Library{
    String[] books;
    int no_of_books;
    Library(){
        this.books = new String[100];
        this.no_of_books = 0;
    }

    void addBook(){
        System.out.println("Enter the name of book you want to add");
        Scanner sc=new Scanner(System.in);
        String book= sc.nextLine();
        this.books[no_of_books] = book;
        no_of_books++;
        System.out.println(book+ " has been added!");
    }
    void addBook(String book1){
        this.books[no_of_books] = book1;
        no_of_books++;
        System.out.println(book1+ " has been added!");
    }

    void showAvailableBooks(){
        System.out.println("Available Books are:");
        for (String book : this.books) {
            if (book == null){
                continue;
            }
            System.out.println("* " + book);
        }
    }

    void issueBook(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of book you want to issue");
        if (sc.hasNext()){
        String book = sc.nextLine();
        for (int i=0;i<this.books.length;i++){
            if (this.books[i].equals(book)){
                System.out.println("The book has been issued!");
                this.books[i] = null;
                break;
            }
            else {
                System.out.println("This book doesnt exit");
                break;
            }

        }
        }
    }

    void returnBook(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of book you want to return");
        String ret = sc.nextLine();
        addBook(ret);
    }
}
public class LIbrary_management_system {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Library centralLibrary = new Library();
            boolean b = true;
            while (b) {
                System.out.println("\n\t\t\tWelcome to Library" +
                        "\nEnter 1 to see available books" +
                        "\nEnter 2 to add book in library" +
                        "\nEnter 3 to issue book" +
                        "\nEnter 4 to return book" +
                        "\nEnter 5 to exit");
                if (sc.hasNextInt()) {
                    int user_choice = sc.nextInt();
                    switch (user_choice) {
                        case 1:
                            centralLibrary.showAvailableBooks();
                            break;
                        case 2:
                            centralLibrary.addBook();
                            break;
                        case 3:
                            centralLibrary.issueBook();
                            centralLibrary.showAvailableBooks();
                            break;
                        case 4:
                            centralLibrary.returnBook();
                            centralLibrary.showAvailableBooks();
                            break;
                        case 5:
                            System.out.println("Exiting the library");
                            b = false;
                            break;
                        default:
                            System.out.println("Invalid input");
                    }
                } else{
                    System.out.println("You have entered invalid input" +
                            "\nExiting the library");
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Exiting the library...");
        }
    }
}