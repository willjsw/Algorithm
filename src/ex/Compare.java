import java.io.*;


//No.1000
public class Compare {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String array[] = s.split(" ");
        String ans = String.valueOf(Integer.valueOf(array[0]) + Integer.valueOf(array[1]));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans);
        bw.flush();
        bw.close();
    }

}
