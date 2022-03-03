public class BubbleSort
{
    public static int[] bubbleSort(int[] arr)
    {
        int len = arr.length - 1; // Element's count
        int temp; // To use for a swap

        for (int i = 0; i < len; i++) //Start loop for each element
        {
            for (int j = 0; j < len - i; j++)
                //Inner loop starting from first position to (len - 1)
                //It reduces with each new outer loop, cause the biggest element will be on the last position
            {
                if (arr[j] > arr[j + 1]) //Swap
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
