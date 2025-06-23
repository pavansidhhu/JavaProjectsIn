import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalcProject {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

       // System.out.println(0/0);
        while(true) {
            System.out.println("1st No :");
            int a = sc.nextInt();
            System.out.println("2nd No :");
            int b= sc.nextInt();
            System.out.println("Type the Operation or if u want to exit the loop type e or E");
            char c=sc.next().charAt(0);
            switch(c){
                case '+':
                    System.out.println("Add:"+a+b);
                    break;
                case '-':
                    System.out.println("Sub:"+(a-b));
                    break;
                case'*':
                    System.out.println("Multiply:"+(a*b));
                    break;
                case'/':
                    if(b==0) {
                        System.out.println("undefined");
                    }
                    else{
                        float f=a;
                        float i=b;
                        System.out.println(f/i);
                    }
                    break;
                case'%':
                    if(b==0) {
                        System.out.println("undefined");
                    }
                    else{
                        float f=a;
                        float i=b;
                        System.out.println(f%i);
                    }
                    break;
                case 'e':
                case'E':
                    System.out.println("Exiting the loop");
                    break;
                default:
                    System.out.println("Thank for using your Calculator Console");






            }

        }
    }
}