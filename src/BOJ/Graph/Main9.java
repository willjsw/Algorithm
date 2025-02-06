package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main9 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cond = br.readLine().split(" ");
        int n = Integer.parseInt(cond[0]);
        int m = Integer.parseInt(cond[1]);

        int[][] map = new int[n][m];

        int[] start = {0,0, 0};
        int[] des = {m-1,n-1};

        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(map, start, des, n, m);



    }
    public static void bfs(int[][] map, int[] start, int[] des, int n, int m){
        Queue<int[]> q = new LinkedList<>();
         //boolean[][][] visited = new boolean[n][m][1];
        int[][][] dist = new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dist[i][j], -1);
            }
        }
        dist[0][0][0] = 1;

        q.add(start);
        int min = -1;

        //int cnt = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){

            int[] now = q.poll();

            int nx = now[0];
            int ny = now[1];
            int w = now[2];

            if(nx == des[0] && ny == des[1]) {
                System.out.println(dist[ny][nx][w]);
                return;
            }

            for(int k=0; k<4; k++){
                int x = nx+dx[k];
                int y = ny+dy[k];

                if(x<0 || x>=m || y<0 || y>=n || dist[y][x][w] != -1) continue;

                if(map[y][x]==0){
                    dist[y][x][w] = dist[ny][nx][w]+1;
                    q.add(new int[]{x,y,w});

                }else{
                    if(w==0){
                        dist[y][x][1] = dist[ny][nx][0]+1;
                        q.add(new int[]{x,y,1});
                    }

                }
            }

        }

        System.out.println(-1);
    }
}


//1을 없애는 경우의 수를 전부 찾으면 시간초과
//solved