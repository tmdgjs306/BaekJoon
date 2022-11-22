import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_17836 {
    static int n;
    static int m;
    static int t;
    static int [][] map;
    static int [][] map2;
    static Queue <Point> list_1 = new LinkedList<>();
    static Queue <Point> list_2 = new LinkedList<>();
    static int [] dx ={1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static boolean[][] visited;
    static boolean[][] visited2;
    public static class Point
    {
        int x;
        int y;
        public Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void bfs()
    {
        while (!list_1.isEmpty())
        {
            Point now = list_1.poll();
            int nowx = now.x;
            int nowy = now.y;
            for (int i = 0; i < 4; i++) {
                int newx = nowx + dx[i];
                int newy = nowy + dy[i];
                if (newx > n || newx <= 0 || newy > m || newy <= 0) continue;
                if (map[newx][newy] == 1) continue;
                if (visited[newx][newy]) continue;
                map[newx][newy] = Math.min(map[newx][newy], map[nowx][nowy] + 1);
                list_1.add(new Point(newx, newy));
                visited[newx][newy] = true;
            }
        }
    }
    public static void bfs2()
    {
        while (!list_2.isEmpty())
        {
            Point now = list_2.poll();
            int nowx = now.x;
            int nowy = now.y;
            for (int i = 0; i < 4; i++) {
                int newx = nowx + dx[i];
                int newy = nowy + dy[i];
                if (newx > n || newx <= 0 || newy > m || newy <= 0) continue;
                if (visited2[newx][newy]) continue;
                map2[newx][newy] = Math.min(map2[newx][newy], map2[nowx][nowy] + 1);
                list_2.add(new Point(newx, newy));
                visited2[newx][newy] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        map2 = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        visited2 = new boolean[n+1][m+1];
        int gram_x =0;
        int gram_y =0;
        for(int i=1; i<=n; i++)
        {
            Arrays.fill(map[i],9999999);
        }
        for(int i=1; i<=n; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++) {
                int temp = Integer.parseInt(st2.nextToken());
                if (temp == 0) continue;
                map[i][j] = temp;
                map2[i][j] = temp;
                if (temp == 2) {
                    list_2.add(new Point(i, j));
                    gram_x = i;
                    gram_y = j;
                    map[i][j] = 9999999;
                    map2[i][j] = 9999999;
                }
            }
        }
        for(int i=1; i<=n; i++)
        {
            Arrays.fill(map2[i],9999999);
        }
        list_1.add(new Point(1,1));
        visited[1][1] =true;
        map[1][1] = 0;
        bfs();
        if(map[gram_x][gram_y]==9999999)
        {
            if(map[n][m]==9999999) System.out.println("Fail");
            else
            {
                if(map[n][m]<=t ) System.out.println(map[n][m]);
                else System.out.println("Fail");
            }
            return;
        }
        else {
            map2[gram_x][gram_y] = map[gram_x][gram_y];
            list_2.add(new Point(gram_x,gram_y));
            visited2[gram_x][gram_y] = true;
            bfs2();
            int min = Math.min(map[n][m],map2[n][m]);
            if(min>t)
            {
                System.out.println("Fail");
                return;
            }
            else
            {
                System.out.println(min);
                return;
            }
        }
    }
}
