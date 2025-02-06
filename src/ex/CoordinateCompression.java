
import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

//18870
//1. 중복 없앤다. -> 각 요소별 순서를 등차 1의 등차수열로 나타낼 수 있도록
//2. 중복 제거한 배열 소팅,
//한번 정렬된 것을 다시 원래 상태로 되돌릴 수는 없기 때문에, 비교하면서 찾을 수 밖에 없음.
//3. 이진탐색 후 index 반환하여 치환하기

public class CoordinateCompression {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        String[] tmpArr = br.readLine().split(" ");

        for(int i=0; i<num; i++){
            arr[i] = Integer.parseInt(tmpArr[i]);
        }

        //int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] distinctArr = Arrays.stream(arr).distinct().toArray();


        //mergeSort(distinctArr);
        Arrays.sort(distinctArr);

        arr = Arrays.stream(arr).map(a-> binarySearch(distinctArr,0, distinctArr.length, a)).toArray();

        for(int x : arr){
            bw.write(x+" ");
        }
        bw.flush();
        bw.close();
    }


    public static void mergeSort(int[] arr){
        //left == right 일 때(배열 길이가 1일 때) 바로 리턴.
        if(arr.length<2) {
            return;
        }

        int mid = arr.length/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);

    }

    public static void merge(int[]arr, int[]leftArr, int[]rightArr) {
        int k = 0, i = 0, j = 0;
        int left = leftArr.length;
        int right = rightArr.length;

        while (i<left && j<right) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while(i<left){
            arr[k++] = leftArr[i++];
        }
        while(j<right){
            arr[k++] = rightArr[j++];
        }

    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        int mid = (end - start)/2+start;

        while(target != arr[mid]){
            if(target>arr[mid]){
                mid = binarySearch(arr, mid+1, end, target);
            }else{
                mid = binarySearch(arr, start, mid, target);
            }
        }
        return mid;

    }

}

