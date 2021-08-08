import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
                
        int a = kb.nextInt();
        int b = kb.nextInt();
        
        kb.close();
        
        a--;
        b--;
        
        int[] grid = new int[1000];

        int k=0;
        int num = 1;
        int count = 0;
        while( k != 1000 ) {
            grid[k] = num;
            count++;
            
            if(num == count) {
                count = 0;
                num++;
            }           
            k++;            
        }       
        
        int sum = 0;
        for(int i=a; i<=b; i++)
            sum += grid[i];
        
        System.out.println(sum);    
    }
}
