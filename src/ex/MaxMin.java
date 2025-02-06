import java.io.*;
import java.util.Arrays;


//No.10818
public class MaxMin {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //배열 길이 입력
        int num = Integer.parseInt(br.readLine());

        //배열 입력 & String -> int 형변환
        String[] array = br.readLine().split(" ");
        int[] intArr = new int[num];
        for(int i = 0; i<num;i++){
            intArr[i] = Integer.parseInt(array[i]);
        }


        br.close();



        //Strem 사용 -> Overhead
//        int[] intArr = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();


//        //1. 최소&최대 찾기(삽입 정렬)
//        int i,j,key;
//
//        for(i=1;i<num;i++){
//            key = intArr[i];
//            j=i-1;
//            while(j>=0&&intArr[j]>=key){
//                intArr[j+1] = intArr[j];
//                j--;
//            }
//            intArr[j+1] = key;
//        }

//        //2. 최소&최대 찾기(셸 정렬)
//        int i, j, end, key, gap;
//
//        //gap 설정
//        for(gap=num/2;gap>=1;gap/=2){
//            if(gap%2==0){gap+=1;}
//            System.out.println(gap);
//            //iteration start : start+gap 까지, 배열 길이 초과하지 않도록.
//            for(i=0;i+gap<num;i++){
//                //범위 내 삽입정렬
//                end = i+gap;
//                for(j=i+1;j<=end;j++){
//                    key = intArr[j];
//                    while(j>0&&intArr[j-1]>key){
//                        intArr[j]=intArr[j-1];
//                        intArr[j-1]=key;
//                        j--;
//                    }
//
//                }
//
//            }
//        }

        //3. 최소최대 찾기(퀵 정렬)
        quickSort(intArr, 0, num-1);


        bw.write(intArr[0] + " " + intArr[num - 1]);
        bw.flush();
        bw.close();
    }
    public static void quickSort(int[]arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[]arr, int low, int high){
        int mid = (high-low)/2 + low;
        int pivot = arr[mid];
        int i = low;

        swap(arr, mid, high);

        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr, i,high);
        return i;
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b]= tmp;
    }
}
