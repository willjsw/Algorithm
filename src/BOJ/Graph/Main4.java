package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmr = br.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int range = Integer.parseInt(nmr[2]);

        int[][] game = new int[n][m];

        for(int i=0; i<n; i++){
            game[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //성 초기화
//        Arrays.fill(game[n], 0);

        int maxKill = 0;
        int[] archer = new int[3];

        for(int j=2; j<m; j++){
            archer[2] =j;
            for(int k=1; k<j;k++){
                archer[1] = k;
                for(int l=0; l<k;l++){
                    archer[0] = l;
                    System.out.println(Arrays.deepToString(game));
                    System.out.println(Arrays.toString(archer));
                    int nowKill = bfs(archer, game, n, m, range);
                    if(nowKill>maxKill){
                        maxKill = nowKill;
                    }
                    System.out.println(nowKill);
                    System.out.println(maxKill);
                }
            }
        }

        System.out.println(maxKill);
        //궁수 3명을 배열(배열 마지막 행 중 3개 노드 골라서 채우기
        //각 위치에서 bfs 로 왼쪽부터 가장 가까운 적 고르기(겹칠 수 있음)
        //범위 내여야 하므로, 이동 중 거리가 range 이내인지 체크하고, 초과하면 끝내기
        //해당 위치는 0,0 으로 바꾸기
        //공격이 끝나면 같 앞의 행을 하나씩 당기기

    }

    public static int bfs(int[] archer, int[][] origin, int n, int m, int range){

        int[][] game = new int[n][m];
        for(int i=0; i<n; i++){
            System.arraycopy(origin[i], 0, game[i], 0, m);
        }

        int kill = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int t = n; t>=0; t--){
            int[][] archers = { {archer[0], t}, {archer[1], t}, {archer[2], t}} ;
            int limit = t-range;
            if(limit<0){
                limit = 0;
            }

            for(int j=0; j<n; j++){
                System.out.println(Arrays.toString(game[j]));
            }
            System.out.println("------------------------");


            Set<int[]> enemyLoc = new HashSet<>();

            for(int[] a : archers){
                System.out.println("attack:"+Arrays.toString(a));
                boolean[][] searched = new boolean[n][m];
                List<int[]> enemies = new ArrayList<>();
                Queue<int[]>q = new LinkedList<>();
                q.add(a);
//                boolean isFind = false;
                //range에서 직선거리에 있는 적 공격이 최대 범위, range
                while(!q.isEmpty()){

                    int[] now = q.poll();
                    int nx = now[0];
                    int ny = now[1];

                    for(int p = 0; p<4; p++){
                        int x = nx+dx[p];
                        int y = ny+dy[p];


                        if(y>=limit && y<t && x>=0 && x<m && !searched[y][x]){
                            int enemy = game[y][x];
                            int[] loc = new int[]{x,y};
                            System.out.println("now Enemy:"+Arrays.toString(loc));
                            if(enemy==1 && calRange(a, loc)<=range){
                                enemies.add(loc);
                                enemyLoc.add(loc);


                                System.out.println("found Enemy:"+Arrays.toString(loc));
                            }
                            searched[y][x] = true;
                            q.add(loc);

                        }

                    }

                }//while
                kill+=enemyLoc.size();

                Iterator<int[]> iterSet  = enemyLoc.iterator();
                while (iterSet.hasNext()){
                    int[] next = iterSet.next();
                    game[next[1]][next[0]] = 0;
                }
                enemyLoc.clear();


            }//for each

        }
        return kill;
        //거리계산
    }
    public static int calRange(int[]archer, int[]enemy){
        int cx = (int)Math.sqrt(Math.pow((archer[0]-enemy[0]),2));
        int cy = (int)Math.sqrt(Math.pow((archer[1]-enemy[1]),2));

        return cx+cy;
    }


}
