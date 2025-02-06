package BOJ.Graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main26 {

    public static int N, M;
    public static int[][] map, distance;
    public static boolean[][] visited;

    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        int[] des = new int[2];


        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                if(map[i][j]==2){
                    des[0] = j;
                    des[1] = i;
                }
            }
        }
        bfs(des);
        for(int a=0; a<N;a++){
            for(int b=0; b<M; b++){
                bw.write(distance[a][b]+" ");
            }
            bw.write("\n");
        }
        bw.flush();


    }
    public static void bfs(int[] des){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(des);
        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k<size; k++){
                int[] now = q.poll();
                int nx = now[0];
                int ny = now[1];

                if(nx>=0&&nx<M&&ny>=0&&ny<N&&!visited[ny][nx]){
                    visited[ny][nx] = true;
                    if(map[ny][nx]==0){
                        distance[ny][nx] = 0;
                    }else if(map[ny][nx]==1||map[ny][nx]==2){
                        distance[ny][nx] = cnt;
                        for(int l=0; l<4; l++){
                            int x = nx+dx[l];
                            int y = ny+dy[l];
                            q.add(new int[]{x, y});
                        }
                    }

                }

            }
            cnt++;

        }


        for(int a=0; a<N;a++){
            for(int b=0; b<M; b++){
                if(!visited[a][b]&&map[a][b]!=0){
                    distance[a][b]=-1;
                }
            }
        }


    }
}
//[       [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14],
//        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15],
//        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16],
//        [3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17],
//        [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18],
//        [5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],
//        [6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],
//        [7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21],
//        [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22],
//        [9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23],
//        [10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24],
//        [11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 0, 0, 0, 0, 25],
//        [12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 0, 29, 28, 27, 26],
//        [13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 0, 30, 0, 0, 0],
//        [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 31, 32, 33, 34]]
