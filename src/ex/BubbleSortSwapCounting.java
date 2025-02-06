import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

//1517
//큰 숫자가 차례로 배열 우측으로 정렬됨.
//현재 배열 최우측 인덱스 - 현재 배열 내에서 가장 큰 숫자의 인덱스 의 시그마 총합
//배열 내에서 가장 큰 수를 하나하나 찾기 시작하면 시간복잡도는 O(n**2)
//탐색 알고리즘 최적화가 필요.
public class BubbleSortSwapCounting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>(num);
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<num; i++){
            arr.add(Integer.parseInt(tmp[i]));
        }

        int counter = 0;





        bw.write(String.valueOf(counter));
        bw.flush();
        bw.close();
    }

}
