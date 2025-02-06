package BOJ.Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack  = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int now = 1;
        //now = 1로 시작, n이랑 동일해질 때까지

        for(int i=0; i<n; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        while(now<=n){
            //수가 나오면 일단 스택에 들어가야 함
            stack.push(now);
            result.append("+\n");
            now++;

            while (!stack.isEmpty()&&!q.isEmpty()&&stack.peek().equals(q.peek())) {
                    stack.pop();
                    q.poll();
                    result.append("-\n");
            }

        }

        if(stack.isEmpty()){
            bw.write(result.toString());

        }else {
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
