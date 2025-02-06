package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main25 {
    public static int N, M, r, c, d, cnt = 0;
    public static int[][] room;
    public static boolean[][] visited;

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        move();
        System.out.println(cnt);
    }

    public static void move(){

        boolean canClean;
        //현재 칸 청소되지 않은 경우 청소-> visited + 0, 1, 확인
        while(true){
            if(!visited[r][c]&&room[r][c]==0){
                cnt ++;
                visited[r][c] = true;
            }
            canClean = false;
            //청소할 곳이 남았는지 찾기
            for(int i=0; i<4; i++){
                //현재 방향 기준 반시계 회전
                d = (d+3)%4;
                int x = c+dx[d];
                int y = r+dy[d];
                if(x>=0&&x<M&&y>=0&&y<N&&room[y][x]==0&&!visited[y][x]){
                    c = x;
                    r = y;
                    canClean = true;
                    break;
                }
            }
            if(!canClean){
                int reverse = (d+2)%4;
                int rx = c+dx[reverse];
                int ry = r+dy[reverse];
                if(rx>=0&&rx<M&&ry>=0&&ry<N&&room[ry][rx]!=1){
                    c = rx;
                    r = ry;
                }else{
                    break;
                }

            }

        }
    }

}
