import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    int yearPublished;
    boolean isAvailable = true;
    int days = 3;

    boolean searchBook(String title) {
        if (title.equals(this.title)) {
            DisplayInfo();
            return true;
        }
        return false;
    }

    boolean searchBook(String author, int yearPublished) {
        if (author.equals(this.author) && yearPublished == this.yearPublished) {
            DisplayInfo();
            return true;
        }
        return false;
    }

    boolean searchBook(int bookId) {
        if (bookId == this.bookId) {
            DisplayInfo();
            return true;
        }
        return false;
    }

    boolean issueBook(int bookId, int patronId) {
        if (isAvailable == true) {
            isAvailable = false;
            System.out.println("Book issued sucessfully for 3 days");
            return true;
        } else {
            System.out.println("Sorry Not available");
            return false;
        }
    }

    boolean issueBook(int bookId, int patronId, int days) {
        if (isAvailable == true) {
            isAvailable = false;
            System.out.println("Book issued sucessfully for " + days + " days");
            this.days = days;
            return true;
        } else {
            System.out.println("Sorry Not available");
            return false;
        }
    }

    void DisplayInfo() {
        System.out.println("Book Id:" + bookId +
                "\nTitle:" + title + "\nAuthor:" +
                author + "\nYear of publication: " + yearPublished + "\nAvailability: " + isAvailable + "\n");
    }
}

class Patron {
    int patronId = 1;
    String name;
    String membershipType;
    int age = 18;
    ArrayList<Book> bookIssued = new ArrayList<>();

    void addPatron(String name, String membershipType, int patronId) {
        this.name = name;
        this.membershipType = membershipType;
        this.patronId = patronId;
    }

    void addPatron(String name, String membershipType, int age, int patronId) {
        this.name = name;
        this.membershipType = membershipType;
        this.patronId = patronId;
        this.age = age;
    }

    void viewIssuedBooks() {
        boolean key = false;
        for (int i = 0; i < bookIssued.size(); i++) {
            key = true;
            bookIssued.get(i).DisplayInfo();
        }
        if (key == false) {
            System.out.println("No books Issued\n");
        }
    }
}

