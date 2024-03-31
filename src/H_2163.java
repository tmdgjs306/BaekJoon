import java.util.Scanner;

public class H_2163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int temp = n-1;
        sum += temp;
        sum += (n) * (m-1);
        System.out.print(sum);
    }
}
