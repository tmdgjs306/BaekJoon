import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_1306 {
    static long [] arr;
    public static class segmentTree{
        long [] tree;
        int height;
        public segmentTree(int arrSize){
            height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.tree = new long[(int) Math.pow(2,height+1)];
        }
        public long init(int start, int end, int node){
            if(start==end){
                return tree[node] = arr[start];
            }
            else
                return tree[node] = Math.max(init(start,(start+end)/2,node*2),
                        init((start+end)/2+1,end,node*2+1));
        }
        public long getMax(int start, int end, int node, int left, int right){
            if(start>right || end<left) return 0;
            if(start>=left && end<=right){
                return tree[node];
            }
            else{
                return Math.max(getMax(start,(start+end)/2,node*2,left,right),
                        getMax((start+end)/2+1,end,node*2+1,left,right));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segmentTree s = new segmentTree(n);
        s.init(1,n,1);
        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=(n-m+1); i++){
            int left = i-(m-1);
            int right =i+(m-1);
            sb.append(s.getMax(1,n,1,left,right)).append(" ");
        }
        System.out.print(sb);
    }
}
