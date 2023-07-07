import java.io.BufferedReader;
import java.util.Scanner;

public class H_2935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.next();
        String c = sc.next();
        String l2 = sc.next();
        StringBuilder reslut = new StringBuilder();
        if(c.equals("+")){
            int a = l1.length();
            int b = l2.length();
            if(a==b){
                reslut = new StringBuilder(l1);
                reslut.replace(0,0,"2");
            }
            else if(a>b){
                reslut = new StringBuilder(l2);
                reslut.replace(b,b,"1");
            }
            else{
                reslut = new StringBuilder(l1);
                reslut.replace(2,a-1,"1");
            }
        }
        System.out.println(reslut);
    }
}
