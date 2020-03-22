package MinimumSwaps2;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {

    public int minimumSwaps(int[] arr) {
        int element;
        int swapCounter = 0;

        // Decrease array values in order to conform to their index
        decreaseArrayValues(arr);
        Map<Integer, Integer> misfitElements = getElementsOutOfPlace(arr);
        if (misfitElements.isEmpty() || arr.length <= 1)
            return 0;

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                element = misfitElements.get(index);
                misfitElements.put(arr[index], element);
                swap(arr, index, element);
                swapCounter++;
            }
        }
        return swapCounter;
    }

    private Map<Integer, Integer> getElementsOutOfPlace(int[] arr) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i)
                elements.put(arr[i], i);
        }

        return elements;
    }

    private void decreaseArrayValues(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i]--;
    }

    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int saveCur = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = saveCur;
    }

}


