import java.io.*;

//2750
public class SortNumber {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];

        for(int i=0; i<num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, num-1);


        for(int n : arr){
            bw. write(String.valueOf(n));
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int[]arr, int low, int high){
        int i = low;
        int mid = (high-low)/2+low;
        int pivot = arr[mid];
        swap(arr, mid, high);

        for(int j=low; j<high; j++){
             if(arr[j]<pivot){
                 swap(arr, i, j);
                 i++;
             }
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[]arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
