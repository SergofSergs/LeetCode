public class Swap
{
	public static void swap(int start, int end, int[] arr)
	{
		int temp;

		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
}
