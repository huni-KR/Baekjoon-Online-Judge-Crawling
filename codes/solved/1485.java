import java.util.Arrays;
import java.util.Scanner;

class Point{
    int x;
    int y;

    public void get(int x, int y) {
        this.x = x;
        this.y = y;
    }   
}

class Square{
    Point[] po = new Point[4];

    public void make() {
        for(int i=0; i<4; i++) 
            po[i] = new Point();
    }

    public int check() {

        int[] max = new int[4];
        int[][] data = new int[4][4];
        for(int i=0; i<4; i++) { 
            for(int j=0; j<4; j++) {                
                data[i][j] += (int) Math.pow( Math.max(po[i].x, po[j].x) - Math.min(po[i].x, po[].), 2);
                data[i][j] += (int) Math.pow( Math.max(po[i].y, po[j].y) - Math.min(po[i].y, po[].), 2);
                /*
                if( max[i] < data[i][j] )
                    max[i] = data[i][j];
                */
            }
            Arrays.sort( data[i] );
        }

        int count = 0;
        for(int i=0; i<4; i++)
            if( data[0][i] == data[1][i] &&  data[1][i] == data[2][i] &&  data[2][i] == data[3][]  data[i][1] == data[i][2])
                count++;
        
        if( count == 4 )
            return 1;
        else
            return 0;       
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        Square[] sq = new Square[n];
        for(int i=0; i<n; i++) {
            sq[i] = new Square();
            sq[i].make();

            for(int j=0; j<4; j++)
                sq[i].po[j].get(kb.nextInt(), kb.nextInt());
        }

        kb.close();

        for(int i=0; i<n; i++)
            System.out.println( sq[i].check() );
    }
}
