public class TwoSum {
    public static int[] solution(int[] numbs, int target)
    {
        int[] arr;
        int flag = 0;
        int j;

        arr = new int[2]; 
        for(int i = 0; i < numbs.length; i++)
        {
            if (flag == 1)
                break;
            j = -1;
            while (++j < numbs.length)
            {
                if (flag == 1)
                    break;
                if (j == i)
                    continue;
                if (numbs[i] + numbs[j] == target)
                {
                    arr[0] = i;
                    arr[1] = j;
                    flag = 1;
                }
            }
        }
        return arr; 
    }
	public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5};
        int[] rra = solution(arr, 6);
        System.out.printf("[%d, %d]%n", rra[0], rra[1]);
    }
}
