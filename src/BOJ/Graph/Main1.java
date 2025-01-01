package BOJ.Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1 {

    private static int turnCnt = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //토마토는 한턴에 상하좌우 4개 영향
        //그래프에서 1인 좌표 모두 큐1에 넣는다.
        //q1->q2로 옮기고 q2로 순회
        //좌표마다 순회하면서 0인 것, visited false 인 것 큐2 넣기
        //종료: 큐1이 비었을 때

        int result = 0;

        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        //graph
        int[][] box = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int h =0; h<n; h++){
            box[h] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q1 = new LinkedList<>();

        int cnt1 = 0;
        int cnt0 = 0;
        //토먀토가 1개 이상 존재하고, 모든 토마토가 익어있다. -> ((cnt0+cnt1) != 0) && (cnt0 == 0)
        //토마토가 전부 익을 수 없는 상황 ->토마토가 없다 or bfs 이후 0 남아있다.
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                if(box[j][i]==1){
                    cnt1++;
                    q1.add(new int[]{i,j});
                }else if(box[j][i]==0){
                    cnt0++;
                }
            }
        }


        if( ((cnt0+cnt1) != 0) && (cnt0 == 0) ){
            result = 0;
        }else{
            int afterCnt0 = 0;
            bfs(box, visited, q1,m,n);
            for(int j=0; j<n; j++){
                for(int i=0; i<m; i++){
                    if(box[j][i]==0){
                        afterCnt0++;
                    }
                }
            }
            if(afterCnt0>0){
                result = -1;
            }else{
                result = turnCnt;
            }
        }

        System.out.println(result);

    }

    private static void bfs(int[][] box,boolean[][] visited, Queue<int[]> q1,int m,int n){

        while(!q1.isEmpty()) {
            Queue<int[]> q2 = new LinkedList<>(q1);
            q1.clear();
//            System.out.println(turnCnt);
//            for (int[] value : q2) {
//                System.out.println(Arrays.toString(value));
//            }
            int propagteCnt = 0;
            while (!q2.isEmpty()) {

                int[]now = q2.poll();
                int nx = now[0];
                int ny = now[1];

                int[] dx = {1,-1,0,0};
                int[] dy = {0,0,1,-1};

                //노드가 방문되지 않았고, 값이 1일 때,
                if(!visited[ny][nx]&&box[ny][nx]==1){
                    visited[ny][nx]=true;

                    for(int k=0; k<4; k++){
                        int x = nx+dx[k];
                        int y = ny+dy[k];

                        if(x>=0&&x<m && y>=0&&y<n &&!visited[y][x]&& box[y][x]==0){
                            q1.add(new int[]{x,y});
                            box[y][x]=1;
                            propagteCnt++;
//                            for (int[] value : q1) {
//                                System.out.println(Arrays.toString(value));
//                            }
                        }
                    }
                }

            }
            if(propagteCnt>0){
                turnCnt++;
            }

//            System.out.println("------------");

        }

    }
}
