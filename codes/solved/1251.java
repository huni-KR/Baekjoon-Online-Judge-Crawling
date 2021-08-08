import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        String result = "";
        for(int i=0; i<str.length(); i++ )
            result += "z";
        for(int i=1; i<str.length()-1; i++) {
            for(int j=i+1; j<str.length(); j++) {
                String sub1 = str.substring(0, i);
                String sub2 = str.substring(i, j);
                String sub3 = str.substring(j, str.length());
                
                String tmp = "";                
                for(int a=sub1.length()-1; a>=0; a--) 
                    tmp += sub1.charAt(a);              
                for(int a=sub2.length()-1; a>=0; a--) 
                    tmp += sub2.charAt(a);              
                for(int a=sub3.length()-1; a>=0; a--) 
                    tmp += sub3.charAt(a);              
                if( result.compareTo( tmp ) > 0 ) 
                    result = tmp;
            }
        }
        
        System.out.println( result );
    }
}
