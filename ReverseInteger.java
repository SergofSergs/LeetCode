/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside 
the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
*/
public class ReverseInteger
{

	public int reverse(int x)
	{
		int n = 0;
		boolean negative = false;

		if (x > 2147483647 || x < -2147483648) // Программа способна сравнить переполненные значения с данными
			return (0);
		if (x < 0) // Программа работает только с положительными
		{
			if (x == -2147483648) // Если умножить данное (ещё валидное) число на 1 произойдёт переполнение и баг
				x += 1;
			x *= -1;
			negative = true;
		}
		int len = digitNumber(x); // Количество знаков в числе
		for (int i = len; i != 0; i--)
		{
			if (n + (x % 10) * Math.pow(10, i - 1) > 2147483647) // Выкинуть 0 в случае переполнения
				return (0);
			n += (x % 10) * Math.pow(10, i - 1);
			x /= 10;
		}
		if (negative)
			n *= -1;
        return (n);
    }

	public int digitNumber(int x)
	{
		int i;

		for (i = 0 ;x != 0; x /=10)
			i++;
		return (i);
	}
}

class Test // Меняй параметр и используй дебагер, если не понятно
{
	public static void main(String[] args)
	{
		ReverseInteger go = new ReverseInteger();
		System.out.println(go.reverse(147483647));
	}
}

/*
Результат супер говно:
Runtime: 4 ms, faster than 19.44% of Java online submissions for Reverse Integer.
Memory Usage: 41.2 MB, less than 5.41% of Java online submissions for Reverse Integer.
*/