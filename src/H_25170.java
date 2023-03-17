import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_25170 {
    static int n;
    static int m;
    static int t;
    static int [][] map;
    static boolean [][] visited;
    public static class ari
    {
        int T;
        int N;
        int M;
        int value;
        public ari(int T, int N, int M, int value)
        {
            this.N =N;
            this.M = M;
            this.T = T;
            this.value = value;
        }
    }
    static Queue<ari> queue = new LinkedList<>();
    public static void bfs()
    {
        while(queue.isEmpty())
        {

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int index=1;
            while(st.hasMoreTokens())
            {
                map[index][i]=Integer.parseInt(st.nextToken());
            }
        }
    }
}
