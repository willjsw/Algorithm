package BOJ.Graph;


//N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
// 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.
// 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
//
//        만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.
//
//        한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
//
//        맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

import javax.swing.text.Style;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

//첫째 줄에 N(1 ≤ N ≤ 1,000), M(1o ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.
//
//        출력
//        첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
public class Main15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = br.readLine().split(" ");
        int n = Integer.parseInt(cond[0]);
        int m = Integer.parseInt(cond[1]);
        int k = Integer.parseInt(cond[2]);

        int[][]map = new int[n][m];
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(map, n, m, k);


    }
    public static void bfs(int[][] map, int n, int m, int k){
        int[][][] dist = new int[n][m][k+1];
        Deque<int[]> q = new ArrayDeque<>();
        dist[0][0][0] = 1;

        q.add(new int[]{0,0,0});

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};


        while(!q.isEmpty()){

            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int nw = now[2];

            if(ny==n-1&&nx==m-1 ){
                System.out.println(dist[ny][nx][nw]);
                return;
            }
            for(int i=0; i<4; i++){
                int x = nx+dx[i];
                int y = ny+dy[i];
                if(x>=0&&y>=0&&x<m&&y<n&&dist[y][x][nw]==0){

                    if(map[y][x]==0){
                        q.add(new int[]{x,y, nw});
                        dist[y][x][nw]=dist[ny][nx][nw]+1;
                    }else if(map[y][x]==1&&nw+1<k+1){
                        q.add(new int[]{x,y, nw+1});

                        dist[y][x][nw+1]=dist[ny][nx][nw]+1;
                    }

                }

            }


        }

        System.out.println(-1);


    }

}
