public class QuickSort {
    public static class Result {
        public long steps;
        public long timeNano;
        public int[] sorted;

        public Result(long steps, long timeNano, int[] sorted) {
            this.steps = steps;
            this.timeNano = timeNano;
            this.sorted = sorted;
        }
    }

    public static Result sort(int[] input) {
        int[] arr = input.clone();
        long[] steps = {0};
        long start = System.nanoTime();

        quickSort(arr, 0, arr.length - 1, steps);

        long end = System.nanoTime();
        return new Result(steps[0], end - start, arr);
    }

    private static void quickSort(int[] arr, int low, int high, long[] steps) {
        if (low < high) {
            int pi = partition(arr, low, high, steps);
            quickSort(arr, low, pi - 1, steps);
            quickSort(arr, pi + 1, high, steps);
        }
    }

    private static int partition(int[] arr, int low, int high, long[] steps) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps[0]++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
