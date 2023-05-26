import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class H_1414 {

    // 유니온 파인드 구현
    static int [] Parent;
    public static int find(int a){
        if(Parent[a] ==a)
            return a;
        else
            return Parent[a]=find(Parent[a]);
    }
    public static void union(int a, int b){
        int Pa = find(a);
        int Pb = find(b);
        Parent[Pa] = Pb;
    }

    //간선 정보
    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int value;
        public Node(int from, int to, int value){
            this.from = from;
            this.to =to;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        Parent = new int[n];
        for(int i=0; i<n; i++){
            Parent[i] = i;
        }
        int [][] map = new int[n][n];
        PriorityQueue <Node>queue = new PriorityQueue<Node>();

        //문자열 파싱
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j=0; j<temp.length(); j++){
                char tp =temp.charAt(j);
                if((int)tp-97>=0){
                    map[i][j] = (int)tp-96;
                    queue.add(new Node(i,j,map[i][j]));
                }
                else if((int)tp-65>=0){
                    map[i][j] = ((int)tp-65)+27;
                    queue.add(new Node(i,j,map[i][j]));
                }
                else {
                    map[i][j] = (int) tp - 48;
                    queue.add(new Node(i, j, map[i][j]));
                }
            }
        }

        boolean [][] isUsed = new boolean[n][n];
        while (!queue.isEmpty()){
            Node node =   queue.poll();
            if(node.value==0) continue;
            if(find(node.from) == find(node.to))continue;
            else{
                union(node.from,node.to);
                isUsed[node.from][node.to] = true;
            }
        }
        int check = find(0);
        int total =0;
        for(int i=0; i<n; i++){
            if(find(i)!=check) {
                System.out.println(-1);
                return;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isUsed[i][j]) continue;
                else
                    total+=map[i][j];
            }
        }
        System.out.print(total);
    }
}
