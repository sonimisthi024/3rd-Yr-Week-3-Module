import java.util.*;

public class OrderProcessingAnalysis {

    // Merge function
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Recursive Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
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

        // Sort using Merge Sort
        mergeSort(times, 0, N - 1);

        // 1. Display sorted processing times
        for (int t : times) {
            System.out.print(t + " ");
        }
        System.out.println();

        // 2. Find median
        double median;
        if (N % 2 == 1) {
            median = times[N / 2];
        } else {
            median = (times[N / 2 - 1] + times[N / 2]) / 2.0;
        }
        System.out.println("Median: " + median);

        // 3. Count orders greater than median
        int count = 0;
        for (int t : times) {
            if (t > median) count++;
        }
        System.out.println("Orders greater than median: " + count);

        // 4. Difference between fastest and slowest
        int difference = times[N - 1] - times[0];
        System.out.println("Difference (max - min): " + difference);
    }
}
