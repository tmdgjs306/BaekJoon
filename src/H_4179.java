
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_4179 {
    public static class Point
    {
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x=x;
            this.y=y;
        }
    }


    static int r,c;
    static int [][] map;
    static int [][] get_map;
    static Queue <Point> people;
    static Queue <Point> fire;
    static int [] dx ={1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static boolean [][] visited;
    public static void bfs() {
        while (true) {
            if(people.isEmpty() && fire.isEmpty())
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
            Queue<Point> temp = new LinkedList<>();
            while (!people.isEmpty()) {
                Point now_people = people.poll();
                int p_x = now_people.x;
                int p_y = now_people.y;
                if ((p_x == 0 || p_y == 0 || p_x == r - 1 || p_y == c - 1) && map[p_x][p_y]!=3 )
                {
                    System.out.println(get_map[p_x][p_y]);
                    return;
                }
                if (map[p_x][p_y] == 3) continue;
                for (int i = 0; i < 4; i++) {
                    int new_p_x = p_x + dx[i];
                    int new_p_y = p_y + dy[i];
                    if (new_p_x >= r || new_p_x < 0 || new_p_y >= c || new_p_y < 0) continue;
                    if (map[new_p_x][new_p_y] == 1 || map[new_p_x][new_p_y] == 3) continue;
                    if(visited[new_p_x][new_p_y]) continue;
                    temp.add(new Point(new_p_x, new_p_y));
                    get_map[new_p_x][new_p_y] = Math.min(get_map[new_p_x][new_p_y], get_map[p_x][p_y] + 1);
                    visited[new_p_x][new_p_y] = true;
                }
            }
            while (!temp.isEmpty()) {
                people.add(temp.poll());
            }
            Queue<Point> temp2 = new LinkedList<>();
            while (!fire.isEmpty()) {
                Point now_fire = fire.poll();
                int f_x = now_fire.x;
                int f_y = now_fire.y;
                for (int i = 0; i < 4; i++) {
                    int new_f_x = f_x + dx[i];
                    int new_f_y = f_y + dy[i];
                    if (new_f_x >= r || new_f_x < 0 || new_f_y >= c || new_f_y < 0) continue;
                    if (map[new_f_x][new_f_y] != 0) continue;
                    temp2.add(new Point(new_f_x, new_f_y));
                    map[new_f_x][new_f_y] = 3;
                }
            }
            while (!temp2.isEmpty())
            {
                fire.add(temp2.poll());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            map = new int[r][c];
            get_map = new int[r][c];
            visited = new boolean[r][c];
            people = new LinkedList<Point>();
            fire = new LinkedList<Point>();
            for (int i = 0; i < r; i++) {
                Arrays.fill(get_map[i], 999999999);
            }
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < c; j++) {
                    if (s.charAt(j) == '#') map[i][j] = 1;
                    else if (s.charAt(j) == '@') {
                        map[i][j] = 2;
                        people.add(new Point(i, j));
                        get_map[i][j] = 1;
                        visited[i][j] = true;
                    } else if (s.charAt(j) == '*') {
                        map[i][j] = 3;
                        fire.add(new Point(i, j));
                    } else map[i][j] = 0;
                }
            }
            bfs();
        }
    }
}
