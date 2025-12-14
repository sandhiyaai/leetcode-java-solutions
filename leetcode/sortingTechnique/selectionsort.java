/*

Algorithm: Selection Sort  
Time Complexity: O(n²)  
Space Complexity: O(1)  
Sorting Type: In-place, Comparison-based

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 2; i++) {
            int minimum = i;
            for (int j = i+1; j <= n - 1; j++) {
                if (arr[j] < arr[minimum]) minimum = j;
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;

        }
    }
    public static void main(String[] args) throws java.lang.Exception
    {
        int[] arr = {
            55,
            7,
            12,
            6,
            10,
            4,
            2,
            4,
            1
        };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
