import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_2206 {
    static int n;
    static int k;
    static int m;
    static int [][] map;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static boolean [][][] visited;
    public static class Point
    {
        int x;
        int y;
        int dist;
        int crash;
        int day;
        public Point(int x, int y, int dist,int crash,int day)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.crash =crash;
            this.day = day;
        }
    }
    static Queue <Point> queue = new LinkedList<>();
    static int min = 99999999;
    public static void bfs()
    {
        while (!queue.isEmpty())
        {
            Point now =queue.poll();
            int n_x = now.x;
            int n_y = now.y;
            int n_d = now.dist;
            int n_c = now.crash;
            int nD = now.day%2;
            if(n_x==n-1 && n_y==m-1)
            {
                min = Math.min(n_d,min);
            }
            for(int i=0; i<4; i++)
            {
                int x = n_x+dx[i];
                int y = n_y+dy[i];
                if(x>=n || x<0 || y>=m || y<0) continue;
                if(map[x][y]==1)
                {
                    if (n_c==0) continue;
                    if(nD==1 && n_c!=0)
                    {
                        int n_dist = n_d+1;
                        int n_crash =n_c;
                        queue.add(new Point(n_x,n_y,n_dist,n_crash,nD+1));
                        continue;
                    }
                    if (visited[x][y][n_c-1]) continue;
                    int n_dist = n_d+1;
                    int n_crash = n_c-1;
                    visited[x][y][n_crash] = true;
                    queue.add(new Point(x,y,n_dist,n_crash,nD+1));
                }
                else
                {
                    if (visited[x][y][n_c]) continue;
                    int n_dist = n_d+1;
                    int n_crash = n_c;
                    visited[x][y][n_crash]=true;
                    queue.add(new Point(x,y,n_dist,n_crash,nD+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        for(int i=0; i<n; i++)
        {
            String s = br.readLine();
            for(int j=0; j<m; j++)
            {
                char a = s.charAt(j);
                String temp =String.valueOf(a);
                map[i][j]=Integer.parseInt(temp);
            }
        }
        queue.add(new Point(0,0,0,k,0));
        visited[0][0][k]= true;
        bfs();
        if(min==99999999)
        {
            System.out.println(-1);
        }
        else {
            System.out.println(min + 1);
        }
    }
}
