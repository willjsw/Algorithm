import com.sun.jdi.ArrayReference;

import java.io.*;
import java.util.Arrays;

public class Average {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int[] arr = new int[5];
        for (int i=0; i<5;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        br.close();

        for(int i = 0; i<5; i++){
            for(int j=0; j<5-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }


        int average = Arrays.stream(arr).sum()/5;
        int mid = arr[2];

        bw.write(String.valueOf(average));
        bw.newLine();
        bw.write(String.valueOf(mid));

        bw.flush();
        bw.close();

    }

}
