import java.util.Scanner;

public class H_20492 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = (int)(n*0.8);
        int l1 = n-m;
        int l2 = (int)(l1*0.22);

        int result1 = n - (int)(n*0.22);
        int result2 = m + (l1-l2);
        System.out.print(result1+" "+result2);
    }
}
