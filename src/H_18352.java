import java.util.*;

public class H_18352 {
    public static class Node
    {
        int n;
        int v;
        public Node(int n, int v)
        {
            this.n = n;
            this.v=v;
        }
    }
    static boolean []visited;
    static ArrayList <Integer> [] list;
    static int K;
    static boolean is_find = false;
    static Queue <Node>queue = new LinkedList();
    static ArrayList<Integer> result = new ArrayList<>();
    public static void bfs()
    {
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int now = n.n;
            int dist = n.v;
            if (dist == K) {
                is_find = true;
                result.add(now);
                continue;
            } else {
                for (int i = 0; i < list[now].size(); i++) {
                    int next = list[now].get(i);
                    if (visited[next]) {
                        continue;
                    } else {
                        visited[next] = true;
                        queue.add(new Node(next, dist + 1));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        K = sc.nextInt();
        int X = sc.nextInt();
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++)
        {
            int from = sc.nextInt();
            int to = sc.nextInt();
            list[from].add(to);
        }
        visited[X]=true;
        queue.add(new Node(X,0));
        bfs();
        if(!is_find) {
            System.out.println(-1);
            return;
        }
        else
        {
            Collections.sort(result);
            for(int i=0; i<result.size(); i++)
            {
                System.out.println(result.get(i));
            }
            return;
        }
    }
}
