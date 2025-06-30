package BankMangementSystem;

public class Bank {
    private int id;
    private String name;
    private double balance;

    public Bank(int id,String name,double balance) {
        this.balance = balance;
        this.id = id;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Balance: ₹" + String.format("%.2f", balance);
    }

}
