import java.util.Arrays;
import java.util.Scanner;

public class H_14503 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;
        int [][] map = new int [n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        while(true)
        {
            if(map[r][c]==0)
            {
                count++;
                map[r][c]=2;
            }
            boolean is_find=false;
            for(int i=0; i<4; i++)
            {
                int nowr;
                int nowc;
                if(d==0)
                {
                    nowr=r;
                    nowc=c-1;
                    d=3;
                }
                else if(d==3) {
                    nowr=r+1;
                    nowc=c;
                    d=2;
                }
                else if(d==2) {
                    nowr=r;
                    nowc=c+1;
                    d=1;
                }
                else {
                    nowr=r-1;
                    nowc=c;
                    d=0;
                }
                if(map[nowr][nowc]!=0) continue;
                r=nowr;
                c=nowc;
                is_find=true;
                break;
            }
            if(!is_find)
            {
                int nowr;
                int nowc;
                if(d==0)
                {
                    nowr=r+1;
                    nowc=c;
                }
                else if(d==3) {
                    nowr=r;
                    nowc=c+1;
                }
                else if(d==2) {
                    nowr=r-1;
                    nowc=c;
                }
                else {
                    nowr=r;
                    nowc=c-1;
                }
                if(map[nowc][nowr]==1)
                {
                   break;
                }
                else
                {
                    r=nowr;
                    c=nowc;
                }
            }
        }
        System.out.println(count);
    }
}
