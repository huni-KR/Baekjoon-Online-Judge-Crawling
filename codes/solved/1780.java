import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] grid;
    static int[] count = new int[3];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt( br.readLine() );
        grid = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                grid[i][j] = Integer.parseInt( tmp[j] );
        }

        Discriminate( 0, 0, n, n );

        for(int i=0; i<count.length; i++)
            bw.write( count[i] +" \n" );
        bw.flush();
        bw.close();
        br.close();
    }

    private static void Discriminate(int x1, int y1, int x2, int y2) {

        if( isEqual( x1, y1, x2, y2 ) ) {
            if( grid[y1][x1] == -1 )
                count[0]++;
            else if( grid[y1][x1] == 0 )
                count[1]++;
            else if( grid[y1][x1] == 1 )
                count[2]++;
        }
        else {
            int n = ( x2 - x1 ) / 3;
            for(int i=0; i<3; i++) 
                for(int j=0; j<3; j++) {
                    if( n == 1 )
                        Discriminate( x1+j*n, y1+i*n, x1+j*n, y1+i*n );         
                    else
                        Discriminate( x1+j*n, y1+i*n, x1+j*n+n, y1+i*n+n );         
                }
        }       

    }

    private static boolean isEqual(int x1, int y1, int x2, int y2) {
        int tmp = grid[y1][x1];
        for(int i=y1; i<y2; i++)
            for(int j=x1; j<x2; j++) 
                if( tmp != grid[i][j] )
                    return false;       
        return true;
    }
}
