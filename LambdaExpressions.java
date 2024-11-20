import java.util.Scanner;

public class LambdaExpressions {
    static void checkEven(int a) {
        if (a % 2 == 0) {
            System.out.println("EVEN");
        } else {
            System.out.println("ODD");
        }
    }

    static void checkPrime(int a) {
        boolean key = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                key = false;
            }
        }
        if (key == true) {
            System.out.println("PRIME");
        } else {
            System.out.println("COMPOSITE");
        }
    }

    static void checkPalindrome(int a) {
        int k = a;
        int b, c = 0, d = 0;
        while (k > 0) {
            k /= 10;
            d++;
        }
        k = a;
        while (k > 0) {
            d--;
            b = k % 10;
            c += b * Math.pow(10, d);
            System.out.println(c);
            k /= 10;
        }
        if (c == a) {
            System.out.println("PALINDROME");
        } else {
            System.out.println("NOT PALINDROME");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        k = sc.nextInt();
        int arr[] = new int[k];
        int ar1[] = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            ar1[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            switch (arr[i]) {
                case 1:
                    checkEven(ar1[i]);
                    break;
                case 2:
                    checkPrime(ar1[i]);
                    break;
                case 3:
                    checkPalindrome(ar1[i]);
                    break;
                default:
                    System.out.println("Not Enterred Correct Key");
                    break;
            }
        }
    }
}
