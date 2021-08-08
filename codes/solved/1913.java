import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);        
        int n = kb.nextInt();
        int target = kb.nextInt();      
        kb.close();

        int[][] grid = new int[n][n];

        int num = n*n;
        int[] pos = new int[2];
        fun( grid, num, pos, target);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print( grid[i][j] + " " );
                if( grid[i][j] == target ) {
                    pos[0] = i;
                    pos[1] = j;
                }                   
            }
            System.out.println();
        }
        System.out.println( (pos[0]+1) + " " + (pos[1]+1) );
    }

    private static void fun(int[][] grid, int num, int[] pos, int target) {

        int x = 0, y = 0;
        int way = 0;
        while( true ) {
            if( way % 4 == 0 ) {
                grid[y][x] = num--;
                y++;
                if( !checkNext( grid, x, y ) ) {
                    y--;
                    way++;  
                    num++;
                }
            }
            if( way % 4 == 1 ) {
                grid[y][x] = num--;
                x++;
                if( !checkNext( grid, x, y ) ) {
                    x--;
                    way++;  
                    num++;
                }
            }
            if( way % 4 == 2 ) {
                grid[y][x] = num--;
                y--;
                if( !checkNext( grid, x, y ) ) {
                    y++;
                    way++;          
                    num++;
                }
            }   
            if( way % 4 == 3 ) {
                grid[y][x] = num--;
                x--;
                if( !checkNext( grid, x, y ) ) {
                    x++;
                    way++;  
                    num++;
                }
            }
            if( grid[y][x] != 0 && x == ( grid.length / 2 ) && y == ( grid.length / 2 ) )
                break;          
        }
    }

    private static boolean checkNext(int[][] grid, int x, int y) {
        if( grid.length <= x || grid.length <= y || 0 > x || 0 > y)
            return false;
        if( grid[y][x] != 0 )
            return false;
        return true;        
    }
}
