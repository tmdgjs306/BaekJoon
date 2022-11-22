import java.util.Scanner;

public class HH_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [] map = new char[n];
        String temp =sc.next();
        for(int i=0; i<n; i++)
        {
            map[i]= temp.charAt(i);
        }
        int m = sc.nextInt();
        String s = sc.next();

        for(int i=0; i<m; i++)
        {
            char a= s.charAt(i);
            boolean isF = false;
            for(int j=0; j<n; j++)
            {
                if(map[j]==a)
                {
                    isF=true;
                    break;
                }
            }
            if(!isF)
            {
                System.out.print(-1);
                return;
            }
        }

        int point =  n-1;
        long count = 0;
        int find = 0;

        while(true)
        {
            if(find==m) break;
            point++;
            if(point>=n) point=0;
            if(map[point]==s.charAt(find))
            {
                find++;
                count++;
            }
            else
            {
                count++;
            }
        }
        System.out.print(count);
    }
}
