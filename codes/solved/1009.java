import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt( br.readLine() );
        
        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt( tmp[0] );
            int b = Integer.parseInt( tmp[1] );
            int c = 1;
            for(int j=0; j<b; j++) {
                c *= a%10;
                c = c%10;
            }       
            if( c == 0 )
                c = 10;
            bw.write( c + "\n" );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
