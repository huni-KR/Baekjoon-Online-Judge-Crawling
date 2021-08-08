import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf( br.readLine() );
        int[] data = new int[n];
        
        for(int i=0; i<n; i++) 
            data[i] = Integer.parseInt( br.readLine() );
        
        Arrays.sort( data );
        
        long sum = 0;   
        for(int i = 0; i < n; i++)
                if( data[(n-1-i)] - i > 0 )
                    sum += ( data[(n-1-i)] - i );
        
        bw.write( sum + "\n" );
        bw.close();
    }
}
