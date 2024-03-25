import java.util.Scanner;

public class H_15964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long A = a+b;
        long B = a-b;
        long result = A*B;
        System.out.println(result);
    }
}
