import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class SortNode {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];


        //("x y")문자열 실수형 배열로 변환
        for(int i=0; i<num;i++){
            String[] node = br.readLine().split(" ");
            int[] intArr = Arrays.stream(node).mapToInt(Integer::parseInt).toArray();
            arr[i] = intArr;
        }

        br.close();

        //quick sort
        quickSort(arr, 0, num-1);

        for(int l=0; l<num-1; l++){
            bw.write(arr[l][0]+" "+arr[l][1]);
            bw.newLine();
        }
        bw.write(arr[num-1][0]+" "+arr[num-1][1]);
        bw.flush();
        bw.close();
    }


    public static void quickSort(int[][] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int[][] arr, int low, int high){
        int i = low;
        int mid = (high-low)/2+ low;
        int[] pivot = arr[mid];
        swap(arr, mid, high);

        for(int j=low;j<high;j++){
            if(arr[j][0]<pivot[0]||arr[j][0]==pivot[0]&&arr[j][1]<pivot[1]){
               swap(arr, i, j);
               i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[][]arr, int a, int b){
        int[] tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
