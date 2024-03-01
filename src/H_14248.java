import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_14248 {
    static int n;
    static int s;
    static int [] arr;
    static ArrayList<Integer> [] list;
    static Queue<Integer> queue = new LinkedList<>();
    static int count =0;
    static boolean [] visited;
    public static void bfs(){
        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<list[now].size(); i++){
                if(visited[list[now].get(i)]) continue;
                queue.add(list[now].get(i));
                visited[list[now].get(i)] = true;
                count++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int jumpSize = Integer.parseInt(st.nextToken());
            if(i+jumpSize>=1 && i+jumpSize<=n){
                list[i].add(i+jumpSize);
            }
            if(i-jumpSize>=1 && i-jumpSize<=n){
                list[i].add(i-jumpSize);
            }
        }
        s = Integer.parseInt(br.readLine());
        visited[s] = true;
        queue.add(s);
        bfs();
        System.out.print(count+1);
    }
}
