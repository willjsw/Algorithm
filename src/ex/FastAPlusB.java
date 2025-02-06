import java.io.*;
import java.io.BufferedReader;

//No.18552
public class FastAPlusB {
 public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

     int num = Integer.parseInt(br.readLine());

     for(int i=0; i<num; i++){
         String[] array = br.readLine().split(" ");
         String ans = String.valueOf(Integer.valueOf(array[0])+Integer.valueOf(array[1]));

         bw.write(ans+"\n");


     }
     bw.flush();
     br.close();
     bw.close();
 }
}
