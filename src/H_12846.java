import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_12846 {
    static int [] arr;
    static int n;
    static long max = 0;
    public static class segmentTree{
        long [] tree;
        int height;
        public segmentTree(int arrSize){
            height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.tree = new long[(int)Math.pow(2,height+1)];
        }
        public void init(int start, int end, int node){
            if(start == end){
                tree[node] = start;
            }
            else{
                init(start,(start+end)/2,node*2);
                init((start+end)/2+1,end,node*2+1);
                if(arr[(int) tree[node*2]]>arr[(int) tree[node*2+1]]){
                    tree[node] = tree[node*2+1];
                }
                else{
                    tree[node] = tree[node*2];
                }
            }
        }
        public long getMin(int start,int end,int node, int left, int right){
            if(start>right || end<left) return -1;
            if(start>=left && end<=right) return tree[node];
            else{
                long leftVal = getMin(start,(start+end)/2,node*2,left,right);
                long rightVal =getMin((start+end)/2+1,end,node*2+1,left,right);
                if(leftVal==-1)return rightVal;
                else if(rightVal==-1) return leftVal;
                else{
                    if(arr[(int) leftVal]>arr[(int) rightVal]) return rightVal;
                    else return leftVal;
                }
            }
        }
    }
    public static void getMax(int start,int end, segmentTree s){
        int min = (int) s.getMin(1,n,1,start,end);
        max = Math.max(max,arr[(int) min]*(end-start+1));
        if(min-1>=start){
            getMax(start,min-1,s);
        }
        if(min+1<=end){
            getMax(min+1,end,s);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segmentTree s = new segmentTree(n);
        s.init(1,n,1);
        getMax(1,n,s);
        System.out.print(max);
    }
}
