import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_1275 {
    static long arr [];
    public static class segmentTree{
        long [] tree;
        int height;
        public segmentTree(int arrSize){
            height = (int)Math.ceil(Math.log(arrSize)/Math.log(2));
            this.tree = new long[(int)Math.pow(2,height+1)];
        }
        public long init(int start, int end, int node){
            if(start == end){
                return tree[node] = arr[start];
            }
            else{
                return tree[node]=init(start,(start+end)/2,node*2)+
                        init((start+end)/2+1,end,node*2+1);
            }
        }
        public void update(int start, int end, int node, int idx, long diff){
            if(start>idx || end<idx) return;
            tree[node] +=diff;
            if(start!=end){
                update(start,(start+end)/2,node*2,idx,diff);
                update((start+end)/2+1,end,node*2+1,idx,diff);
            }
        }
        public long getSum(int start, int end ,int node , int left, int right){
            if(start>right || end<left) return 0;
            if(start>=left && end<=right){
                return tree[node];
            }else {
                return getSum(start, (start + end) / 2, node * 2, left, right) +
                        getSum((start + end) / 2 + 1, end, node * 2 + 1, left, right);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        segmentTree s = new segmentTree(n);
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        s.init(1,n,1);
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                int temp = b;
                b = a;
                a = temp;
            }
            sb.append(s.getSum(1,n,1,a,b)).append("\n");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            long diff = d-arr[c];
            arr[c] =d;
            s.update(1,n,1,c,diff);
        }
        System.out.println(sb);
    }
}
