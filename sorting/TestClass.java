package sorting;

import java.util.Arrays;

public class TestClass
{
    @FunctionalInterface
    interface TestedFunction
    {
        int[] Sort(int[] arr);
    }
    private static int[] getTest(TestedFunction ref, int[] arr)
    {
        return (ref.Sort(arr));
    }
    public static void main(String[] args)
    {
        int[][] arr = {{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        {10, 10, 9, 9, 8, 8, 7, 6, 5, 4, 3, 2, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1},
        {10, 9, 8, 7, 6, 1, 2, 3, 4, 5},
        {}, {1, 2, 3, 4, 3, 3, 5, 6, 7},
        {5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5},
        {10, 9, 8, 7, 6, 5, 6, 7, 8, 9, 10}
        };
        for (int[] x: arr)
            System.out.println(Arrays.toString(getTest(BubbleSort::bubbleSort, x)));
    }
}
