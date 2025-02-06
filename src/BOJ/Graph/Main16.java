package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main16 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        int m = Integer.parseInt(br.readLine().split(" ")[0]);

        int[][] map = new int[n+1][n+1];

        for(int i=1; i<n+1; i++){
            map[i] = Arrays.stream(("0 "+br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.deepToString(map));

        //dfs 로 찾으면 됨
        //1번 3번 이어져있다면

        dfs(map, plan, n, m);
    }
    public static void dfs(int[][] map, int[] plan, int n, int m) {



    }

}
