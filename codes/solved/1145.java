import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        br.close();
        
        int[] arr = new int[5];
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt( token[i] );
        Arrays.sort(arr);
        
        int result = arr[2];
        while( true ) {
            int count = 0;
            
            for(int i=0; i<arr.length; i++)
                if( result % arr[i] == 0 )
                    count++;                    
            if( count >= 3 )
                break;
            result++;
        }       
        System.out.println( result );       
    }
}
