package BOJ.Graph;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main23 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cardNum = Integer.parseInt(sc.nextLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> cardQ = new ArrayDeque<>();
        Queue<Integer> trashQ = new ArrayDeque<>();

        for(int i=1;i<cardNum+1; i++){
            cardQ.add(i);
        }

        while(cardQ.size()!=1){
            trashQ.add(cardQ.poll());
            cardQ.add(cardQ.poll());
        }

        while(!trashQ.isEmpty()){
            bw.write(trashQ.poll()+" ");
        }
        bw.write(String.valueOf(cardQ.poll()));
        bw.flush();
        bw.close();

    }
}
