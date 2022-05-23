import java.util.HashMap;
import java.util.Scanner;

public class H_1620 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int M=sc.nextInt();
        HashMap<Integer,String> book = new HashMap<>();
        HashMap<String,Integer> book2 = new HashMap<>();
        for(int i=1; i<=N; i++)
        {
            String temp=sc.next();
            book.put((Integer)i,temp);
            book2.put(temp,(Integer)i);
        }
        for(int i=0; i<M; i++)
        {
            String t= sc.next();
            if(book2.get(t)!=null)
            {
                System.out.println(book2.get(t));
            }
            else
            {
                System.out.println(book.get(Integer.parseInt(t)));
            }
        }
    }
}
