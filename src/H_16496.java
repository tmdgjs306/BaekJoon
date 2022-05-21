
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class H_16496{
    public static class num implements Comparable<num>
    {
        int arr;
        long priorty;
        public num(long priorty,int arr)
        {
            this.arr=arr;
            this.priorty=priorty;
        }
        public int compareTo(num n) {

            if(this.priorty<n.priorty)
                return 1;
            else if(this.priorty>n.priorty)
                return -1;
            else
                return 0;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc =new Scanner(System.in);
        int K=sc.nextInt();
        int N=K;
        int []Number=new int[K];
        int []arr=new int[N];
        for(int i=0; i<K; i++)
        {
            Number[i]=sc.nextInt();
        }
        Arrays.sort(Number);
        int max=N-K;
        for(int i=0; i<max; i++)
        {
            arr[i]=Number[K-1];
        }
        int index=0;
        for(int i=max; i<N; i++)
        {
            arr[i]=Number[index];
            index++;
        }
        int fn[][]=new int[N][10];
        for(int i=0; i<N; i++)
        {
            Arrays.fill(fn[i],0);
        }
        int maxlen=0;
        for(int i=0; i<N; i++)
        {
            String temp=Integer.toString(arr[i]);
            int length=temp.length();
            if(maxlen<length)
                maxlen=length;
            int temp1=arr[i];
            int try1=length;
            for(int j=0; j<length; j++)
            {
                fn[i][j]=(int)(temp1/(Math.pow(10, try1-1)));
                try1--;
                temp1-=fn[i][j]*Math.pow(10,try1);
            }
            int index1=0;
            for(int t=length; t<10; t++)
            {
                fn[i][t]=fn[i][index1];
                index1++;
            }
        }
        long priority[]=new long[N];
        List<num> pri=new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            long sum=0;
            for(int j=0; j<10; j++)
            {
                sum+=fn[i][j]*Math.pow(10,10-j);
            }
            num tp=new num(sum,arr[i]);
            pri.add(tp);
        }
        Collections.sort(pri);
        String result="";
        num tp =pri.get(0);
        if(tp.arr==0)
        {
            System.out.println(0);
            return;
        }
        for(int i=0; i<N; i++)
        {
            num temp=pri.get(i);
            result+=temp.arr;
        }
        System.out.println(result);
    }

}
