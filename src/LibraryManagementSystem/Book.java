package LibraryManagementSystem;


import java.util.LinkedList;
import java.util.*;
import java.util.Collections;

public class Book {
    static List<Library>l1=new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean a=true;
        while(a){
            System.out.print("Press 1 BookIssue ");

            System.out.print("  2 BookReturn");

            System.out.print("  3 Display");

            System.out.print("  4 Exit");
            System.out.println();
            int b= sc.nextInt();
            switch(b){
                case 1:
                    BookIssue();
                    break;
                case 2:
                    BookReturn(sc);
                    break;
                case 3:
                    Display();
                    break;
                case 4:
                    a=false;
                    System.out.println("Loop Exits");
                    break;

                default:
                    System.out.println("Invalid");

            }

        }
    }
    public static void BookIssue(){
        System.out.println("Added the Book details");
        l1.add(new Library(201, "Java Basics", "Raj", "20 June", "24 June"));
        l1.add(new Library(202, "Data Structures", "Amit", "21 June", "25 June"));
        l1.add(new Library(203, "OOP Concepts", "Tina", "22 June", "26 June"));
        l1.add(new Library(204, "DSA Made Easy", "Neel", "23 June", "27 June"));
        l1.add(new Library(205, "Core Java", "Sara", "24 June", "28 June"));



    }
    public static void Display(){
        for(Library p:l1){
            System.out.println(p);
        }
    }
    public static void BookReturn(Scanner sc) {
        System.out.println("Enter the book ID to be return:");
        int d = sc.nextInt();

        if (l1.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Library toRemove = null;

        for (Library s : l1) {
            if (s.getBookid() == d) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            l1.remove(toRemove);
            System.out.println("Book return.");
        } else {
            System.out.println("Book is not issued.");
        }
    }

}

