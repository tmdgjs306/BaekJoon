import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_2042 {
    static long [] arr;
    public static class segmentTree{
        long [] tree;
        int size;
        public segmentTree(int arrSize){
            size = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            if(size ==0) size = 2;
            tree = new long[(int) Math.pow(2,size+1)];
        }
        public long init(int start, int end,int Node){
            //if(Node>=this.tree.length) return 0;
            if(start==end){
                this.tree[Node] =arr[start];
                return arr[start];
            }
            return this.tree[Node]=init(start,(start+end)/2,Node*2)+init((start+end)/2+1,end,Node*2+1);
        }
        public void update(int start, int end, int idx, int Node, long diff){
            if(Node>=this.tree.length) return;
              if(idx<start || idx>end) return;
              this.tree[Node]+=diff;
              if(start!=end){
                  update(start,(start+end)/2,idx,Node*2,diff);
                  update((start+end)/2+1,end,idx,Node*2+1,diff);
              }
        }
        public long getSum(int start, int end, int Node, int left, int right){
            if(Node>=this.tree.length) return 0;
            if(left>end || start>right) {
                return 0;
            }
            if(start>=left && end<=right){
                return this.tree[Node];
            }
            return getSum(start,(start+end)/2,Node*2,left,right) +
                        getSum((start+end)/2+1,end,Node*2+1,left,right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        segmentTree s = new segmentTree(n);
        s.init(1,n,1);
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1){
                int changeIdx = Integer.parseInt(st.nextToken());
                long changeValue = Long.parseLong(st.nextToken());
                long temp =changeValue-arr[changeIdx];
                arr[changeIdx] = changeValue;
                s.update(1,n,changeIdx,1,temp);
            }
            else{
                int left =Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long sum = s.getSum(1,n,1,left,right);
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb);
    }
}
