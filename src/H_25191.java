import java.util.Scanner;

public class H_25191 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int coke = sc.nextInt();
        int beer = sc.nextInt();
        int sum = (coke/2)+beer;
        if(sum>=c)
            System.out.print(c);
        else
            System.out.print(sum);
    }
}
