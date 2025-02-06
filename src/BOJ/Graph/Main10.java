package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//1325 효율적인 해킹
public class Main10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] computers = new int[n+1][n+1];
        int[] dist = new int[n+1];

            Arrays.fill(dist, 1);

        for(int i=0; i<m; i++){
            String[] trust = br.readLine().split(" ");
            int from = Integer.parseInt(trust[0]);
            int to = Integer.parseInt(trust[1]);
            computers[from][to] = 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()){
            int now = stack.pop();

            for(int j=0; j<m; );
        }



        System.out.println(Arrays.deepToString(computers));

    }
}

//A->B
//B->A 일 때?

