public class primeCheck {
    static void checkPrime(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j < key; j++) {
                if (arr[i] % j == 0 && arr[i] != j) {
                    arr[i] = 0;
                }
            }
            if (arr[i] != 0) {
                for (int k = 0; k <= i; k++) {
                    if (arr[k] != 0 && arr[k] != 1) {
                        System.out.print(arr[k] + " ");
                    }
                }
                System.out.println();
            }

        }
    }

    static int sort(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4, 5 };
        int key = sort(arr);
        checkPrime(arr, key);
    }
}
