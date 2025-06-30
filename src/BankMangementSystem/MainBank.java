package BankMangementSystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean a=true;
        List<Bank> l1=new LinkedList<>();
        System.out.println("Press 1 for Add Account   2 for Deposit   3 for Withdraw   4 for Show All Accounts  5 for Exit");

        while(a){

            int b= sc.nextInt();
            switch(b){
                case 1:
                    int id=sc.nextInt();
                    String name= sc.nextLine();
                    sc.nextLine();
                    double balance= sc.nextDouble();

                    l1.add(new Bank(id,name,balance));
                    System.out.println("Added Sucessfully");
                    break;
                case 2:
                    if(l1.isEmpty()){
                        System.out.println("No account");
                    }
                    else{
                    int id1 =sc.nextInt();
                    boolean t=false;
                    for(Bank s:l1) {
                        if (s.getId() == id1) {
                            int d= sc.nextInt();
                            t=true;
                            int e= (int) (d+s.getBalance());
                            s.setBalance(e);
                            System.out.println(e);
                            break;
                        }

                    }
                    if(!t){
                        System.out.println("No Account found ");
                    }
                    System.out.println("Deposites money");}
                    break;
                case 3:
                    if(l1.isEmpty()){
                        System.out.println("No account");
                    }
                    else{
                    int id2=sc.nextInt();
                    for(Bank s:l1){
                        if(s.getId()==id2){
                            int f=sc.nextInt();
                            int g=(int)(s.getBalance()-f);
                            if(g<0){
                                System.out.println("Insufficient balance");
                            }
                            else{
                                s.setBalance(g);
                                System.out.println(f+" amount is debited from your account");
                            }
                        }}
                    }break;
                case 4:
                    if(l1.isEmpty()){
                        System.out.println("No data");
                    }
                    else{
                    for(Bank s:l1){
                        System.out.println(s);
                    }
                    System.out.println("All accounts are displayed");}
                    break;
                case 5:
                    a=false;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("As of now only above option are avaible ");
            }


        }

    }
}
