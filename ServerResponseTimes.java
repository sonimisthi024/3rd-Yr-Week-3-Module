import java.util.*;

public class ServerResponseTimes {

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing last element as pivot
        int i = low - 1;       // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort recursive function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int[] responseTimes = new int[N];
        for (int i = 0; i < N; i++) {
            responseTimes[i] = sc.nextInt();
        }

        // Sort using Quick Sort
        quickSort(responseTimes, 0, N - 1);

        // Output sorted response times
        for (int time : responseTimes) {
            System.out.print(time + " ");
        }
    }
}

