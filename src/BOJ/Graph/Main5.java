package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int L = cond[0];
            int R = cond[1];
            int C = cond[2];

            if(L==0&&R==0&&C==0){
                break;
            }

            String[][][] building = new String[L][R][C];

            int[]start = new int[4];
            int[] exit = new int[3];

            for(int j=0; j<L; j++){
                for(int i=0; i<R; i++){
                    building[j][i] = br.readLine().split("");
                    for(int k=0; k<C; k++){
                        if(building[j][i][k].equals("S")){
                            start = new int[]{k,i,j,0}; //x,y,z
                        }else if(building[j][i][k].equals("E")){
                            exit = new int[]{k,i,j}; //x,y,z
                        }
                    }
                }
                if(j<L-1) {
                    br.readLine();
                }
            }


            int result =  bfs(building, start, exit, L,R,C);
            if(result==-1){
                System.out.println("Trapped!");
            }else{
                System.out.println("Escaped in " +result+" minute(s).");
            }


            br.readLine();//테스트 케이스 간 간격

        }

    }
    public static int bfs(String[][][] building, int[] start, int[] exit, int L, int R, int C){
        int[] dx= {1,-1,0,0, 0,0};
        int[] dy= {0,0,1,-1, 0,0};
        int[] dz= {0,0,0,0, 1,-1};

        boolean[][][] visited = new boolean[L][R][C];

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[] pos = new int[4];


        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            int nowTime = now[3];
            pos = new int[]{x,y,z, nowTime};
            if (x >= 0 && y >= 0 && z >= 0 && x < C && y < R && z < L) {
                String nowWhat = building[z][y][x];
                //System.out.println(Arrays.toString(pos));
                if (!visited[z][y][x]) {
                    visited[z][y][x] = true;
                    if (nowWhat.equals("E")) {

                        break;
                    }else if (nowWhat.equals(".") || nowWhat.equals("S")) {
                        for (int i = 0; i < 6; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];
                            int nz = z + dz[i];

                            q.add(new int[]{nx, ny, nz, nowTime+1});
                        }
                    }


                }
            }
        }
        if(pos[0]==exit[0]&&pos[1]==exit[1]){
            return pos[3];
        }else{
            return -1;

        }

    }
}
