package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2500 * 10!/5!5!
public class Main22 {
    public static int n, m;
    public static int[][] lab;
    public static int[] dx = new int[]{1,-1,0,0};
    public static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][n];
        List<int[]> viruses = new ArrayList<>();

        for(int i=0; i<n; i++){
                lab[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int j=0; j<n; j++){
                    if(lab[i][j]==2){
                        viruses.add(new int[]{j,i});
                    }
                }
        }
        int vNum = viruses.size();
        List<List<int[]>> result = new ArrayList<>();
        //10개 중 m개를 뽑는 조합 구하기
        generateCombinations(viruses, m,  0, new ArrayList<>(), result);
        int nowCnt = -1;

        for (List<int[]> virus : result) {
            virus.stream().map(Arrays::toString).forEach(System.out::println);
            int cnt=bfs(virus);
            System.out.println(cnt);
           if(cnt!=-1&&cnt<nowCnt){
               nowCnt=cnt;
           }
        }
        System.out.println(nowCnt);


    }
    public static int bfs(List<int[]> viruses){

        Queue<int[]> q = new ArrayDeque<>();
        q.addAll(viruses);
        //viruses.forEach(v->q.add(v));
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;


        while(!q.isEmpty()){
            int innerCnt=0;
            for(int j=0; j<q.size();j++){
                int[] now = q.poll();
                int nx = now[0];
                int ny = now[1];

                if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    System.out.println(nx+","+ny+":"+lab[ny][nx]);
                    //System.out.println(Arrays.deepToString(visited));
                    if(lab[ny][nx]==0||lab[ny][nx]==2){
                        innerCnt++;
                        for(int i=0;i<4;i++){
                            int x = nx+dx[i];
                            int y = ny+dy[i];
                            q.add(new int[]{x,y});
                        }
                    }
                }
            }
            if(innerCnt>0){
                cnt++;
            }

            System.out.println("now turn:"+cnt);
        }//while
        for(int k=0; k<n; k++){

            for(int l=0; l<n; l++){
                if(!visited[k][l]){
                    return -1;
                }
            }
        }
        return cnt;

    }

    public static void generateCombinations(List<int[]> viruses, int m, int start, List<int[]> current, List<List<int[]>> result) {
        if (current.size() == m) {
                result.add(new ArrayList<>(current)); // 현재 조합을 결과 리스트에 추가
                return;
        }

        for (int i = start; i < viruses.size(); i++) {
            current.add(viruses.get(i)); // 현재 원소를 추가
            generateCombinations(viruses, m, i + 1, current, result); // 다음 원소를 처리
            current.remove(current.size() - 1); // 백트래킹
        }
    }
}
