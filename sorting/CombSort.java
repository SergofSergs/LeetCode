package sorting;
/*
The main feature of this algorithm in reducing the distance (step)
between indexes till it's gone (at step == 1, it's straight the bubble sort)
each "while" loop the step is being divided by the factor
*/
public class CombSort
{
	public static int[] combSort(int[] arr)
	{
		double factor = 1.247; // Optimal factor value
		int len = arr.length - 1;
		double step = len; // From first and last

		while ((int)step != 0)
		{
			for (int i = 0; i < len; i++)
			{
				if ((i + (int)step) > len) // To not get an exception
					break;
				if (arr[i] > arr[(int)step + i]) // Just swapping
					Swap.swap(i, i + (int)step, arr);
			}
			step /= factor;
		}
		return arr;
	}
}
/* In my case, with not that many test cases,
it's running slower than bubble (and shaker) sort algorithm for about a 3ms
* */