import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_2104 {
    static long arr[];
    static int n;
    static long max =0;
    public static void getMax(int start, int end, int node, mSegmentTree s1, sSegmentTree s2) {
       long minIdx = s1.getMin(1,n,1,start,end);
       long maxVal = s2.getSum(1,n,1,start,end);
       max = Math.max(max,arr[(int) minIdx]*maxVal);
       if(minIdx-1>=start){
           getMax(start,(int)minIdx-1,node,s1,s2);
       }
       if(minIdx+1 <=end){
           getMax((int) (minIdx+1),end,node,s1,s2);
       }
    }

    public static class mSegmentTree {
        long[] tree;
        int height;

        public mSegmentTree(int arrSize) {
            height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            tree = new long[(int) Math.pow(2, height + 1)];
        }

        public void init(int start, int end, int node) {
            if (start == end) {
                tree[node] = start;
            } else {
                int mid = (start + end) / 2;
                init(start, mid, node * 2);
                init(mid + 1, end, node * 2 + 1);
                if (arr[(int) tree[node * 2]] > arr[(int) tree[node * 2 + 1]]) {
                    tree[node] = tree[node * 2 + 1];
                } else {
                    tree[node] = tree[node * 2];
                }
            }
        }

        public long getMin(int start, int end, int node, int left, int right) {
            if (start > right || end < left) return -1;
            if (start >= left && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                long leftVal = getMin(start, mid, node * 2, left, right);
                long rightVal = getMin(mid+1, end, node * 2 + 1, left, right);
                if(leftVal==-1)
                    return rightVal;
                else if(rightVal ==-1)
                    return leftVal;
                else {
                    if (arr[(int) leftVal] > arr[(int) rightVal])
                        return rightVal;
                    else return leftVal;
                }
            }
        }
    }

    public static class sSegmentTree {
        long[] tree;
        int height;

        public sSegmentTree(int arrSize) {
            height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            tree = new long[(int) Math.pow(2, height + 1)];
        }

        public long init(int start, int end, int node) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                return tree[node] = init(start, mid, node * 2) +
                        init(mid + 1, end, node * 2 + 1);
            }
        }

        public long getSum(int start, int end, int node, int left, int right) {
            if (start > right || end < left) return 0;
            if (start >= left && end <= right) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                return getSum(start, mid, node * 2, left, right) +
                        getSum(mid+1, end, node * 2 + 1, left, right);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        mSegmentTree s1 = new mSegmentTree(n);
        sSegmentTree s2 = new sSegmentTree(n);
        s1.init(1,n,1);
        s2.init(1,n,1);
        getMax(1,n,1,s1,s2);
        System.out.print(max);
    }
}

