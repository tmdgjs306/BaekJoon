import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class H_17351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0-> M  1 -> O  2 -> L  3 -> A
        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];
        ArrayList <Integer> [][] list = new ArrayList[n][n];
        for(int i=0; i<n; i++)
        {
            String temp = br.readLine();
            for(int j=0; j<n; j++)
            {
                if(temp.charAt(j)=='M') map[i][j]=0;
                else if(temp.charAt(j)=='O') map[i][j]=1;
                else if(temp.charAt(j)=='L') map[i][j]=2;
                else if(temp.charAt(j)=='A') map[i][j]=3;
                else map[i][j]=4;
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                list[i][j] = new ArrayList<>();
                for(int k=0; k<n; k++) {
                    list[i][j].add(0);
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(map[i][j]==0)
                {

                }
            }
        }
    }
}
