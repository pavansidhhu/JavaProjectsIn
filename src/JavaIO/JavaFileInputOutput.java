package JavaIO;

import java.io.*;
import java.util.*;

public class JavaFileInputOutput {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write a note");
            System.out.println("2. Read notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return; // exit the main method
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void writeNote(Scanner sc) {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try {FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(note + "\n");
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
    }

    public static void readNotes() {
        try {BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found");
        } catch (IOException e) {
            System.out.println("Exception occurred : " + e.getMessage());
        }
    }
}
