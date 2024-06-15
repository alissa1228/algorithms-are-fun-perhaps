package ltc.arr;

import java.io.*;
import java.util.Arrays;

/**
 * 2433. Find The Original Array of Prefix Xor
 */
public class Q2433 {
    public static void main(String[] args) throws IOException {
        int[] pref = new int[] {5,2,0,3,1};
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        int tmp = pref[0];
        for (int x = 1; x < pref.length; x++) {
            arr[x] = tmp ^ pref[x];
            tmp = tmp ^ arr[x];
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
