package ru.mail.polis.sort;

/**
 * Created by german on 15.11.16.
 */
public class InsertionSort {
    public static int[] sort(int []a) {
        int i;
        int j;
        for (i=1;i<a.length;i++) {
            j = i - 1;
            while (j >= 0 && a[j] > a[j + 1]) {
                Helper.swap(a,j,j+1);
                j--;
            }
        }
        return a;
    }

}
