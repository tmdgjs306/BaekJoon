import java.util.Scanner;

public class H_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] list = new int[43];
        for(int i=0; i<10; i++)
        {
            int temp =sc.nextInt();
            list[temp%42]=1;
        }
        int result= 0;
        for(int i=0; i<=42; i++)
        {
            result+=list[i];
        }
        System.out.print(result);
    }
}
