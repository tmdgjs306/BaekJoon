import java.util.Arrays;
import java.util.Scanner;

public class H_11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] upDp = new int[n+1][1002];
        int [][] downDp= new int[n+1][1002];
        int [] values = new int[n+1];
        for(int i=1; i<=n; i++){
            values[i] = sc.nextInt();
        }
        for(int i=0; i<=n; i++){
            Arrays.fill(upDp[i],-1);
            Arrays.fill(downDp[i],-1);
        }
        upDp[0][0] = 0;
        downDp[0][1001] =0;
        for(int i=0; i<n; i++){
            int next = values[i+1];
            for(int j=0; j<=1001; j++){
                if(downDp[i][j]==-1)continue;
                else{
                    if(next<j){
                        downDp[i+1][next] = Math.max(downDp[i+1][next],downDp[i][j]+1);
                    }
                    downDp[i+1][j] = Math.max(downDp[i+1][j],downDp[i][j]);
                }
            }
            for(int j=0; j<=1001; j++){
                if(upDp[i][j]==-1) continue;
                else{
                    if(next>j){
                        upDp[i+1][next] = Math.max(upDp[i+1][next],upDp[i][j]+1);
                    }
                    if(next<j){
                        downDp[i+1][next] = Math.max(downDp[i+1][next],upDp[i][j]+1);
                    }
                    upDp[i+1][j] = Math.max(upDp[i+1][j],upDp[i][j]);
                }
            }
        }
        int max = 0;
        for(int i=0; i<=1000; i++){
            if(upDp[n][i]>max) {
                max=upDp[n][i];
            }
            if(downDp[n][i]>max) {
                max = downDp[n][i];
            }
        }
        System.out.print(max);
    }
}
