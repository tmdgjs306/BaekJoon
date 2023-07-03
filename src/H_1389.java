import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_1389 {
    public static boolean [] visited;
    public static ArrayList <Integer> [] map;
    public static Queue <Integer> queue = new LinkedList<>();
    public static int values [];
    public static void DFS(int val,int parent){
        Queue<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<map[now].size(); i++){
                int next = map[now].get(i);
                if(visited[next])continue;
                else{
                    values[parent]+=val;
                    temp.add(next);
                    visited[next] = true;
                }
            }
        }
        if(temp.size()!=0) {
            while (!temp.isEmpty()) {
                queue.add(temp.poll());
            }
            DFS(++val,parent);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        values = new int[n+1];
        map  = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[from].add(to);
            map[to].add(from);
        }
        for(int i=1; i<=n; i++) {
            queue.add(i);
            visited[i] = true;
            DFS(1,i);
            visited = new boolean[n + 1];
        }
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i=1; i<=n; i++){
            if(min>values[i]) {
                min = values[i];
                minIdx=i;
            }
        }
        System.out.print(minIdx);
    }
}
