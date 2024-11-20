import java.util.Scanner;

public class linearSearch {
    public static boolean linear(int arr[], int low, int high, int key) {
        while (high > low) {
            if (key == arr[low]) {
                return true;
            } else {
                return (linear(arr, low + 1, high, key));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean x = false;
        n = sc.nextInt();
        int arr[] = new int[n];
        int key;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        key = sc.nextInt();
        x = linear(arr, 0, n, key);
        System.out.println(x);
    }
}
