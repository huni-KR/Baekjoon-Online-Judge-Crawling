import java.util.Scanner;

public class Main {

    static boolean[][] grid = new boolean[6][6];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String tmp = kb.next();
        int startLow = tmp.charAt(0) - 'A';
        int startCol = tmp.charAt(1) - '0';
        grid[--startCol][startLow] = true;

        int tmpLow = 0;
        int tmpCol = 0;
        for(int i=0; i<34; i++) {
            String str = kb.next();
            int low = str.charAt(0) - 'A';
            int col = str.charAt(1) - '0';

            if( i > 0 )
                if( !fun( low, col, tmpLow, tmpCol ) )
                    break;

            tmpLow = low;
            tmpCol = col;
            grid[--col][low] = true;
        }

        tmp = kb.next();
        int endLow = tmp.charAt(0) - 'A';
        int endCol = tmp.charAt(1) - '0';
        grid[--endCol][endLow] = true;      
        kb.close();

        if( isAll() && fun( startLow, startCol, endLow, endCol ) )
            System.out.println("Valid");
        else 
            System.out.println("Invalid");
    }

    private static boolean fun(int startLow, int startCol, int endLow, int endCol) {
        int disLow = (int)Math.abs( startLow - endLow );
        int disCol = (int)Math.abs( startCol - endCol );        
        if( disLow == 2 && disCol == 1 )
            return true;
        else if( disLow == 1 && disCol == 2 )
            return true;        
        return false;
    }

    private static boolean isAll() {
        for(int i=0; i<6; i++) 
            for(int j=0; j<6; j++)
                if( !grid[i][j] )
                    return false;
        return true;
    }
}
