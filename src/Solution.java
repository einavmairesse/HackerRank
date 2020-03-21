import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void minimumBribes(int[] q) {
        int counter = 0;
        if (q.length <= 1) {
            System.out.println("0");
            return;
        }
        for (int i = 0; i < q.length; i++) {
            if (q[i] - i > 3){
                System.out.println("Too chaotic");
                return;
            }
        }
        for (int i = 0; i < q.length - 1; i++){
            for (int j = 0; j < q.length -i - 1; j++) {
                if (q[j] > q[j + 1]) {
                    q = swap(q, j, j + 1);
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    static int[] swap(int[] arr, int left, int right){
        int saveCur = arr[left];
        arr[left]= arr[right];
        arr[right] = saveCur;
        return arr;
    }
    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,5,3,7,8,6,4};
        minimumBribes(arr);

    }

}

