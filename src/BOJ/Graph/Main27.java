package BOJ.Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main27 {
    public static int M,N,H;
    public static int[][][] box;

    public static int[] dx = new int[]{1,-1, 0, 0, 0, 0};
    public static int[] dy = new int[]{0, 0, 1,-1, 0, 0};
    public static int[] dz = new int[]{0, 0, 0, 0, 1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int cntZero = 0;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                    box[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=0; k<M; k++){
                    if(box[i][j][k]==1){
                        q.add(new int[]{k,j,i});
                    }else if(box[i][j][k]==0){
                        cntZero++;
                    }
                }
            }
        }

        int result = (cntZero==0) ? 0 :  bfs(q);
        System.out.println(result);

    }
    public static int bfs(Queue<int[]> q){

        boolean[][][] visited = new boolean[H][N][M];
        int cnt = 0;

        while(!q.isEmpty()){
            int isChanged = 0;
            int s = q.size();
            for(int i=0; i<s; i++){
                int[] now = q.poll();
                int nx = now[0];
                int ny = now[1];
                int nz = now[2];

                if(box[nz][ny][nx]==1){

                    for(int j=0; j<6; j++){
                        int x = nx + dx[j];
                        int y = ny + dy[j];
                        int z = nz + dz[j];
                        if(x>=0&&y>=0&&z>=0&&x<M&&y<N&&z<H&&!visited[z][y][x]){
                            visited[z][y][x] = true;
                            if(box[z][y][x]!=-1){
                                if(box[z][y][x]==0){
                                    box[z][y][x]=1;
                                    isChanged++;
                                }
                                q.add(new int[]{x,y,z});
                            }



                        }

                    }
                }


            }

            cnt = (isChanged!=0) ? cnt+1 : cnt;

        }

        for(int a=0; a<H; a++){
            for(int b=0; b<N; b++){
                for(int c=0; c<M; c++){

                    if(box[a][b][c]==0){
                        return -1;
                    }
                }
            }
        }

        return cnt;

    }
}
