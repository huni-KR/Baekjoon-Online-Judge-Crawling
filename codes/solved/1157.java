import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);        
        String str = kb.next().toUpperCase();       
        kb.close();
        
        int[] a = new int[26];              
        for(int i=0; i<str.length(); i++)
            a[ str.charAt(i) - 'A' ]++;

        System.out.println( findMax( a ) );     
    }

    private static char findMax(int[] a) {

        int count = 0;
        char output = ' ';
        for(int i=0; i<a.length; i++) {
            if( count < a[i] ) {
                count = a[i];
                output = (char) ( 'A' + i );
            }
            else if( count == a[i] )
                output = '?';
        }       
        return output;
    }
}
