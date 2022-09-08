import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class H_15685 {
    static int [][] map = new int[101][101];
    static int count=0;
    static int [] dx = {0,-1,0,1};
    static int [] dy= {1,0,-1,0};
    public static class dragon
    {
        int x;
        int y;
        int d;
        LinkedList <Integer> Path =  new LinkedList<Integer>();
        public dragon(int x, int y, int d) // 끝점 저장
        {
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    public static int edit_dist(int d)
    {
        return (d+1)%4;
    }
    public static void go(dragon dr)
    {
        int size = dr.Path.size();
        for(int i=size-1; i>=0; i--)
        {
            int d = dr.Path.get(i);
            d=edit_dist(d);
            int newx = dr.x + dx[d];
            int newy = dr.y + dy[d];
            dr.x = newx;
            dr.y = newy;
            if (map[newx][newy] == 0) {
                map[newx][newy] = 1;
            }
            dr.Path.add(d);
        }
    }
    public static void calc_map()
    {
        for(int i=0; i<100; i++)
        {
            for(int j=0; j<100; j++)
            {
                if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1] ==1 && map[i+1][j+1]==1)
                {
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            map[x][y]=1;
            map[x+dx[d]][y+dy[d]]=1;
            dragon temp = new dragon(x+dx[d],y+dy[d],d);
            temp.Path.add(d);
            for(int j=0; j<gen; j++)
            {
                go(temp);
            }
        }
        calc_map();
        System.out.println(count);
    }
}
