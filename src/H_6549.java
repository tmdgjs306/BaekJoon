import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H_6549 {
    public static void getMax(int start, int end,segmentTree s) {
        int min = s.getMin(1, n, 1, start, end);
        max = Math.max(arr[min] * (end - start + 1), max);
        if (min - 1 >= start) {
            getMax(start, min - 1, s);
        }
        if (min + 1 <= end) {
            getMax(min + 1, end, s);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            segmentTree s = new segmentTree(n);
            s.init(1, n, 1);
            getMax(1, n,s);
            sb.append(max).append("\n");
            max = 0;
        System.out.println(sb);
    }
    static long arr[];
    static int n;
    static long max;

    public static class segmentTree {
        long [] tree;
        int height;

        public segmentTree(int argSize) {
            height = (int) Math.ceil(Math.log(argSize) / Math.log(2));
            this.tree = new long[(int) Math.pow(2, height+1)];
        }

        public void init(int start, int end, int node) {
            if (start == end) {
                tree[node] = start;
            } else {
                init(start, (start + end) / 2, node * 2);
                init((start + end) / 2 + 1, end, node * 2 + 1);
                if (arr[(int) tree[node * 2]] > arr[(int) tree[node * 2 + 1]])
                    tree[node] = tree[node * 2 + 1];
                else
                    tree[node] = tree[node * 2];
            }
        }

        public int getMin(int start, int end, int node, int left, int right) {
            if(start > right || end < left){
                return -1;
            }
            if (start >= left && end <= right) {
                return (int) tree[node];
            } else{
                int leftMin = getMin(start, (start + end) / 2, node * 2, left, right);
                int rightMin = getMin((start + end) / 2 + 1, end, node * 2 + 1, left, right);
                if(leftMin==-1)return rightMin;
                else if(rightMin==-1) return leftMin;
                else{
                if (arr[leftMin] > arr[rightMin]) return rightMin;
                else return leftMin;
                }
            }
        }
    }
}

