public class BubbleSort {
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
        long steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long end = System.nanoTime();
        return new Result(steps, end - start, arr);
    }
}
