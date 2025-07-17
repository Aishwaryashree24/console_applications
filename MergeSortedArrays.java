import java.util.*;

/**
 * This program merges two integer arrays into one sorted array without duplicates.
 * 
 * Key Features:
 * - Accepts two arrays from the user (possibly in descending or ascending order).
 * - Automatically reverses arrays if they are in descending order.
 * - Merges them into a single sorted array while removing duplicate elements.
 * - Uses -9999 as a placeholder to filter unfilled entries in the final output.
 */
 
public class MergeSortedArrays {

    public static void reverse(int[] arr, int size){
        int left = 0, right = (size - 1);
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of first array: ");
        int f = sc.nextInt();
        System.out.println("Enter the first array");
        int[] a = new int[f];
        for (int i = 0; i < f; i++) {
            a[i] = sc.nextInt();
        }
        if (f > 1 && a[f - 1] < a[0])
            reverse(a, f);

        System.out.print("Enter the size of second array: ");
        int s = sc.nextInt();
        System.out.println("Enter the second array");
        int[] b = new int[s];
        for (int i = 0; i < s; i++) {
            b[i] = sc.nextInt();
        }
        if (s > 1 && b[s - 1] < b[0])
            reverse(b, s);

        int[] merged = new int[f + s];
        for(int i=0;i<(f+s);i++){
            merged[i] = -9999;
        }
        int i = 0, j = 0, k = 0;
        while (i < f && j < s) {
            if (a[i] == b[j]) {
                if (k == 0 || merged[k - 1] != a[i]) {
                    merged[k++] = a[i];
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (k == 0 || merged[k - 1] != a[i]) {
                    merged[k++] = a[i];
                }
                i++;
            } else if (a[i] > b[j]) {
                if (k == 0 || merged[k - 1] != b[j]) {
                    merged[k++] = b[j];
                }
                j++;
            }
        }

        while (i < f) {
            if (k == 0 || merged[k - 1] != a[i]) {
                merged[k++] = a[i];
            }
            i++;
        }
        while (j < s) {
            if (k == 0 || merged[k - 1] != b[j]) {
                merged[k++] = b[j];
            }
            j++;
        }

        for (int num : merged) {
            if(num!=-9999) System.out.print(num + " ");
        }

    }

}
