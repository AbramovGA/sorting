package ru.mail.polis.sort;

/**
 * Created by german on 27.11.16.
 */
public class OrderStatistic {
    public static int findOrderStatistic(int[] array, int k) {
        int left = 0, right = array.length-1;
        int mid=0;
        while (right>left) {
            mid = partition(array, left, right);
            if (mid == k) {
                return array[mid];
            }
            else if (k < mid) {
                right = mid-1;
            }
            else {
                left = mid + 1;
            }
        }
        return array[mid];
    }

    static int partition(int[] a, int l, int r) {
        int v = a[(l + r) / 2];
        int i = l;
        int j = r;
        if(r==1)
            return 0;
        while (i <= j) {
            while (a[i] < v)
                i++;
            while (a[j] > v)
                j--;
            if (i <= j)
                Helper.swap(a,i++,j--);
        }
        return j;
    }

    public static void main(String[] args) {
        int a[]={1, 2, 3, 4};
        findOrderStatistic(a,2);
    }
}


