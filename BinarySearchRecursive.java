/*

Programmed by: <Abiso, Wing Hams J.> 
<BSIT 1st Year> <48079>
<Data Structures and Algorithm>
Last Modified: 2026‑09‑10
Version: 1.3
Acknowledgements: Lab activity guide — binary search & recursion concepts;
mid = low + (high‑low)/2 to avoid integer overflow.
*/


import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {

    public static int bSearch(int[] arr, int target, int low, int high) {
      
        if (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("low = %d | high = %d | mid = %d%n", low, high, mid);
        } else {
            System.out.printf("low = %d | high = %d | mid = N/A (low > high)%n", low, high);
        }

       
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        
        if (arr[mid] == target) {
            return mid;
        }
       
        else if (target < arr[mid]) {
            return bSearch(arr, target, low, mid - 1);
        }
        
        else {
            return bSearch(arr, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = input.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        Arrays.sort(numbers);
        System.out.println("\nSorted Array: " + Arrays.toString(numbers));

        System.out.print("\nEnter the number you are looking for: ");
        int target = input.nextInt();

        System.out.println("\n--- Recursion Trace ---");
        int result = bSearch(numbers, target, 0, numbers.length - 1);
        System.out.println("--- End of Trace ---\n");

        if (result != -1) {
            System.out.println("Target Found");
            System.out.println("Index: " + result);
        } else {
            System.out.println("Target not Found");
            System.out.println("Index: -1");
        }

        input.close();
    }
}
