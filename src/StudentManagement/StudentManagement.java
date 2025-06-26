package StudentManagement;

import java.util.LinkedList;
import java.util.*;
import java.util.Collections;

public class StudentManagement {
    static List<Student>l1=new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean a=true;
        while(a){
            System.out.print("Press 1 ADD  ");

            System.out.print("  2 View");

            System.out.print("  3 Update");

            System.out.print("  4 delete");
            System.out.println();
            int b= sc.nextInt();
            switch(b){
                case 1:
                    AddStudent();
                    break;
                case 2:
                    View();
                    break;
                case 3:
                    UpdateStudent(sc);
                    break;
                case 4:
                    DeleteStudent(sc);
                    break;
                case 5:
                    a=false;
                    break;

                default:
                    System.out.println("Thank you using our program");

            }

        }
    }
    public static void AddStudent(){
        System.out.println("Added the Student details");
        l1.add(new Student(1,"pavan",70));
        l1.add(new Student(2,"sidhhu",80));
        l1.add(new Student(3,"kumar",80));
        l1.add(new Student(4,"pooja",90));
        l1.add(new Student(5,"shree",95));
        Collections.sort(l1);
    }
    public static void View(){
        for(Student p:l1){
            System.out.println(p);
        }
    }
    public static void UpdateStudent(Scanner sc){
      boolean check=true;
      int id1=sc.nextInt();
        sc.nextLine();
      for(Student s1:l1){
          if(s1.getId()==id1){
              System.out.print("Id::");
              int id=sc.nextInt();
              System.out.print("Name::");
              sc.nextLine();
              String name=sc.nextLine();
              System.out.println("Marks");
              int marks=sc.nextInt();

              s1.setId(id);
              s1.setName(name);
              s1.setMarks(marks);
              System.out.println("Update");
               check=false;
               break;

          }

      }
        if(check){
            System.out.println("Not found");

        }

    }
    public static void DeleteStudent(Scanner sc) {
        System.out.println("Enter the student ID to delete:");
        int d = sc.nextInt();

        if (l1.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Student toRemove = null;

        for (Student s : l1) {
            if (s.getId() == d) {
                toRemove = s;
                break;
            }
        }

        if (toRemove != null) {
            l1.remove(toRemove);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

}

