import java.util.Scanner;

public class H_3046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int s = sc.nextInt();
        int i = -10000;
        while (true){
            if((r1+i)/2 == s){
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}
