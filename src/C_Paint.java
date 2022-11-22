import java.util.Scanner;

public class C_Paint {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char [][] map = new char[8][8];
        int T = sc.nextInt();
        for(int t=0; t<T; t++)
        {
            for (int i = 0; i < 8; i++)
            {
                String s = sc.next();
                for (int j = 0; j < 8; j++)
                {
                    map[i][j] = s.charAt(j);
                }
            }
            boolean is_red = false;
            for(int i=0; i<8; i++)
            {
                boolean is_blue = false;
                for(int j=0; j<8; j++)
                {
                    if(map[i][j]=='B')
                    {
                        is_blue=true;
                        break;
                    }
                }
                if(!is_blue)
                {
                    is_red=true;
                    break;
                }
            }
            if(is_red)
            {
                sb.append("R").append("\n");
            }
            else
            {
                sb.append("B").append("\n");
            }
        }
        System.out.println(sb);
    }
}
