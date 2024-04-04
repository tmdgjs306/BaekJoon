import java.util.Scanner;

public class H_15726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();

        double result1 = (a*b)/c;
        double result2 = (a/b)*c;

        double max = Math.max(result1,result2);
        System.out.print((int)max);
    }
}
