import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_17251 {
    static int [] arr;
    public static class segmentTree{
        int tree [];
        int height;
        public segmentTree(int arrSize){
            height = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.tree = new int[(int) Math.pow(2,height+1)];
        }
        public int init(int start, int end, int node){
            if(start == end ){
                return tree[node] = arr[start];
            }
            else{
                int mid = (start+end)/2;
                return tree[node] = Math.max(init(start,mid,node*2),init(mid+1,end,node*2+1));
            }
        }
        public int find(int start, int end, int node, int left, int right){
            if(start>right || end<left) return 0;
            if(start>=left && end<=right){
                return tree[node];
            }
            else{
                int mid =(start+end)/2;
                return Math.max(find(start,mid,node*2,left,right),find(mid+1,end,node*2+1,left,right));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr= new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        segmentTree s = new segmentTree(n);
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s.init(1,n,1);
        int r = 0;
        int b = 0;
        int min = 1;
        int max = n;
        for(int i=2; i<=n; i++){
            int rEnd = i-1;
            int lSart =i;
            int rMax = s.find(1,n,1,min,rEnd);
            int bMax = s.find(1,n,1,lSart,max);
            if(rMax>bMax){
                r++;
            }
            else if(rMax==bMax){
                continue;
            }
            else {
                b++;
            }
        }
        if(r>b){
            System.out.print("R");
        } else if (r==b) {
            System.out.print("X");
        }
        else{
            System.out.print("B");
        }
    }
}
