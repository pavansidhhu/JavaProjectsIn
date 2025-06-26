package StudentManagement;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int marks;

    public Student(int id,String name,int marks) {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }
    public String toString(){
        return id+" "+name+" "+marks;
    }
}
