import java.util.*;

public class DataSorter {

    private static Scanner sc = new Scanner(System.in);
    private static int[] numbers = new int[0];

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = getValidInt();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandomNumbers();
                case 3 -> runBubbleSort();
                case 4 -> runMergeSort();
                case 5 -> runQuickSort();
                case 6 -> compareAll();
                case 7 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    private static void enterNumbers() {
        System.out.print("Enter numbers separated by spaces: ");
        String[] input = sc.nextLine().trim().split("\s+");
        numbers = new int[input.length];
        for (int i = 0; i < input.length; i++)
            numbers[i] = Integer.parseInt(input[i]);
        System.out.println("Numbers stored: " + Arrays.toString(numbers));
    }

    private static void generateRandomNumbers() {
        System.out.print("How many random numbers? ");
        int n = getValidInt();
        Random rand = new Random();
        numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = rand.nextInt(100);
        System.out.println("Generated: " + Arrays.toString(numbers));
    }

    private static void runBubbleSort() {
        checkData();
        BubbleSort.Result result = BubbleSort.sort(numbers);
        System.out.println("Bubble Sort Result: " + Arrays.toString(result.sorted));
        System.out.println("Time: " + result.timeNano + " ns | Steps: " + result.steps);
    }

    private static void runMergeSort() {
        checkData();
        MergeSort.Result result = MergeSort.sort(numbers);
        System.out.println("Merge Sort Result: " + Arrays.toString(result.sorted));
        System.out.println("Time: " + result.timeNano + " ns | Steps: " + result.steps);
    }

    private static void runQuickSort() {
        checkData();
        QuickSort.Result result = QuickSort.sort(numbers);
        System.out.println("Quick Sort Result: " + Arrays.toString(result.sorted));
        System.out.println("Time: " + result.timeNano + " ns | Steps: " + result.steps);
    }

    private static void compareAll() {
        checkData();
        BubbleSort.Result b = BubbleSort.sort(numbers);
        MergeSort.Result m = MergeSort.sort(numbers);
        QuickSort.Result q = QuickSort.sort(numbers);

        System.out.println("\n--- Comparison Table ---");
        System.out.printf("%-15s %-20s %-15s%n", "Algorithm", "Time (ns)", "Steps");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-15s %-20d %-15d%n", "Bubble Sort", b.timeNano, b.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Merge Sort", m.timeNano, m.steps);
        System.out.printf("%-15s %-20d %-15d%n", "Quick Sort", q.timeNano, q.steps);
    }

    private static void checkData() {
        if (numbers.length == 0) {
            System.out.println("No data. Please input or generate numbers first!");
            throw new IllegalStateException();
        }
    }

    private static int getValidInt() {
        while (true) {
            try {
                String input = sc.nextLine();
                return Integer.parseInt(input.trim());
            } catch (Exception e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }
}

