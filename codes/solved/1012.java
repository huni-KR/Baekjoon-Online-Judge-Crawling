import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[][] grid;
    static int x;
    static int y;   
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int n = Integer.parseInt( num );

        for(int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            x = Integer.parseInt( tmp[0] );
            y = Integer.parseInt( tmp[1] );
            int number = Integer.parseInt( tmp[2] );

            grid = new boolean[y][x];
            for(int j=0; j<number; j++) {
                tmp = br.readLine().split(" ");
                grid[ Integer.parseInt( tmp[1] ) ][ Integer.parseInt( tmp[0] ) ] = true;
            }

            int count = 0;
            for(int a=0; a<y; a++) 
                for(int b=0; b<x; b++) 
                    if( grid[a][b] ) {
                        grid[a][b] = false;
                        removeTrue( a, b );
                        count++;
                    }
            
            bw.write( count + "\n" );
        }
        bw.close();
        br.close();
    }
    
    private static void removeTrue(int a, int b) {

        for(int i=0; i<4; i++) {
            int nowX = b + dx[i];
            int nowY = a + dy[i];
            
            if( nowX >= x || nowY >= y || nowX < 0 || nowY < 0 )
                continue;
            
            if( grid[nowY][nowX] ) {
                grid[nowY][nowX] = false;
                
                removeTrue( nowY, nowX );
            }   
        }           
    }
}
