import java.util.Scanner;

public class psmv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long sum = n-m;
        System.out.println(Math.abs(sum));
    }
}
