package sorting;

import java.util.Arrays;

public class TestClass
{
	@FunctionalInterface
	interface TestedFunction //Trying to figure out how to pass method as a parameter, it's kinda confusing
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
				{10, 9, 8, 7, 6, 5, 6, 7, 8, 9, 10},
				{2,1},
				{123}
		};
		long runTime = System.nanoTime();
		for (int[] x: arr)
		{
			long time = System.nanoTime();
			System.out.print(Arrays.toString(getTest(InsertionSort::insertionSort, x)) + " completed in ");
			System.out.println(System.nanoTime() - time);
		}
		System.out.println("Overall running time is " + (System.nanoTime() - runTime));
	}
}
