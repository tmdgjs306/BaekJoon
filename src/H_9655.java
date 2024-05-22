import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int[2][1001];
        int [] stone = {1,3};
        dp[0][n] = 1;

        for(int i=n; i>=0; i--){
            for(int j=0; j<=1; j++){
                if(dp[j][i]==1){
                    for(int k=0; k<=1; k++){
                        int minus = stone[k];
                        int nextPeople;
                        if(i-minus>=0){
                            if(j==1) nextPeople = 0;
                            else  nextPeople = 1;
                            dp[nextPeople][i-minus] = 1;
                        }
                    }
                }
            }
        }

        if(dp[0][1]==1 || dp[0][3]==1){
            System.out.print("SK");
        }
        else {
            System.out.print("CY");
        }
    }
}
