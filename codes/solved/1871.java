import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        
        int n = Integer.parseInt( br.readLine() );
        
        for(int i=0; i<n; i++) {
            String[] token = br.readLine().split("-");
            int sumAlpa = 0;
            int sumNum = Integer.parseInt( token[1] );
            
            for(int j=0; j<token[0].length(); j++) 
                sumAlpa += ( (int)token[0].charAt(j) - 'A' ) * Math.pow(26, token[0].length() -   );
            
            int check = Math.abs( sumAlpa - sumNum );
            
            if( check <= 100 )
                System.out.println( "nice" );
            else
                System.out.println( "not nice" );
        }       
    }
}
