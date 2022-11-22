import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] price = new int [n];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens())
        {
            price[index++] = Integer.parseInt(st.nextToken());
        }
        int v =Integer.parseInt(br.readLine());
        String [] dp = new String[v+1];
        Arrays.fill(dp,"-1");
        dp[v]= "0";
        for(int i=v; i>=0; i--)
        {
            for(int j=0; j<n; j++)
            {
                if(j==0 && dp[i]=="-1") continue;
                if(i>=price[j]&&!(dp[i].equals("-1")))
                {
                    String tp;
                    if(dp[i]=="0")
                        tp = Integer.toString(j);
                    else {
                        tp = dp[i].concat(Integer.toString(j));
                    }
                    int id = i-price[j];
                    BigInteger left;
                    if(dp[id]==null)
                    {
                        left = new BigInteger("0");
                    }
                    else {
                        left = new BigInteger(dp[id]);
                    }
                    BigInteger right = new BigInteger(tp);
                    if(left.compareTo(right)==1)
                        dp[id]= left.toString();
                    else
                        dp[id] = right.toString();
                }
            }
        }
        BigInteger max = new BigInteger("0");
        for(int i=0; i<=v; i++ )
        {
            System.out.println("i: "+i+" "+dp[i]);
            if(dp[i]!=null) {
                BigInteger temp = new BigInteger(dp[i]);
                if (max.compareTo(temp) == -1)
                    max = temp;
                else
                    continue;
            }
        }
        System.out.print(max.toString());
    }
}
