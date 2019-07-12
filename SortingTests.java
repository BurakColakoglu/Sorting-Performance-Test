import java.util.Random;

public class SortingTests{
    public static void insert(int[] x, int i) {
        // place x[i] in its proper place among sorted values x[0],
        // x[1]...x[i-1]
        int temp = x[i]; // save the value
        int j = i - 1;
        while (j >= 0 && temp < x[j]) { // determine where to place temp
            x[j + 1] = x[j]; // shift right
            j--;
        }
        x[j + 1] = temp; // place temp (x[i]) in its correct position
    }

    public static void insertionSort(int[] x, int n) {
        // n is the number of data stored in array x
        for (int i = 1; i < n; i++)
            insert(x, i);
    }

    public  static void fillArray(int[] x, int n){
        Random r= new Random();
        for (int i = 1; i < n; i++)
            x[i]=r.nextInt(1000);
    }
    public static void selectionSort(int arr[],int n) {
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void bubbleSort(int arr[],int n) {
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    public static void sortingExperiments(int n){
        int []x=new int[n];
        fillArray(x,n); //mathod fills the array with random values in the range 0-1000

        StopWatch sw = new StopWatch();
        System.out.print("\nSorting Algorithm Tests for "+ n+ " items\n\n");
        //PART 1 - InsertionSort
        sw.start();
        insertionSort(x,n);
        sw.stop();
        System.out.println("Insertion sort time:\t"+sw.elapsedTimeMillis());

        fillArray(x,n);//fill aganin
        //PART 2 - Insertion Sort
        sw.start();
        selectionSort(x,n);
        sw.stop();
        System.out.println("Selection sort time:\t"+sw.elapsedTimeMillis());

        fillArray(x,n);//fill aganin
        //PART 3 - Bubble Sort
        sw.start();
        bubbleSort(x,n);
        sw.stop();
        System.out.println("Bubble sort time:\t\t"+sw.elapsedTimeMillis());
    }

    public static void main(String[] args) {
        sortingExperiments(1000);
        sortingExperiments(2000);
		sortingExperiments(5000);
		sortingExperiments(10000);
		sortingExperiments(50000);
		sortingExperiments(100000);
        sortingExperiments(500000);


    }
}
