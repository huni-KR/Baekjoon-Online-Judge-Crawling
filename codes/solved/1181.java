import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();       
        String[] str = new String[n];       
        for(int i=0; i<n; i++) 
            str[i]= kb.next();              
        kb.close();

        Arrays.sort(str);

//      for(int i=0; i<n; i++)
//          System.out.println( str[i] );
//      System.out.println();
//      System.out.println();
//      System.out.println();

        String[] result = new String[20000];
        int count = 0;



        for(int i=1; i<51; i++) {
            for(int j=0; j<n; j++) {
                if( str[j].length() == i ) {
                    if( count == 0 )
                        result[count++] = str[j];
                    else if( count > 0 && !result[count-1].equals( str[j] ) )
                        result[count++] = str[j];
                }
            }
        }
        for(int i=0; i<count; i++)
            System.out.println( result[i] );
        
    }
}
