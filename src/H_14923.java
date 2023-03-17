import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_14923 {
    public static class point
    {
        int x;
        int y;
        int crush;
        int value;
        public point(int x, int y,int crush,int value)
        {
            this.x=x;
            this.y=y;
            this.crush = crush;
            this.value = value;
        }
    }
    static int N;
    static int M;
    static int nx;
    static int ny;
    static int ex;
    static int ey;
    static int [][]map;
    static boolean [][][]visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Queue <point> list;
    static int min = Integer.MAX_VALUE;
    public static void bfs()
    {
        while (!list.isEmpty())
        {
            point nowPoint = list.poll();
            int nowx = nowPoint.x;
            int nowy = nowPoint.y;
            if(nowx==ex && nowy==ey)
            {
                min = Math.min(min,nowPoint.value);
                continue;
            }
            for(int i=0;  i<4; i++)
            {
                int newx = nowx+dx[i];
                int newy = nowy+dy[i];
                if(newx<=0 || newx >N || newy<=0 || newy>M) continue;
                if(map[newx][newy]==1)
                {
                    if(nowPoint.crush==0) continue;
                    else
                    {
                        if(visited[newx][newy][1]==true) continue;
                        else
                        {
                            visited[newx][newy][1]= true;
                            list.add(new point(newx,newy,0,nowPoint.value+1));
                        }
                    }
                }
                else
                {
                    if (nowPoint.crush==1)
                    {
                        if (visited[newx][newy][0]) continue;
                        else
                        {
                            visited[newx][newy][0] = true;
                            list.add(new point(newx,newy,1,nowPoint.value+1));
                        }
                    }
                    else
                    {
                        if(visited[newx][newy][1])continue;
                        else
                        {
                            visited[newx][newy][1] = true;
                            list.add(new point(newx,newy,0,nowPoint.value+1));
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nx = sc.nextInt();
        ny = sc.nextInt();
        ex = sc.nextInt();
        ey = sc.nextInt();
        map =  new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        list = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        list.add(new point(nx,ny,1,0));
        bfs();
        if(min!=Integer.MAX_VALUE)
        {
            System.out.print(min);
        }
        else
        {
            System.out.print(-1);
        }
    }
}
