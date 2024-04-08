import java.util.Scanner;

public class H_27433 {
    public static long factorial(int n){
        if(n==0)return 1;
        if(n==1){
            return 1;
        }
        else return n*factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(factorial(n));
    }
}
