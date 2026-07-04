import java.util.*;

public class TradeValueAnalysis {

    // Partition function for descending order
    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) { // note: >= for descending
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort recursive function
    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        long[] trades = new long[N];
        for (int i = 0; i < N; i++) {
            trades[i] = sc.nextLong();
        }

        // Sort using Quick Sort (descending)
        quickSort(trades, 0, N - 1);

        // 1. Display sorted trade values
        for (long val : trades) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 2. Top 5 highest trade values
        System.out.print("Top 5 values: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(trades[i] + " ");
        }
        System.out.println();

        // 3. Average of Top 5 values
        long sumTop5 = 0;
        for (int i = 0; i < 5; i++) {
            sumTop5 += trades[i];
        }
        double avgTop5 = sumTop5 / 5.0;
        System.out.println("Average of Top 5: " + avgTop5);

        // 4. Count values greater than overall average
        long sumAll = 0;
        for (long val : trades) {
            sumAll += val;
        }
        double overallAvg = sumAll / (double) N;

        int countGreater = 0;
        for (long val : trades) {
            if (val > overallAvg) countGreater++;
        }
        System.out.println("Count greater than overall average: " + countGreater);
    }
}

