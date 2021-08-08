import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        String[] token = br.readLine().split(" ");
        long a = Long.parseLong( token[0] );
        long b = Long.parseLong( token[1] );
        br.close();
        
        long gcd = gcd( a, b );
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<gcd; i++)
            bw.write("1");
        bw.flush();
        bw.close();

    }

    private static long gcd(long a, long b) {
        if( a < b ) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        
        if( a % b == 0 )
            return b;
        else 
            return gcd( b, a % b );     
    }
}
