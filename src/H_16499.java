import java.util.*;

public class H_16499 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        int n = sc.nextInt();
        for(int i=0; i<n; i++)
        {
            String temp = sc.next();
            char [] list = new char[temp.length()];
            list = temp.toCharArray();
            Arrays.sort(list);
            String result="";
            for(int j=0; j<temp.length(); j++)
            {
                result+=list[j];
            }
            if(set.contains(result))
            {
                continue;
            }
            else
            {
                set.add(result);
                count++;
            }
        }
        System.out.print(count);
    }
}
