import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class H_B {
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int [] list = new int[3];
       for(int i=0; i<3; i++)
       {
           list[i] = sc.nextInt();
       }
        Arrays.sort(list);
       for(int i=0; i<3; i++)
       {
           System.out.print(list[i]+" ");
       }
    }
}
