package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] bill = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int tallestNum = 0;

        for(int i=0; i<size; i++){
            int cnt = 0;
            int right = i+1;
            int left = i-1;
            while(right<size){
                if(bill[i]>bill[right]){
                    cnt++;
                    right++;
                }else{
                    break;
                }
            }
            while(left>=0){
                if(bill[i]>bill[left]){
                    cnt++;
                    left--;
                }else{
                    break;
                }
            }
            System.out.println("num"+i+"now:"+cnt+"tallestNum:"+tallestNum);
            if(cnt>tallestNum){
                tallestNum = cnt;
            }

        }

        System.out.println(tallestNum);
    }
}
