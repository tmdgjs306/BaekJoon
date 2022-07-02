import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class H_1043 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int N = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int M = sc.nextInt();
        int know = sc.nextInt();
        if (know == 0) {
            System.out.println(M);
            return;
        }
        boolean[] knows = new boolean[N + 1];
        for (int i = 0; i < know; i++) {
            knows[sc.nextInt()] = true;
        }
        ArrayList<Integer>[] party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }
        int value, pre = 0;
        for (int i = 0; i < M; i++) {
            int n = sc.nextInt();
            if (n > 0) {
                pre = sc.nextInt();
                party[i].add(pre);
            }
            for (int j = 1; j < n; j++) {
                value = sc.nextInt();
                party[i].add(value);
                union(pre, value);
                pre = value;
            }
        }
        int pr;
        for (int i = 1; i < know; i++) {
            if (knows[i]) {
                knows[find(i)] = true;
            }
        }
        for (int i = 0; i < M; i++) {
            if (party[i].size() > 0) {
                pr = find(party[i].get(0));
                if (!knows[pr]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        else return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            if (ra > rb) {
                parent[ra] = rb;
            } else {
                parent[rb] = ra;
            }
        }
    }
}
