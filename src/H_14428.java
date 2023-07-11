import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_14428 {
    public static class segmentTree{
        int [] tree;
        int height;
        public segmentTree(int arrSize){
            height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.tree = new int[(int) Math.pow(2,height+1)];
        }
        public void init(int start, int end, int node){
            if(start==end){
                tree[node] = start;
            }
            else{
                int mid = (start+end)/2;
                init(start,mid,node*2);
                init(mid+1,end,node*2+1);
                if(arr[tree[node*2]]>arr[tree[node*2+1]]){
                    tree[node] = tree[node*2+1];
                }
                else{
                    tree[node] = tree[node*2];
                }
            }
        }
        public void update(int start, int end, int node, int idx){
            if(idx<start || idx>end) return;
            if(start==end){
                tree[node]=idx;
            }
            else{
                int mid = (start+end)/2;
                update(start,mid,node*2,idx);
                update(mid+1,end,node*2+1,idx);
                if(arr[tree[node*2]]>arr[tree[node*2+1]]){
                    tree[node] = tree[node*2+1];
                }
                else{
                    tree[node] = tree[node*2];
                }
            }
        }
        public int getResult(int start, int end, int node, int left, int right){
            if(start>right || end<left) {
                return -1;
            }
            if(start>=left && end<=right){
                return tree[node];
            }
            else{
                int mid = (start+end)/2;
                int leftVal = getResult(start,mid,node*2,left,right);
                int rightVal = getResult(mid+1,end,node*2+1,left,right);
                if(leftVal==-1) return rightVal;
                else if(rightVal==-1) return leftVal;
                else{
                    if(arr[leftVal]>arr[rightVal]) return rightVal;
                    else return leftVal;
                }
            }
        }
    }
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segmentTree s = new segmentTree(n);
        s.init(1,n,1);
        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a ==1){
                arr[b] =c;
                s.update(1,n,1,b);
            }
            if(a==2){
                sb.append(s.getResult(1,n,1,b,c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
