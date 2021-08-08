import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt( br.readLine() );

        String[] tmp = br.readLine().split(" ");

        int[] arrA = new int[n];
        for(int i=0; i<n; i++)
            arrA[i] = Integer.parseInt( tmp[i] );

        tmp = br.readLine().split(" ");
        int[] arrB = new int[n];
        for(int i=0; i<n; i++)
            arrB[i] = Integer.parseInt( tmp[i] );

        Arrays.sort( arrA );
        Arrays.sort( arrB );

        int sum = 0;
        for( int i=0; i<n; i++) 
            sum += arrA[i] * arrB[n-1-i];

        bw.write( sum + "\n" );
        bw.flush();
        bw.close();
        br.close();
    }
}
