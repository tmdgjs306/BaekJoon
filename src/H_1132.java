import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class H_1132 {
    public static class Node implements Comparable<Node>
    {
        int index;
        long value;
        public Node(int index, long value)
        {
            this.index=index;
            this.value=value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) return 0;
            else if (this.value > o.value) return 1;
            else return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] zero = new boolean[10];
        String [] strings = new String[n];
        long [] count = new long[10];
        long result = 0;
        boolean [] is_used = new boolean[10];
        ArrayList <Node> list = new ArrayList<Node>();

        for(int i=0; i<n; i++) //입력 부분
        {
            String s = sc.next();
            strings[i]=s;
            char first = s.charAt(0);
            int a =(int)first-65;
            zero[a]=true; //맨 앞자리 수 는 0이 될수 없음
        }

        for(int i=0; i<n; i++) // 자릿수 가중치 계산
        {
            String s= strings[i];
            double temp = s.length();
            for(int j=0; j<s.length(); j++)
            {
                char first=s.charAt(j);
                long value =(long)Math.pow(10,temp-1);
                count[(int)first-65]+=value;
                temp--;
            }
        }

        for(int i=0; i<=9; i++) // 계산한 가중치를 Arraylist에 옮김
        {
            Node temp = new Node(i,count[i]);
            list.add(temp);
        }

        Collections.sort(list); // 가중치에 오름 차순으로 정렬

        for(int i=0; i<=9; i++)
        {
            int index = list.get(i).index;
            long value = list.get(i).value;
            for(int j=0; j<=9; j++)
            {
                if(is_used[j]) continue; //사용된 숫자면 스킵
                if(j==0 && zero[index]) continue; // 맨 앞자리 수는 0이 될수 없음
                is_used[j]=true; //사용 표시
                long now_value=value*j; // 값 계산
                result+=now_value;
                break;
            }
        }
        System.out.println(result);
    }
}
