public class Main {

    public static void main(String[] args) {
        int[] list = {4, 2, 6, 1, 9, 2, 3, 2};
        System.out.print("Original list: ");
        printIntegerList(list);
        System.out.print("InsertionSort: ");
        printIntegerList(insertionSort(list));
        System.out.print("InsertionSort Descending: ");
        printIntegerList(insertionSortDescending(list));
        System.out.print("MergeSort: ");
        mergeSort(list);
        printIntegerList(list);
        int[] list2 = {5, 1, 8, 3, 9, 2};
        System.out.print("Original list: ");
        printIntegerList(list2);
        System.out.println("SelectionSort: ");
        printIntegerList(selectionSort(list2));

        int[] list3 = {5, 1, 8, 3, 9, 2};
        System.out.print("Original list: ");
        printIntegerList(list3);
        System.out.print("BubbleSort: ");
        bubbleSort(list3);
        printIntegerList(list3);

        int[] list4 = {5, 1, 8, 3, 9, 2};
        System.out.print("Original list: ");
        printIntegerList(list4);
        System.out.println("QuickSort: ");
        quickSort(list4);
        printIntegerList(list4);
    }

    public static void printIntegerList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (i < list.length - 1) {
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
                list[i + 1] = list[i];
                i--;
            }
            list[i + 1] = key;
        }
        return list;
    }

    protected static int[] insertionSortDescending(int[] list) {
        for (int j = 1; j < list.length; j++) {
            int key = list[j];
            int i = j - 1;
            while (i > -1 && list[i] < key) {
                list[i + 1] = list[i];
                i--;
            }
            list[i + 1] = key;
        }
        return list;
    }

    protected static void mergeSort(int[] list) {
        int helper[] = new int[list.length];
//        return mergeSortHelper(list, 0, list.length-1, helper);
        mergeSortHelper(list, 0, list.length - 1, helper);
    }

    private static void mergeSortHelper(int[] list, int left, int right, int[] helper) {
        int i, j, k;
        if (right > left) {
            // zu sortierendes Feld teilen
            int middle = (left + right) / 2;
            // Teilfelder sortieren
            mergeSortHelper(list, left, middle, helper);
            mergeSortHelper(list, middle + 1, right, helper);
            // Hilfsfeld aufbauen
            for (k = left; k <= middle; k++) helper[k] = list[k];
            for (k = middle; k < right; k++) helper[right + middle - k] = list[k + 1];
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
//        return list;
    }

    protected static int[] selectionSort(int[] list) {
        int marker = list.length - 1;
        while (marker > 0) {
            // bestimme größtes Element
            int max = 0;
            for (int i = 1; i <= marker; i++) {
                if (list[i] > list[max]) {
                    max = i;
                }
            }
            swap(list, marker, max);
            marker--;
        }
        return list;
    }

    private static void swap(int[] list, int index1, int index2) {
        int tmp = list[index1];
        list[index1] = list[index2];
        list[index2] = tmp;
//        return list;
    }

    private static void bubbleSort(int[] list) {
        boolean swapped;
        do {
            swapped = false;

            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i+1]) {
                    // Elemente vertauschen
                    swap(list, i, i + 1);
                    swapped = true;
                }
            }
            // solange Vertauschung auftritt
        } while (swapped);
    }

    private static void quickSort(int[] list) {
        qsort(list, 0, list.length -1);
    }

    // Hilfsmethode zum rekursiven Sortieren
    private static void qsort(int[] list, int u, int o) {
        // Pivot-Element bestimmen
        int p = (u + o) / 2;
        if (o > u) {
            // Feld zerlegen
            int pn = partition(list, u, o, p);
            // und Partitionen sortieren
            qsort(list, u, pn - 1);
            qsort(list, pn + 1, o);
        }
    }

    private static int partition(int[] list, int u, int o, int p) {
        int pn = u;
        int pv = list[p];

        // Pivot-Element an das Ende verschieben
        swap(list, p, o);
        for (int i = u; i < o; i++) {
            if (list[i] <= pv) {
                swap(list, pn++, i);
            }
        }
        // Pivot-Element an richtige Position kopieren
        swap(list, o, pn);
        // neue Pivot-Position zurückgeben
        return pn;
    }


}
