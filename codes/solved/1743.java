import java.util.Scanner;

public class Main {

    static int count = 0;
    static int x;
    static int y;
    static int[][] grid;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        y = kb.nextInt();
        x = kb.nextInt();
        int n = kb.nextInt();

        grid = new int[y][x];
        for(int i=0; i<n; i++) 
            grid[kb.nextInt()-1][kb.nextInt()-1] = 1;

        kb.close();

        System.out.println( findSize(x, y) );
    }

    private static int findSize(int x, int y) {

        int max = 0;
        for(int i=0; i<y; i++) 
            for(int j=0; j<x; j++) {
                if( grid[i][j] % 2 == 1 ) {
                    count = 0;
                    counter(i, j );
                    int tmp = count;
                    if( max < tmp )
                        max = tmp;
                }
            }

        return max;
    }

    private static boolean counter(int py, int px) {

        if( py < 0 || px < 0 || px >= x || py >= y )
            return false;

        if( grid[py][px] == 3 )
            return false;

        else if( grid[py][px] == 1 ){
            grid[py][px] = 3;
            count++;

            if( counter( py, px+1 ) || counter( py+1, px ) || counter( py, px-1 ) || counter( py,  ) )
                return true;
        }
        return false;
    }
}
