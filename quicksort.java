import java.util.List;
import java.util.Scanner;

public class quicksort {
    public static void swap(int arr[], int a, int b) {
        int t;
        t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static int quicksort(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void sorting(int arr[], int low, int high) {
        if (low < high) {
            int pi = quicksort(arr, low, high);
            sorting(arr, low, pi - 1);
            sorting(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100];
        System.out.println("Enter  the  elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        sorting(arr, 0, (n - 1));
        System.out.println("Array after sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
