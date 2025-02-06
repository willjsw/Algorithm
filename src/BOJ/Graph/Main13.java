package BOJ.Graph;

import java.io.*;
import java.util.Arrays;

public class Main13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] num1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] num2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(num1);
        System.out.println(Arrays.toString(num1));
        int pt = n/2;

        for(int i=0; i<m; i++){
            System.out.println(pt);
            int result = binarySearch(num1, pt,num2[i],n);
            System.out.println(result);
            System.out.println("----------");

            bw.write(result+" ");

        }
        bw.flush();
        bw.close();
    }

    public static int binarySearch(int[] num1, int pointer, int target, int n){
        int cnt = 0;
        if(pointer>=0&&pointer<n){
            if(num1[pointer] == target){
                cnt++;
                int up = pointer;
                int down = pointer;
                while(true){
                    System.out.println(num1[up]);
                    up++;
                    if(up>=0&&up<n&&num1[up] == target) {
                        cnt++;
                    }else {
                        break;
                    }
                }
                while(true){
                    down--;
                    System.out.println(num1[down]);
                    if(down>=0&&down<n&&num1[down] == target) {
                        cnt++;
                    }else{
                        break;
                    }

                }
            }else if(target>num1[pointer]){
                System.out.println(pointer+ " up to "+(pointer+(n-pointer)/2-1));
                cnt = binarySearch(num1, pointer+(n-pointer)/2-1, target, n);
            }else if(target<num1[pointer]){
                System.out.println(pointer+ " down to" +(pointer/2-1));
                cnt = binarySearch(num1, pointer/2-1, target, n);
            }
        }

        return cnt;
    }

}
