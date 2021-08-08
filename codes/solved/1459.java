import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine(), " " ); 
        long homeX = Long.parseLong( st.nextToken() );
        long homeY = Long.parseLong( st.nextToken() );
        long walk = Long.parseLong( st.nextToken() );
        long across = Long.parseLong( st.nextToken() );
                
        long result = 0;
        if( walk * 2 < across ) {
            result += walk * ( homeX + homeY );
        }
        else {
            long pointX, pointY;
            if( homeX < homeY ) {
                pointX = 0;
                pointY = homeY - homeX;
            }
            else {
                pointX = homeX - homeY;
                pointY = 0;         
            }
            
            result += ( Math.max(homeX, homeY) - Math.max(pointX, pointY) ) * across;
            
            if( walk < across ) {
                result += ( pointX + pointY )  * walk;  
            }
            else {
                if( ( pointX + pointY ) % 2 == 0 ) 
                    result += ( pointX + pointY ) * across;
                
                else
                    result += ( pointX + pointY - 1) * across + walk;       
            }       
        }
        System.out.println( result );       
    }
}
