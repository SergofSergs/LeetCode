package src;
import java.util.Scanner; // Для считывания ввода

public class MedianOfTwoSortedArrays {
	
	public static int[] MergeArrays(int[] nums1, int[] nums2) // Слепление двух массивов в один
	{
		int[] arr = new int[nums1.length + nums2.length];
		int j = 0;
		for (int i = 0; i < nums1.length; i++)
		{
			arr[j] = nums1[i];
			j++;
		}
		for (int i = 0; i < nums2.length; i++)
		{
			arr[j] = nums2[i];
			j++;
		}
		return (arr);
	}
	public static void QuickSort(int[] source, int leftBorder, int rightBorder) 
	{
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            QuickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            QuickSort(source, leftBorder, rightMarker);
        }
	}
	public static int[] Sort(int[] arr) // Рекурсивный алгоритм 
	{
		int start = 0;
		int end = arr.length - 1;
		QuickSort(arr, start, end);
		return (arr);
	}
	public static double FindMedian(int[] arr) // Нахождение медианы
	{
		double med;

		if (arr.length % 2 == 1)
			med = (double)arr[(arr.length / 2)];
		else
			med = ((double)arr[(arr.length / 2)] + (double)arr[(arr.length / 2 - 1)]) / 2;
		return (med);
	}
	public static int[] FillArray(int size, Scanner input) // Ручное заполнение массивов
	{
		int[] arr;

		arr = new int[size];
		for (int i = 0; i < size; i++)
		{
			System.out.printf("%d elements to go\n", (size - i));
			arr[i] = input.nextInt();
		}
		return (arr);
	}
	public static void main(String[] args) // Сборка решения
	{
		int[] arr;
		int[] nums1;
		int[] nums2;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the lenght of the first array");
		int tmp = input.nextInt();
		nums1 = FillArray(tmp, input);
		System.out.println("Enter the lenght of the second array");
		tmp = input.nextInt();
		nums2 = FillArray(tmp, input);
		arr = MergeArrays(nums1, nums2);
		arr = Sort(arr);
		System.out.println(FindMedian(arr));
		input.close();
	}
}
