package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println(compare(s));

    }

    public static int compare(String s){

        Stack<Character> stack = new Stack<>();
        //*는 이전과 방향이 같을 때
        //+는 이전과 방향이 다를 때
        int tmp = 1;
        int result = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c =='('){
                stack.push(c);
                tmp*=2;
            }else if(c =='['){
                stack.push(c);
                tmp*=3;
            }else if(c ==')'){
                if(stack.isEmpty()||stack.peek() == '['){
                    return 0;
                }
                if(s.charAt(i-1) == '('){
                    result += tmp;
                }
                stack.pop();
                tmp/=2;
            }else if(c ==']'){
                if(stack.isEmpty()||stack.peek() == '('){
                    return 0;
                }
                if(s.charAt(i-1) == '['){
                    result += tmp;
                }
                stack.pop();
                tmp/=3;
            }


        }

        if(!stack.isEmpty()){
            return 0;
        }else{
            return result;
        }
    }
}
