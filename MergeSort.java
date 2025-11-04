public class MergeSort {
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

        mergeSort(arr, 0, arr.length - 1, steps);

        long end = System.nanoTime();
        return new Result(steps[0], end - start, arr);
    }

    private static void mergeSort(int[] arr, int left, int right, long[] steps) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, steps);
            mergeSort(arr, mid + 1, right, steps);
            merge(arr, left, mid, right, steps);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, long[] steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps[0]++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
