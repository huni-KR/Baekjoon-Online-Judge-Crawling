import java.util.Arrays;
import java.util.Scanner;

class Data{
    String name;
    int n = 0;
}

public class Main {

    static int count = 0;
    static String[] output;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        Data[] data = new Data[n];

        for(int i=0; i<n; i++) {
            String tmp = kb.next();
            int pos = checkString(tmp, data );

            if( count == 0 ) {
                data[count] = new Data();
                data[count].name = tmp;
                data[count].n++;
                count++;                
            }

            else {
                if( pos >= 0 ) 
                    data[pos].n++;
                else {
                    data[count] = new Data();
                    data[count].name = tmp;
                    data[count].n++;
                    count++;                    
                }                   
            }           
        }       
        kb.close();

        int max = findMax( data );
        int maxCounter = maxCounter( max, data );

        output = new String[maxCounter];
        
        int a = 0;
        for(int i=0; i<count; i++)
            if( max <= data[i].n ) {
                output[a] = data[i].name;
                a++;
            }
        
        Arrays.sort( output );  

        System.out.println( output[0] );
            
    }

    private static int maxCounter(int max, Data[] data) {
        int result = 0;
        for(int i=0; i<count; i++)
            if( max == data[i].n )
                result++;
        return result;
    }

    private static int findMax(Data[] data) {

        int max = 0;
        for(int i=0; i<count; i++)
            if( max < data[i].n )
                max = data[i].n;

        return max;
    }

    private static int checkString(String tmp, Data[] data) {       
        for(int i=0; i<count; i++) 
            if( data[i].name.compareTo( tmp ) == 0 )
                return i;       
        return -1;
    }
}
