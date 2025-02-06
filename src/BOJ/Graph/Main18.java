package BOJ.Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        Queue<String> q = new LinkedList<>(Arrays.asList(str));
        Stack<String> stack = new Stack<>();

        //<> 태그가 나오면 태그가 닫힐 때까지 계속 넘기기
        //태그 밖에서는 공백 단위로 문자열 자르기
        //태그 닫히면 그 뒤에 바로 태그가 오지 않는 이상 단어 시작
        //태그 안에서 공백으로 구분된 문자는 뒤집어야 함


        //배열 하나씩 뽑아서 1. 태그 문자가 오는지 확인 -> '<' 나 '>' 오면 그대로 출력
        //태그가 끝나면 공백이 나올 때까지 스택에 넣기
        //공백이 나오면 스택에서 빌 때까지 다 넣기

        while(!q.isEmpty()){
            if(q.peek().equals("<")){
                //모아둔 단어 뒤집어 출력
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }

                while(!q.peek().equals(">")){
                    bw.write(q.poll());
                }
                bw.write(q.poll());
            }else if(q.peek().equals(" ")){
                //모아둔 단어 뒤집어 출력
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                bw.write(q.poll());
            }else{
                stack.push(q.poll());
            }

        }
        //마지막 모아둔 단어 출력
        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();

    }

}
