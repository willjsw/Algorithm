package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main6 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeNum = Integer.parseInt(br.readLine());
        int[] tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int delete = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Set<Integer> kill = new HashSet<>();



        stack.push(delete);
        kill.add(delete);


        while(!stack.isEmpty()){

            int target = stack.pop();
            for(int i=0; i<nodeNum; i++){
                if(tree[i]==target){
                     stack.push(i);
                     kill.add(i);
                }
            }
        }

        int cnt = 0;
        for(int j=0; j<nodeNum; j++){
            boolean hasChild = false;
            if(!kill.contains(j)){
                for(int i=j+1; i<nodeNum; i++){
                    if(!kill.contains(i)) {
                        if(j==tree[i]){
                            hasChild = true;
                            break;
                        }
                    }
                }
                if(!hasChild){
                    cnt++;
                }
            }



        }

        System.out.println(cnt);




    }
}
