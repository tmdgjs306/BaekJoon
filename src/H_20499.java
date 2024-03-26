import java.util.Scanner;
import java.util.StringTokenizer;

public class H_20499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringTokenizer st = new StringTokenizer(s,"/");
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        if(d == 0 || k+a<d){
            System.out.print("hasu");
        }
        else{
            System.out.print("gosu");
        }
    }
}
