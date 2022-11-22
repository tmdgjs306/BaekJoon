import java.util.Scanner;

public class H_11718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int min = Math.min(a,Math.min(b,c));
            int d = sc.nextInt();
            int e = sc.nextInt();
            int min2 = Math.min(d,e);
        System.out.println((min+min2)-50);
    }
}
