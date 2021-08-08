import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );

        char[][] grid = new char[n][n];
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++)
                grid[i][j] = str.charAt(j);
        }
        br.close();

        int countA = 0;
        int countB = 0;
        boolean flag = true;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n - 1; j++) {
                if(flag && grid[i][j] == grid[i][j + 1] && grid[i][j] == '.') {
                    countA++;
                    flag = false;
                }
                else if(grid[i][j] == 'X') flag = true;
            }
            flag = true;
        }
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n - 1; j++) {
                if(flag && grid[j][i] == grid[j + 1][i] && grid[j][i] == '.') {
                    countB++;
                    flag =  false;
                }
                else if(grid[j][i] == 'X') flag = true;
            }
            flag = true;
        }
        System.out.println( countA + " " + countB );
    }
}
