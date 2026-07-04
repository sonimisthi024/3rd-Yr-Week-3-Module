import java.util.*;

public class EmergencyResponseAnalysis {

    // Heapify function to maintain max-heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;       // root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = sc.nextInt();
        }

        // Sort using Heap Sort
        heapSort(times);

        // 1. Display sorted response times
        System.out.print("Sorted response times: ");
        for (int t : times) {
            System.out.print(t + " ");
        }
        System.out.println();

        // 2. Fastest response time
        int fastest = times[0];
        System.out.println("Fastest response time: " + fastest);

        // 3. Slowest response time
        int slowest = times[N - 1];
        System.out.println("Slowest response time: " + slowest);

        // 4. Average response time
        long sum = 0;
        for (int t : times) sum += t;
        double average = sum / (double) N;
        System.out.println("Average response time: " + average);

        // 5. Count cases faster than average
        int countFaster = 0;
        for (int t : times) {
            if (t < average) countFaster++;
        }
        System.out.println("Cases faster than average: " + countFaster);

        // 6. Percentage of cases faster than average
        double percentage = (countFaster * 100.0) / N;
        System.out.println("Percentage faster than average: " + percentage + "%");
    }
}
