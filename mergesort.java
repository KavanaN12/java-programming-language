import java.util.Scanner;

public class mergesort {

    public static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = 0, ar2[] = new int[8];
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                ar2[k] = L[i];
                i++;
            } else {
                ar2[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            ar2[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            ar2[k] = R[j];
            k++;
            j++;
        }

        for (i = 0; i < k; i++) {
            arr[low + i] = ar2[i];
        }
    }

    public static void sorting(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sorting(arr, low, mid);
            sorting(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    };

    public static void main(String[] args) {
        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter  the  elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        sorting(arr, 0, (arr.length - 1));
        System.out.println("Array after sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
