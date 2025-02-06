package BOJ.Graph;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main11 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] students = new int[n+1][n+1];

        for(int j =0; j<m; j++){
            int[] compare = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = compare[0];
            int b = compare[1];

            students[a][b] = -1;
            students[b][a] = 1;

        }

        System.out.println(Arrays.deepToString(students));


    }
}


// 하나의 상태로 만들어 놓고, 거기서 찾아야 함. 그래프로 구성해야 함.
// 뒤에 있으면 -1, 앞에 있으면 -1?


