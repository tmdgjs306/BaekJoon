import java.util.*;

public class H_24446 {
    static ArrayList<Integer> [] list;
    static boolean [] visited;
    public static Queue <Integer> queue;
    public static int [] result;

    public static void bfs(){
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<list[now].size(); i++){
                int next = list[now].get(i);
                if(visited[next]) continue;
                else{
                    visited[next] = true;
                    queue.add(next);
                    result[next] = result[now]+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        queue = new LinkedList<>();
        queue.add(r);
        result = new int[n+1];
        result[r] = 0;
        visited[r] = true;
        bfs();
        for(int i=1; i<=n; i++){
            if(i!=r && result[i]==0)
                System.out.println(-1);
            else
                System.out.println(result[i]);
        }
    }
}
