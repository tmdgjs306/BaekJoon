import java.util.Scanner;

public class H_27110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<3; i++){
            int temp  = sc.nextInt();
            if(temp>=n){
                sum+=n;
            }else{
                sum+=temp;
            }
        }
        System.out.print(sum);
    }
}
