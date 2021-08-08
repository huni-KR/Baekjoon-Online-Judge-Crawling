import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.close();
        
        int[] dp = new int[1000001];        
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3 ; i<=n; i++) 
            dp[i] = ( dp[i-1] + dp[i-2] ) % 15746;
                
        System.out.println( dp[n] );        
    }
}
