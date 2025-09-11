public class sort {
    // Bubble sort
    public static void bubble_sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection sort
    public static void selection_sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            // swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion sort
    public static void insertion_sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    // Merge sort (Divide and Conquer)
    public static void divide(int arr[], int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }

    public static void conquer(int arr[], int start, int mid, int end) {
        int merged[] = new int[end - start + 1];
        int idx1 = start, idx2 = mid + 1, x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= end) {
            merged[x++] = arr[idx2++];
        }
        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }

    }

    // Quick sort (pivot & partition)
    public static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
    public static void quicksort(int arr[], int start, int end) {
        if (start < end) {
            int pivotidx = partition(arr, start, end);
            quicksort(arr, start, pivotidx-1);
            quicksort(arr, pivotidx + 1, end);
        }
    }

    public static void main(String arg[]) {
        int arr[] = { 7, 8, 4, 1, 2, 3, 5, 6 };
        int n = arr.length;
        System.out.println("Before sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // bubble_sort(arr);
        // selection_sort(arr);
        // insertion_sort(arr);
        //divide(arr, 0, n - 1);
        quicksort(arr, 0, n-1);
        System.out.println("After sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}