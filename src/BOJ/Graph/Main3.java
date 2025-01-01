package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
//게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
//왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작
//각각의 동작에서 공은 동시에 움직인다.
//빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패 / 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
//빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다
//최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지

//보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)
//N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열
//'.', '#', 'O', 'R', 'B'


//최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다.
//10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1

public class Main3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");

        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);



        String[][]game = new String[n][m];
        for(int i=0; i<n; i++){
            game[i] = br.readLine().split("");
        }

        System.out.println(Arrays.deepToString(game));

        int[] hole = new int[2];
        int[] red = new int[2];
        int[] blue = new int[2];

        for(int k=1; k<n; k++){
            for(int j=1; j<m; j++){

                String target = game[k][j];
                if(target.equals("R")){
                    red = new int[]{j,k};
                }else if(target.equals("B")){
                    blue= new int[]{j,k};
                }else if(target.equals("O")){
                    hole= new int[]{j,k};
                }
            }
        } // R, B, hole 위치 파악
        int[][] marbles = {red, blue};
        int result =  dfs(game, marbles, hole, m, n);
        System.out.println(result);

        //실제 그래프의 범위: 0<x<m-1 , 0<y<n-1
        //1. 기울이는 방향 (상하좌우) 반복문으로 돌리고, 각 결정된 방향에 대해 조금이라도 앞서 있는 구슬 찾아 먼저 움직인다.
        //2.  "#" 또는 "0"이 나올 때까지 이동.(while)
        //Dfs : 스택에 [Red, Blue]로 집어넣기, 먼저 움직일 공을 앞에 넣기


    }
    public static int dfs(String[][]game, int[][] marbles, int[] hole, int m, int n){
        System.out.println("start");
        int[] dx = {1,-1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int hx = hole[0];
        int hy = hole[1];

        int minCnt = 0;
        int cnt = 0;

        Stack<int[][]> stack  = new Stack<>();
        stack.push(marbles);


        while(!stack.isEmpty()){
            cnt ++;

            System.out.println(stack.size());
            System.out.println(Arrays.deepToString(stack.peek()));
            int[][] now = stack.pop();

            int[]red = now[0];
            int[]blue = now[1];

            boolean rih = false;
            boolean bih = false;


            //기울임 방향
            for(int l=0; l<4; l++){

                int rx = red[0];
                int ry = red[1];

                int bx = blue[0];
                int by = blue[1];

                int ndx = dx[l];
                int ndy = dy[l];
                System.out.println("-------------------");
                System.out.println("RED = "+rx+","+ry);
                System.out.println("BLUE = "+bx+","+by);
                System.out.println("dx/dy = "+ndx+","+ndy);
                System.out.println("roll");

                //구슬 굴리기

                boolean redAhead = false;
                boolean blueAhead = false;


                while(rx+ndx>0&&rx+ndx<m-1&&ry+ndy>0&&ry+ndy<n-1){

                    //빨간구슬 굴러감
                    rx+=ndx;
                    ry+=ndy;

                    if(rx == hx && ry ==hy){
                        System.out.println("out");
                        rih = true;
                      break;
                    }else if(game[ry][rx].equals("#")){
                        System.out.println("stop");
                        rx-=ndx;
                        ry-=ndy;
                        break;
                    }else if(game[ry][rx].equals("B")){
                        System.out.println("blueAhead");
                        blueAhead=true;
                        rx = red[0];
                        ry = red[1];
                        break;
                    }

                }//빨간구슬 멈춤

                while(bx+ndx>0&&bx+ndx<m-1&&by+ndy>0&&by+ndy<n-1){
                    //빨간구슬 굴러감
                    bx+=ndx;
                    by+=ndy;
                    if(bx == hx && by ==hy){
                        System.out.println("out");
                        bih = true;
                        break;
                    }else if(game[by][bx].equals("#")){
                        System.out.println("stop");
                        bx-=ndx;
                        by-=ndy;
                        break;
                    }else if(game[by][bx].equals("R")){
                        System.out.println("redAhead");
                        redAhead=true;
                        bx = blue[0];
                        by = blue[1];
                        break;
                    }
                }//파란 구슬 멈춤


                //빨간구슬만 통과했을 때
                if(rih&&!bih){
                    if(minCnt==0||cnt<minCnt){
                        minCnt = cnt;
                        System.out.println("minCnt:"+minCnt);
                    }
                }else if(!rih&&!bih){ //둘 다 빠지지 않았을 때
//                    if(!redAhead&&!blueAhead){
//                        stack.push(new int[][]{{rx,ry}, {bx, by}});
//                    }else
                    if(blueAhead){
                        rx = bx-ndx;
                        ry = by-ndy;
                    }else if(redAhead){
                        bx = rx-ndx;
                        by = ry-ndy;
                    }
                    System.out.println("RED = "+rx+","+ry);
                    System.out.println("BLUE = "+bx+","+by);
                    if(rx!=red[0]||ry!=red[1]||bx!=blue[0]||by!=blue[1]){
                        stack.push(new int[][]{{rx,ry}, {bx, by}});
                    }
                    stack.push(new int[][]{{rx,ry}, {bx, by}});
                    System.out.println(Arrays.deepToString(stack.peek()));
                }

            }
            System.out.println("udlr end ******************************");

        }
        if(minCnt>10){
            minCnt = -1;
        }

        return minCnt;
    }
}
