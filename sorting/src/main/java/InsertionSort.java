//This algorithm goes through the array, and insert the smaller element before bigger ones

public class InsertionSort
{
	public static int[] insertionSort(int[] arr)
	{
		int len = arr.length;

		for(int i = 1; i < len; i++)
		{
			int val = arr[i]; // Remember the value we are swapping
			int j = i;
			while (j - 1 >= 0 && val < arr[j - 1])
			// Swapping till the val gets on the right position
			{
				Swap.swap(j, j - 1, arr);
				j--;
			}
		}
		return arr;
	}
}
//It runs slightly faster than my previous algorithms(bubble, shaker, comb)
