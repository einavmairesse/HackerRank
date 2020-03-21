package NewYearChaos;

public class NewYearChaos {
    void getMinimumBribes(int[] lineArray) {
        if (lineArray.length <= 1) {
            System.out.println("0");
            return;
        }

        if (isTooChaotic(lineArray)) {
            System.out.println("Too chaotic");
            return;
        }

        int bribesCounter = getBribesCounter(lineArray);
        System.out.println(bribesCounter);
    }

    private int getBribesCounter(int[] lineArray) {
        int bribesCounter = 0;

        for (int i = 0; i < lineArray.length - 1; i++){
            for (int j = 0; j < lineArray.length -i - 1; j++) {
                if (lineArray[j] > lineArray[j + 1]) {
                    swap(lineArray, j, j + 1);
                    bribesCounter++;
                }
            }
        }
        return bribesCounter;
    }

    private boolean isTooChaotic(int[] lineArray) {
        for (int i = 0; i < lineArray.length; i++) {
            if (lineArray[i] - i > 3) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] arr, int left, int right) {
        int saveCur = arr[left];
        arr[left]= arr[right];
        arr[right] = saveCur;
    }
}

