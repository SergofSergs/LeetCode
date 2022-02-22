package sorting;

public class ShakerSort
{
	public static int[] shakerSort(int[] arr)
	{
		int len = arr.length - 1; //Last element of the array (End)
		int ln;
		int i = 0; // First element of the array (Start)

		// Algorithm goes till the indexes meets in the middle
		while (i < len)
		{
			ln = len;
			for (int j = i ;j < len; j++)
			/*First loop goes through the array swapping elements in places
			just like bubble sort */
			{
				if (arr[j] > arr[j + 1])
					Swap.swap(j, j + 1, arr);
				// Decided to write swap method, it changes start and end elements in places
			}
			/*In second, it goes backwards, but does the same job*/
			for (;ln > i; ln--)
			{
				if (arr[ln] < arr[ln - 1])
					Swap.swap(ln, ln - 1, arr);
			}
			i++;
			len--;
		}
		return arr;
	}
}
