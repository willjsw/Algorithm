package BOJ.Graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Queue;
import java.util.StringTokenizer;


public class Main20 {

    public static int cnt = 0;
    public static int m, n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());


            int[][] field = new int[n][m];

            for(int j=0; j<k; j++){
                int[] cabbage = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int cx = cabbage[0];
                int cy = cabbage[1];
                field[cy][cx] = 1;
            }
            for(int ii=0; ii<n; ii++){
                for(int jj=0; jj<m; jj++){
                    if(field[ii][jj]==1){
                        dfs(new int[]{jj, ii}, field);
                        cnt++;
                    }
                }
            }

            bw.write(cnt+"\n");
            cnt = 0;
        }
        bw.flush();
        bw.close();


    }
    public static void dfs(int[] loc, int[][] field){

        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(loc);
        while (!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];


            if(field[ny][nx]==1){
                field[ny][nx]=0;
                for(int h=0; h<4;h++){
                    int x =nx+dx[h];
                    int y =ny+dy[h];
                    if(x>=0&&x<m && y>=0&&y<n){
                        q.add(new int[]{x,y});
                    }
                }

            }

        }
    }
}

//package BOJ.Graph;
//
//        import java.io.*;
//        import java.util.Arrays;
//
//        import java.util.Stack;
//
//public class Main20 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int t = Integer.parseInt(br.readLine());
//        for(int i=0; i<t; i++){
//            int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int m = mnk[0];
//            int n = mnk[1];
//            int k = mnk[2];
//
//            int[][] field = new int[n][m];
//            int[][] loc = new int[k][2];
//
//            for(int j=0; j<k; j++){
//                int[] cabbage = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//                int cx = cabbage[0];
//                int cy = cabbage[1];
//                field[cy][cx] = 1;
//                loc[j] = new int[]{cx, cy};
//            }
//
//            bw.write(dfs(field,n, m, k,loc)+"\n");
//
//        }
//        bw.flush();
//        bw.close();
//
//
//    }
//    public static int dfs(int[][] field, int n, int m, int k, int[][] loc){
//
//        boolean[][] visited = new boolean[n][m];
//        int[] dx = new int[]{1,-1,0,0};
//        int[] dy = new int[]{0,0,1,-1};
//
//        int cnt = 0;
//        for(int l=0; l<k;l++){
//            int innerCnt = 0;
//            Stack<int[]> stack = new Stack<>();
//            stack.push(loc[l]);
//            while (!stack.isEmpty()){
//                int[] now = stack.pop();
//                int nx = now[0];
//                int ny = now[1];
//
//                if(nx>=0&&nx<m && ny>=0&&ny<n&&!visited[ny][nx]){
//                    if(field[ny][nx]==1){
//                        innerCnt++;
//                        visited[ny][nx] = true;
//                        for(int h=0; h<4;h++){
//                            stack.push(new int[]{nx+dx[h],ny+dy[h]});
//
//                        }
//
//                    }
//                }
//            }
//            if(innerCnt>0){
//                cnt++;
//            }
//
//        }
//
//        return cnt;
//
//
//    }
//}