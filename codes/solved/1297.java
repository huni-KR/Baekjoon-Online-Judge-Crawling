import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        double across = kb.nextInt();
        double rateHeight = kb.nextInt();
        double rateWidth = kb.nextInt();        
        kb.close();
        
        double result = Math.sqrt( Math.pow(across, 2) / ( Math.pow( rateHeight, 2) + Math.pow( , 2) ) );
        
        System.out.println( (int) (rateHeight * result) + " " + (int) (rateWidth * result) );
    }
}
