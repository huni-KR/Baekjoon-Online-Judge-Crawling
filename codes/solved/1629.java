import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int A = kb.nextInt();
        int B = kb.nextInt();
        int C = kb.nextInt();

        kb.close();

        System.out.println( cal(A, B, C) );
    }

    public static long cal(int i, int j, int k) {
        if (j == 0) 
            return 1;

        long n = cal(i, j / 2, k);
        long temp = n * n % k;

        if (j % 2 == 0) 
            return temp;

        else 
            return i * temp % k;
    }
}
