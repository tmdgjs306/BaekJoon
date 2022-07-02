import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class H_14502 {
    static int N;
    static int M;
    static boolean [][] visited;
    static int [][] map;
    static int [] dx={1,-1,0,0};
    static int [] dy={0,0,1,-1};
    static Queue <point> queue = new LinkedList();
    static class point
    {
        int x,y;
        public point(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void BFS()
    {
        while(!queue.isEmpty())
        {
            point temp =queue.poll();
            int nowx= temp.x;
            int nowy= temp.y;
            for(int i=0; i<4; i++)
            {
                int newx=nowx+dx[i];
                int newy=nowy+dy[i];
                if(newx<0 || newy<0 ||newx>=N || newy>=M) continue;
                else if(visited[newx][newy]) continue;
                else if(map[newx][newy]==0)
                {
                    map[newx][newy]=2;
                    point p = new point(newx,newy);
                    queue.add(p);
                    visited[newx][newy]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map= new int[N][M];
        int max = Integer.MIN_VALUE;
        boolean [][] select = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                map[i][j]=sc.nextInt();
            }
        }

    }
}
