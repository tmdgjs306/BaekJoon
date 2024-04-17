import javax.print.DocFlavor;
import java.util.Scanner;

public class H_30017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        boolean cheese = true;
        while (true){
            if(a==0 || !cheese){
                break;
            }
            a-=1;
            count+=1;
            if(a>=1 && b>=1){
                b-=1;
                count++;
            }
            else{
                cheese = false;
            }

        }
        System.out.println(count);
    }
}
