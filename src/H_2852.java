import java.util.Scanner;
import java.util.StringTokenizer;

public class H_2852 {
    public static class getPoint{
        int team;
        int point;
        public getPoint(int team, int point){
            this.point=point;
            this.team=team;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] teamPoints = new int[2];
        int aPoint = 0;
        int bPoint = 0;
        getPoint [] getPoints = new getPoint[2881];
        for(int i=0; i<n; i++){
            int nowWin = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(),":");
            int minute = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int result = (minute*60) + second;
            getPoints[result] = new getPoint(nowWin-1,1);
        }
        for(int i=0; i<2880; i++){
            if(getPoints[i]!=null){
                teamPoints[getPoints[i].team] +=getPoints[i].point;
            }
            if(teamPoints[0]==teamPoints[1]){
                continue;
            }
            else if(teamPoints[0]>teamPoints[1]){
                aPoint++;
            }
            else {
                bPoint++;
            }
        }
        int aMinute = aPoint/60;
        int bMinute = bPoint/60;
        String aMinutes = Integer.toString(aMinute);
        String bMinutes = Integer.toString(bMinute);
        if(aMinute>=0 && aMinute<=9){
            aMinutes = "0"+Integer.toString(aMinute);
        }
        if(bMinute>=0 && bMinute<=9){
            bMinutes = "0"+Integer.toString(bMinute);
        }
        int aSecond = aPoint%60;
        int bSecond = bPoint%60;
        String aSeconds = Integer.toString(aSecond);
        String bSeconds = Integer.toString(bSecond);
        if(aSecond>=0 && aSecond<=9){
            aSeconds = "0"+Integer.toString(aSecond);
        }
        if(bSecond>=0 &&bSecond<=9){
            bSeconds = "0"+Integer.toString(bSecond);
        }
        System.out.println(aMinutes+":"+aSeconds);
        System.out.print(bMinutes+":"+bSeconds);
    }
}
