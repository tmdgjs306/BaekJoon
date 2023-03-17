import java.util.Scanner;

public class H_2421 {
    // 소수 판별
    public static boolean isPrime(int n){
        if(n< 2){
            return false;
        }
        if(n==2)
            return true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i ==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 11의 경우 0 반환
        if(n==1){
            System.out.println(0);
            return;
        }
        int [][] dp = new int [n+1][n+1];
        dp[1][1] = 0;

        //dp 배열 초기화
        for(int i=2; i<=n; i++) {
            int num = 10+i;
            if(isPrime(num)==true){
                dp[1][i] = dp[1][i-1]+1;
            }
            else
                dp[1][i] = dp[1][i-1];
        }

        //dp 배열 계산
        for(int i=2; i<=n; i++){
            for(int j=1; j<=n; j++){
                int digits = (int)Math.log10(j)+1;
                double temp = Math.pow(10,digits);
                int num = (int)(i*temp) + j;
                if(isPrime(num)){
                    if(j!=0)
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+1;
                    else
                        dp[i][j] = dp[i-1][j]+1;
                }
                else{
                    if(j!=0)
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }

        //결과 값 출력
        System.out.print(dp[n][n]);
    }
}
