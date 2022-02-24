package sorting;
// Comb sort + Insertion sort
public class ShellSort
{
	public static int[] shellSort(int[] arr)
	{
		int len = arr.length;
		int distance = len / 2;
		// Like in a comb sort we have a value (2) we're dividing by, distance with each step of outer loop

		for (;distance > 0; distance /= 2)
		{
			for (int i = 0; i < len; i += distance)
			// This is the same algorithm, I used in the insertion sort
			{
				int val = arr[i];
				int j = i;
				while (j - distance >= 0 && val < arr[j - distance])
				{
					Swap.swap(j, j - distance, arr);
					j -= distance;
				}
			}
		}
		return arr;
	}
}
