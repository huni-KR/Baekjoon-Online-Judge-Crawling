import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner( System.in );
        int N = kb.nextInt();
        int m = kb.nextInt();
        int M = kb.nextInt();
        int T = kb.nextInt();
        int R = kb.nextInt();
        kb.close();

        if( m+T > M || R == 0 )
            System.out.println( -1 );
        else {
            int count = 0;
            int tmpm = m;
            while( N != 0 ) {
                if( tmpm + T <= M ) {
                    tmpm += T;
                    N--;
                }
                else {
                    tmpm -= R;
                    if( tmpm < m )
                        tmpm = m;
                }
                count++;
            }
            System.out.println( count );
        }
    }
}
