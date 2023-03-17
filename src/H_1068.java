import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H_1068 {
    static ArrayList<Integer> [] tree;
    static boolean [] isDel;
    public static void delete(int del){
        Queue <Integer> queue = new LinkedList<>();
        queue.add(del);

        while(!queue.isEmpty()){
            int now = queue.poll();
            isDel[now] = true;
            for(int i=0; i<tree[now].size(); i++){
                queue.add(tree[now].get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        isDel = new boolean[n];
        for(int i=0; i<n; i++){
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for(int i=0; i<n; i++){
            int parent = sc.nextInt();
            if(parent==-1)
                root = i;
            else{
                tree[parent].add(i);
            }
        }
        int del = sc.nextInt();
        delete(del);
        int result = 0;
        for(int i=0; i<n; i++){
            if(isDel[i]) continue;
            if(tree[i].size()==0) result++;
            else{
                boolean isLeaf = true;
                for(int j=0; j<tree[i].size(); j++){
                    if(!isDel[tree[i].get(j)]) {
                        isLeaf=false;
                        break;
                    }
                }
                if(isLeaf)
                    result++;
            }
        }
        System.out.print(result);
    }
}
