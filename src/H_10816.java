import java.util.Arrays;
import java.util.Scanner;

public class H_10816 {
    static int n;
    static int m;
    static int [] arr;
    public static int findFirst(int f){
        int start = 0;
        int end = n;
        int mid = -1;
        while (start<end){
            mid = (start+end)/2;
            if(f>arr[mid]){
                start = mid+1;
            }
            else if(f<=arr[mid]){
                end = mid;
            }
        }
        return start;
    }
    public static int findLast(int f){
        int start = 0;
        int end = n;
        int mid = -1;
        while (start<end){
            mid = (start+end)/2;
            if(f>=arr[mid]){
                start = mid+1;
            }
            else if(f<arr[mid]){
                end = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int temp = sc.nextInt();
            result.append(findLast(temp)-findFirst(temp)).append(" ");
        }

        System.out.print(result);
    }
}
