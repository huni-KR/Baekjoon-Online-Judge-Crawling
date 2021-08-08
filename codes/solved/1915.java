import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] grid;
    static int x;
    static int y;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split(" ");

        x = Integer.parseInt( tmp[1] );
        y = Integer.parseInt( tmp[0] );
        grid = new int[y][x];

        for(int i=0; i<y; i++) {
            String str = br.readLine();
            for(int j=0; j<x; j++) 
                grid[i][j] = str.charAt(j) - '0';
        }

        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++)
                if( grid[i][j] == 1 ) {
                    if( i == 0 || j == 0 )
                        grid[i][j] = 1;
                    else 
                        grid[i][j] = findValue( i, j );
                    max = Math.max( grid[i][j], max );                  
                }
        }
        bw.write( max*max + "\n" );
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findValue(int i, int j) {
        int min = Integer.MAX_VALUE;
        min = Math.min( grid[i-1][j-1], min );
        min = Math.min( grid[i][j-1], min );
        min = Math.min( grid[i-1][j], min );
        return min+1;
    }
}   
