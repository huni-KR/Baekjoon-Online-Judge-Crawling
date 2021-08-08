import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Boolean> list = new ArrayList<Boolean>();

        Scanner kb= new Scanner(System.in);
        int n = kb.nextInt();
        int a = kb.nextInt() - 1;
        int b = kb.nextInt() - 1;

        for(int i=0; i<n; i++) {
            if( i == a || i == b )
                list.add( true );
            else
                list.add( false );
        }       
        kb.close();

        int count = 1;

        while(true) {
            int i = 0;

            int size = list.size();
            if( size % 2 == 1 )
                size--;
            for(i=size-2; i>=0; i-=2) {
                if( list.get(i) && list.get(i+1) )
                    break;
                if( list.get(i) )
                    list.remove(i+1);
                else
                    list.remove(i);
            }
            if( i >=0  )
                if( list.get(i) && list.get(i+1) )
                    break;
            count++;
        }
        System.out.println(count);
    }
}
