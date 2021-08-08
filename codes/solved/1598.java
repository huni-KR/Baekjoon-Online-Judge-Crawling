import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[]tmp = br.readLine().split(" ");
        
        int start = Integer.parseInt( tmp[0] );
        int end = Integer.parseInt( tmp[1] );
        
        int count = 0;
        int[][] pos = new int[2][2];
        pos[0][0] = ( start - 1 ) / 4;
        pos[0][1] = ( start - 1 ) % 4;
        pos[1][0] = ( end - 1 ) / 4;
        pos[1][1] = ( end - 1 ) % 4;
        count += Math.abs(pos[0][0] - pos[1][0]);
        count += Math.abs(pos[0][1] - pos[1][1]);

        bw.write( count + "\n" );
        bw.close();
        br.close();
    }
}
