import java.util.Scanner;

public class H_2010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        for(int i=1; i<n; i++){
            int tp = sc.nextInt();
            sum += tp-1;
        }
        System.out.print(sum);
    }
}
