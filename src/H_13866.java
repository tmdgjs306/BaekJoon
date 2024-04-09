import java.util.Scanner;

public class H_13866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int sum1 = a+d;
        int sum2 = b+c;

        System.out.print(Math.abs(sum1-sum2));
    }
}
