import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H_16235 {
    static int [] dx ={-1,-1,-1,0,1,1,1,0};
    static int [] dy ={-1,0,1,1,1,0,-1,-1};
    static int n;
    static int m;
    static int [][] map;
    static int [][] values;
    static PriorityQueue<Tree> trees = new PriorityQueue<Tree>();
    static Queue<Tree> deadTree = new LinkedList<>();
    public static class Tree implements Comparable<Tree>{
        int age;
        int r;
        int c;
        public Tree(int r,int c, int age){
            this.age = age;
            this.r = r;
            this.c =c;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age-o.age;
        }
    }
    public static void spring(){
        Queue<Tree> temp = new LinkedList<>();
        while(!trees.isEmpty()){
            Tree t = trees.poll();
            if(map[t.r][t.c]<t.age){
                deadTree.add(t);
            }
            else{
                map[t.r][t.c]-=t.age;
                temp.add(new Tree(t.r,t.c,t.age+1));
            }
        }
        while (!temp.isEmpty()){
            trees.add(temp.poll());
        }
    }
    public static void summer(){
        while (!deadTree.isEmpty()){
            Tree t = deadTree.poll();
            map[t.r][t.c]+=(t.age/2);
        }
    }
    public static void fall(){
        Queue<Tree> temp = new LinkedList<>();
        while(!trees.isEmpty()){
            Tree t = trees.poll();
            if(t.age%5!=0){
                temp.add(t);
                continue;
            }
            else{
                for(int i=0; i<8; i++){
                    int newX = t.r+dx[i];
                    int newY = t.c+dy[i];
                    if(newX<=0 || newX>n || newY<=0 || newY>n) continue;
                    temp.add(new Tree(newX,newY,1));
                }
                temp.add(t);
            }
        }
        while (!temp.isEmpty()){
            trees.add(temp.poll());
        }
    }
    public static void winter(){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j]+=values[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        values = new int[n+1][n+1];
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(map[i],5);
        }
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r,c,age));
        }
        for(int i=0; i<k; i++){
            spring();
            summer();
            fall();
            winter();
        }
        System.out.print(trees.size());
    }
}
