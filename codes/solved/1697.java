import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int count = 0;
    static int[] visit = new int[100500];

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();       
        kb.close();

        if( n == k)
            System.out.println( 0 );

        else {
            for(int i=0; i<visit.length; i++)
                visit[i] = -1;
            BFS( n, k );
        }
    }

    private static void BFS(int n, int k) {

        Queue<Integer> q = new LinkedList<>();
        q.add( n );

        while( !q.isEmpty() ) {

            int size = q.size();
            for(int i=0; i<size; i++) {
                int pos = q.poll();

                if (pos == k) {
                    System.out.println( count );
                    return;
                }
                if (pos - 1 >= 0 && visit[pos - 1] == -1 ) {
                    q.add(pos - 1);
                    visit[pos - 1] = count;
                }

                if (pos + 1 < visit.length && visit[pos + 1] == -1 ) {
                    q.add(pos + 1);
                    visit[pos + 1] = count;
                } 
                if (pos * 2 < visit.length && visit[pos * 2] == -1 ) {
                    q.add(pos * 2);
                    visit[pos * 2] = count;
                }
            }
            count++;
        }   
    }
}
