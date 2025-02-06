package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main24 {
    public static int N, M, totalH;
    public static int[] base, sph;
    public static int totalScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        totalH = 24*N;

        base = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Subject> pq = new PriorityQueue<>((a,b)->b.sph-a.sph);

        for(int i=0; i<M; i++){
            if (base[i] < 100) {
                pq.offer(new Subject(base[i], sph[i]));
            }
        }

        while(totalH>0&&!pq.isEmpty()){
            Subject sb = pq.poll();
            int max = Math.min(sb.sph, 100-sb.score);
            totalScore+=max;
            sb.score+=max;

            if(sb.score<100){
                pq.offer(sb);
            }
        }
    }
}

class Subject{
    public int score;
    public int sph;
    public Subject(int score, int sph){
        this.score = score;
        this.sph = sph;
    }
}
