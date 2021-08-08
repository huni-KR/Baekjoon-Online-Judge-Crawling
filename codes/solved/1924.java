import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);        
        int month = kb.nextInt();
        int day = kb.nextInt();     
        kb.close();
        
        int[] mon = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
        String[] str = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        
        for(int i=0; i<month; i++)
            day += mon[i];
        
        System.out.println( str[ day % 7 ] );
    }
}