public class Library {
    static int key3 = 001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> b = new ArrayList<>();
        // addBook
        int key = 0;
        int patkey = 1;
        boolean mark = false;
        String name;
        String membershipType;
        int age;
        int days;
        int i = 0;
        int key2 = 0;
        int patronId;
        String title;
        String author;
        int yearPublished;
        int bookId;
        Patron kp = new Patron();
        ArrayList<Patron> p = new ArrayList<>();
        b.add(addBook("Ramayana", "Valmiki", 1905));
        b.add(addBook("Mahabharata", "Vasista", 1909));
        b.add(addBook("Bhagavath Geetha", "Sri Krishna", 1920));
        b.add(addBook("Panchatantra", "Darmaseena", 1958));
        kp.addPatron("Kavana", "Regular", patkey++);
        p.add(kp);
        kp = new Patron();
        kp.addPatron("ammu", "Premium", patkey++);
        p.add(kp);
        kp = new Patron();
        kp.addPatron("acchu", "Premium", patkey++);
        p.add(kp);
        while (true) {
            System.out.println(
                    "Enter 0:New Member\nEnter 1:Add a book to your patron id\nEnter 2:Return a book\nEnter 3:View your Issued Books\nEnter 4:Search a book\nEnter 5:Add Book(office use only)");
            key = sc.nextInt();
            switch (key) {
                case 0: {
                    System.out.println("Welcome,Please Enter your name: ");
                    name = sc.next();
                    System.out.println("Membership Type(Regular/Premium): ");
                    membershipType = sc.next();
                    System.out.println("Would you like to share your age,Yes/No");
                    if (sc.next().equals("yes")) {
                        System.out.println("Age: ");
                        age = sc.nextInt();
                        kp = new Patron();
                        kp.addPatron(name, membershipType, age, patkey++);
                        p.add(kp);
                    } else {
                        kp = new Patron();
                        kp.addPatron(name, membershipType, patkey++);
                        p.add(kp);
                    }
                    System.out.println("Your patron id is: " + kp.patronId);
                    break;
                }
                case 1: {
                    System.out.println("Please Enter your Patron Id: ");
                    patronId = sc.nextInt();
                    mark = false;
                    for (i = 0; i < p.size(); i++) {
                        if (patronId == p.get(i).patronId) {
                            mark = true;
                            break;
                        }
                    }
                    if (mark == true) {
                        System.out.println("Enter the number of days of booking(minimun 3 days)");
                        days = sc.nextInt();
                        if (days == 3) {
                            System.out.println("Enter the book ID");
                            bookId = sc.nextInt();
                            for (int j = 0; j < b.size(); j++) {
                                if (bookId == b.get(j).bookId) {
                                    mark = b.get(j).issueBook(bookId, patronId);
                                    if (mark == true) {
                                        p.get(i).bookIssued.add(b.get(j));
                                    }
                                }
                            }
                        } else {
                            System.out.println("Enter the book ID");
                            bookId = sc.nextInt();
                            for (int j = 0; j < b.size(); j++) {
                                if (bookId == b.get(j).bookId) {
                                    mark = b.get(j).issueBook(bookId, patronId, days);
                                    if (mark == true) {
                                        p.get(i).bookIssued.add(b.get(j));
                                    }
                                }
                            }
                        }
                    }
                    break;

                }
                case 2: {
                    System.out.println("Please Enter your patron Id: ");
                    patronId = sc.nextInt();
                    mark = false;
                    for (i = 0; i < p.size(); i++) {
                        if (patronId == p.get(i).patronId) {
                            mark = true;
                            break;
                        }
                    }
                    if (mark == true) {
                        System.out.println("Enter the book ID");
                        bookId = sc.nextInt();
                        for (int j = 0; j < b.size(); j++) {
                            if (bookId == b.get(j).bookId) {
                                System.out.println("Please enter the number of days Delayed");
                                days = sc.nextInt();
                                if (days == 0) {
                                    returnBook(b.get(j), p.get(i));
                                } else {
                                    returnBook(b.get(j), p.get(i), days);
                                }
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Please Enter your patron Id: ");
                    patronId = sc.nextInt();
                    mark = false;
                    for (i = 0; i < p.size(); i++) {
                        if (patronId == p.get(i).patronId) {
                            mark = true;
                            break;
                        }
                    }
                    if (mark == true) {
                        p.get(i).viewIssuedBooks();
                    }
                    break;
                }
                case 4: {
                    System.out.println(
                            "Enter 1:To search by title\nEnter 2:Author name and Year of publication\nEnter 3:BookId");
                    key2 = sc.nextInt();
                    switch (key2) {
                        case 1: {
                            System.out.println("Enter the title: ");
                            title = sc.next();
                            for (int j = 0; j < b.size(); j++) {
                                mark = b.get(j).searchBook(title);
                                if (mark == true) {
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the Author name and Year of publication");
                            author = sc.next();
                            yearPublished = sc.nextInt();
                            for (int j = 0; j < b.size(); j++) {
                                mark = b.get(j).searchBook(author, yearPublished);
                                if (mark == true) {
                                    break;
                                }
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Enter the bookId: ");
                            bookId = sc.nextInt();
                            for (int j = 0; j < b.size(); j++) {
                                mark = b.get(j).searchBook(bookId);
                                if (mark == true) {
                                    break;
                                }
                            }
                            break;
                        }
                        default:
                            System.out.println("Wrong Input");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Please Enter the Book title: ");
                    title = sc.next();
                    System.out.println("Author: ");
                    author = sc.next();
                    System.out.println("Year od publication: ");
                    yearPublished = sc.nextInt();
                    b.add(addBook(title, author, yearPublished));
                    break;
                }
                default:
                    System.out.println("Wrong Input");
            }
        }
    }

    static Book addBook(String title, String author, int yearPublished) {
        Book b1 = new Book();
        b1.title = title;
        b1.author = author;
        b1.yearPublished = yearPublished;
        b1.bookId = key3++;
        System.out.println();
        b1.DisplayInfo();
        return b1;
    }

    static Book addBook(Book b) {
        Book b1 = new Book();
        b1.title = b.title;
        b1.author = b.author;
        b1.yearPublished = b.yearPublished;
        b1.bookId = key3++;
        b1.DisplayInfo();
        return b1;
    }

    static void returnBook(Book b, Patron p) {
        b.isAvailable = true;
        System.out.println("Book returned sucessfully\n");
        p.bookIssued.remove(b);
    }

    static void returnBook(Book b, Patron p, int days) {
        b.isAvailable = true;
        double delayCharges = (days) * 7;
        System.out.println("Delay charges: " + delayCharges);
        p.bookIssued.remove(b);
    }
}
