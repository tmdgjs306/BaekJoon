import java.util.Scanner;

public class H_4097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            int n = sc.nextInt();
            if(n==0)
                break;
            int [] list = new int[n];
            for(int i=0; i<n; i++){
                list[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0; i<n; i++){
                if(list[i]>=0){
                    sum+=list[i];
                    max = Math.max(sum,max);
                }
                else{
                    sum += list[i];
                    max = Math.max(max,list[i]);
                    if(sum<0){
                        sum=0;
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
