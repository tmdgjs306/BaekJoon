import java.util.Scanner;

public class H_2591 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int [] val = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            val[i] = s.charAt(i)-'0';
        }
        int size = s.length();
        long [][] dp = new long[size][3];
        if(val[0]==0) {
            System.out.println(0);
            return;
        }
        if(val[0]<3) dp[0][1] = 1;
        if(val[0]>3) dp[0][0] = 1;
        if(val[0] ==3 ) dp[0][2] = 1;
        for(int i=1; i<size; i++){
            for(int j=0; j<3; j++){
                if(dp[i-1][j] !=0){
                    if(val[i]==0) {
                        for(int t= 0; t<3; t++){
                            dp[i][0] +=dp[i-1][t];
                        }
                        continue;
                    }
                    if(i+1<=size-1){
                        if(val[i+1]==0 && val[i]>=4){
                            System.out.println(0);
                            return;
                        }
                        if(val[i+1]==0){
                            for(int t= 0; t<3; t++){
                                dp[i][0] +=dp[i-1][t];
                            }
                            continue;
                        }
                    }
                    if(j==0){
                        if(val[i]<3) dp[i][1] +=dp[i-1][j];
                        if(val[i]>3) dp[i][0] +=dp[i-1][j];
                        if(val[i]==3)  dp[i][2] +=dp[i-1][j];
                    }
                    if(j==1){
                        dp[i][0] +=dp[i-1][j];
                        if(val[i]<3) {
                            dp[i][1] +=dp[i-1][j];
                        }
                        if(val[i]>3) {
                            dp[i][0] +=dp[i-1][j];
                        }
                        if(val[i]==3) {
                            dp[i][2] +=dp[i-1][j];
                        }
                    }
                    if(j==2){
                        if(val[i]<=4) dp[i][0] += dp[i-1][j];
                        if(val[i]<3) {
                            dp[i][1] +=dp[i-1][j];
                        }
                        if(val[i]>3) {
                            dp[i][0] +=dp[i-1][j];
                        }
                        if(val[i]==3) {
                            dp[i][2] +=dp[i-1][j];
                        }
                    }
                }
            }
        }
        long sum =0;
        for(int i=0; i<3; i++){
            sum+=dp[size-1][i];
        }
        System.out.print(sum);
    }
}
