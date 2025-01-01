package BOJ.Graph;

import java.io.*;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int result = 0;


        //원래 로직: 배열에 숫자를 넣는다 - 정렬 한다 - 가운데를 찾는다
        //크기 순으로
        for(int i=0; i<num; i++){
            int now = Integer.parseInt(br.readLine());





            bw.write(result+"\n");

        }

        bw.flush();

    }
}
