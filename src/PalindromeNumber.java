package src;

public class PalindromeNumber
{
	public boolean isPalindrome(int x)
	{
		int len;
		
        if (x < 0)
			return (false);
		len = digitNumber(x);
		return (isIt(x, len));
    }
	
	private int digitNumber(int x)
	{
		int i = 0;

		for (i = 0 ;x != 0; x /=10)
			i++;
		return (i);
	}

	private boolean isIt(int x, int len) // C каждым входом в цикл отрезается переднее и заднее число
	{
		if (len == 1 || len == 0)
			return true;
		len -= 1;
		int start = x / (int)(Math.pow(10, len));
		int end = x % 10;
		x = (x - (int)Math.pow(10, len) * start) / 10;
		if (start == end && isIt(x, len - 1))
			return true;
		return false;
	}
}

class PalNumTest
{
	public static void main (String[] args)
	{
		PalindromeNumber go = new PalindromeNumber();
		System.out.println(go.isPalindrome(1234554321));
	}
}