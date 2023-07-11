import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_12837 {
    static long [] arr;
    public static class segmentTree{
        long [] tree;
        int height;
        public segmentTree(int arrSize){
            this.height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            tree = new long[(int) Math.pow(2,height+1)];
        }
        public long init(int start, int end, int node){
            if(start==end){
                return tree[node] = arr[start];
            }
            else{
                int mid = (start+end)/2;
                return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
            }
        }
        public long find(int start, int end, int node,int left, int right){
            if(start>right || end<left) return 0;
            if(start>=left && end<=right){
                return tree[node];
            }
            else{
                int mid = (start+end)/2;
                return find(start,mid,node*2,left,right)+find(mid+1,end,node*2+1,left,right);
            }
        }
        public void update(int start,int end, int node,int diff,int idx){
            if(start>idx || end<idx)return;
            tree[node]+=diff;
            int mid = (start+end)/2;
            if(start!=end){
                update(start,mid,node*2,diff,idx);
                update(mid+1,end,node*2+1,diff,idx);
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
        s.init(1,n,1);
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                int diff = (int) (c - arr[b]);
                s.update(1,n,1,diff,b);
            }
            if(a==2){
                sb.append(s.find(1,n,1,b,c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
