import java.util.ArrayList;
import java.util.Arrays;

public class SortedIndex {
    public static void main (String[] args) {
        System.out.println("Hello");
        int[] testArray = new int[]{23,34,15,17,9};
        int[] sortedArray = getSortedArray(testArray);
        System.out.println("Original array is ");
        displayArray(testArray);
        System.out.println("Sorted array is ");
        displayArray(sortedArray);
        System.out.println("Sorted array index is ");
        displayArray(getIndexfromSorted(testArray, sortedArray));
    }

    public static int[] getSortedArray(int[] originalArray) {
        int arrayLength = originalArray.length;
        int[] copyArray = originalArray.clone();
        Arrays.sort(copyArray);
        return copyArray;
    }

    public static int[] getIndexfromSorted (int[] originalArray, int[] sortedArray) {
        int[] indexes = new int[sortedArray.length];
        for (int i = 0; i < sortedArray.length; i++) {
            int entry = sortedArray[i];
            int position = indexOf(originalArray, entry);
            indexes[i] = position;
        }
        return indexes;
    }
    public static int indexOf(int[] array, int entry) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == entry) {
                return i;
            }
        }
        return -1;
    }
    public static void displayArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
        System.out.println("");
    }
}
