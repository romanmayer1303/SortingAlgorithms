public class Main {

    public static void main(String[] args) {
        int[] list = {4, 2, 6, 1, 9, 2, 3, 2};
        printIntegerList(list);
        printIntegerList(insertionSort(list));
        printIntegerList(insertionSortDescending(list));
        printIntegerList(mergeSort(list));
    }

    public static void printIntegerList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (i < list.length-1) {
                System.out.printf("%s,", list[i]);
            } else {
                System.out.printf("%s%n", list[i]);
            }
        }
    }

    protected static int[] insertionSort(int[] list) {
        for (int j = 1; j < list.length; j++) {
            int key = list[j];
            int i = j - 1;
            while (i > -1 && list[i] > key) {
                list[i+1] = list[i];
                i--;
            }
            list[i+1] = key;
        }
        return list;
    }

    protected  static int[] insertionSortDescending(int[] list) {
        for (int j = 1; j < list.length; j++) {
            int key = list[j];
            int i = j - 1;
            while (i > -1 && list[i] < key) {
                list[i+1] = list[i];
                i--;
            }
            list[i+1] = key;
        }
        return list;
    }

    protected static int[] mergeSort(int[] list) {
        int helper[] = new int[list.length];
        return mergeSortHelper(list, 0, list.length-1, helper);
    }

    private static int[] mergeSortHelper(int[] list, int left, int right, int[] helper) {
        int i, j, k;
        if (right > left) {
            // zu sortierendes Feld teilen
            int middle = (left + right) / 2;
            // Teilfelder sortieren
            mergeSortHelper(list, left, middle, helper);
            mergeSortHelper(list, middle+1, right, helper);
            // Hilfsfeld aufbauen
            for (k = left; k <= middle; k++) helper[k] = list[k];
            for (k = middle; k < right; k++) helper[right + middle - k] = list[k+1];
            // Ergebnisse mergen über Hilfsfeld
            i = left;
            j = right;
            for (k = left; k <= right; k++) {
                if (helper[i] < helper[j]) {
                    list[k] = helper[i++];
                } else {
                    list[k] = helper[j--];
                }
            }
        }
        return list;
    }

    protected static int[] selectionSort(int[] list) {
        int marker = list.length - 1;
        while (marker >= 0) {
            // bestimme größtes Element
        }
        return list;
    }
}
