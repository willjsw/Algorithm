import java.io.*;


//No.2884
public class Alarm {
  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      //시간 데이터 입력

      String[] array = br.readLine().split(" ");
      int h = Integer.parseInt(array[0]);
      int m = Integer.parseInt(array[1]);

      if(m>=45){
          m-=45;
      }else{
          h = (h==0) ? 23 : h-1;
          m=60+(m-45);
      }
      bw.write(h+" "+m);
      bw.flush();
      bw.close();
  }

}
