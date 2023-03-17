import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class H_4195 {
    static int [] parent;
    static int [] values;
    public static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b){
        int Pa = find(a);
        int Pb = find(b);
        if(Pa!=Pb)
            parent[Pb] = Pa;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T; t++) {
            int n = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;
            parent = new int[n * 2];
            values = new int[n * 2];
            for (int i = 0; i < n * 2; i++) {
                parent[i] = i;
                values[i] = 1;
            }
            for (int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();
                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }
                int valueA = map.get(a);
                int valueB = map.get(b);
                if (find(valueA) == find(valueB)) {
                    sb.append(values[find(valueA)]).append("\n");
                } else {;
                    int Va = values[find(valueA)];
                    int Vb = values[find(valueB)];
                    values[find(valueA)] = Va + Vb;
                    values[find(valueB)] = Va + Vb;
                    union(valueA,valueB);
                    sb.append(Va + Vb).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
