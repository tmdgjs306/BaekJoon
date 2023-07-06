import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_10868 {
    static long [] arr;
    public static class segmentTree{
        long [] tree;
        long height;
        public segmentTree(int arrSize){
            height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            tree = new long[(int)Math.pow(2,height+1)];
        }
        public long init(int start, int end, int Node){
            if(start==end){
                return this.tree[Node] = arr[start];
            }
            else{
                return this.tree[Node] = Math.min(init(start,(start+end)/2,Node*2),
                        init((start+end)/2+1,end,Node*2+1));
            }
        }
        public long find(int start, int end, int Node, int left, int right){
            if(start>right || end<left)return Long.MAX_VALUE;
            else if(start>=left && end<=right) return tree[Node];
            else return Math.min(find(start,(start+end)/2,Node*2,left,right),find((start+end)/2+1,end,Node*2+1,left,right));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        segmentTree s = new segmentTree(n);
        s.init(1,n,1);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            long min = s.find(1,n,1,a,b);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
