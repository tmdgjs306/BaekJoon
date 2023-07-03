import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_16940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList <Integer> [] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        Queue <Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[n+1];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);

        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        int tp = queue.poll(); // BFS 순회 순서
        if(tp!=1){
            System.out.println(0);
            return;
        }
        HashMap<Integer,Integer> map = new HashMap<>(); // BFS 순회 순서에 따라 방문 처리할 수 있는 노드
        Queue <Integer> temp = new LinkedList<>(); // 임시 큐
        visited[tp] = true; //
        for(int i=0; i<list[tp].size(); i++) {
            map.put(list[tp].get(i),1);
            visited[list[tp].get(i)] = true;
        }

        while (!queue.isEmpty()) { // BFS 순회가 종료 될 떄 까지 반복
             boolean flag = false;
             int now = queue.poll(); // 현재 방문한 노드
             if(map.containsKey(now)){ //방문이 가능한 노드일 경우
                map.remove(now);
                temp.add(now);
                continue;
             }
             if(!map.isEmpty()){ //만약 선행 방문 해야할 노드가 있을 경우 올바르지 않은 입력으로 처리한다.
                 System.out.print(0);
                 return;
             }
             if(!temp.isEmpty()){
                 while (map.isEmpty()){
                     if(temp.isEmpty()){
                         System.out.println(0);
                         return;
                     }
                     int next = temp.poll();
                     for(int i=0; i<list[next].size(); i++) {
                         if(visited[list[next].get(i)]) continue;
                         map.put(list[next].get(i),1);
                         visited[list[next].get(i)] = true;
                     }
                     if(map.containsKey(now)){
                         map.remove(now);
                         temp.add(now);
                         flag = true;
                         break;
                     }
                 }
             }
             if(!flag){
                 System.out.print(0);
                 return;
             }
        }
        System.out.print(1);
    }
}
