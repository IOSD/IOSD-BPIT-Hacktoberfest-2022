package reversearray;

import java.util.Arrays;
import java.util.List;

public class ReverseArray {
    // Function to reverse arr[] from start to end
    static void reverseArray(int arr[], int start, int end)
    {
        int temp;

        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int arr[],
                           int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }


    // Driver code
    public static void main(String args[]) {

        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, arr.length);
        reverseArray(arr, 0, 5);
        System.out.print("Reversed array is \n");
        printArray(arr, arr.length);


    }
}

// This code is contributed by @parvezi123