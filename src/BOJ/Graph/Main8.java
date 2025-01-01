package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main8 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine().split("")[0]);

        int[][] sea = new int[size][size];
        int[] bs = new int[3];

        for(int i=0; i<size; i++){
            sea[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j =0; j<size; j++){
                if(sea[i][j]==9){
                    bs = new int[] {j, i, 0};
                }
            }
        }

       System.out.println(bfs(sea, bs, size));
    }

    public static int bfs(int[][]sea, int[]bs, int size){
        Queue<int[]> q = new LinkedList<>();
        q.add(bs);

        int[] dx = {-1, 1, 0, 1};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[size][size];

        while(!q.isEmpty()){

            for(int i=0; i<q.size(); i++){
                int[] now = q.poll();
                int nx = now[0];
                int ny = now[1];
                //1.그리드 유효 범위 내에 있고, 방문하기 전인가?
                //2. 번호 확인(0, 1-6, 9)
                //3. 0이거나 같은 크기인 경우 : 그대로 통과하고 다음 물고기 찾아 떠남
                //4. 크기보다 작은 경우: 비교대상에 넣기, 이동 최소 칸 수를 현재에 고정

                if(nx>=0 && nx<size && ny>=0 && ny<size &&!visited[ny][nx]){

                }
            }

        }


        return 0;
    }



}
