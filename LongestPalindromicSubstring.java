// Given a string s, return the longest palindromic substring in s

class Coordinates // Создан для удобного хранения индексов строки
{
	int a;
	int b;
	Coordinates(){this.a = 0; this.b = 0;}
	Coordinates(int a, int b){this.a = a; this.b = b;}
}

public class LongestPalindromicSubstring 
{
	/* Начало программы, здесь проверяются некоторые элементарные входные строки
	и выполняется вход в главный алгоритм */
	public String LongestPalindrome(String s) 
	{
		Coordinates xy;

        if (s.length() == 1)
			return (s);
		else if (s.length() == 2 && s.charAt(0) != s.charAt(1))
			return (s.substring(0, 1));
		else
		{
			xy = FindPalindrome(s);
			return (s.substring(xy.a, xy.b + 1));
		}
    }
	/* Данная функция в результате своей работы возвращает 
	индексы в пределах которых лежит палиндром */
	private Coordinates FindPalindrome(String s)
	{
		Coordinates co = new Coordinates(0, s.length() - 1); // Меняющиеся координаты
		Coordinates end = new Coordinates(0, s.length() - 1); // Конечные координаты
		// Эти две переменные для вычисления длинны палиндрома
		int len = 0;
		int pal = 0;
		/* Алгоритм зеркально проверяет строку сравнивая 
		первый символ с последним, смещаясь к середине*/
		while (co.a < s.length() - 1)
		{
			co.b = s.length() - 1;
			while (co.b > co.a)
			{
				pal = 0;
				if (isIt(s, co.a, co.b)) // Проверка происходит рекурсивно в данной функции
				{
					pal = co.b - co.a;
					/* Как только палиндром найден - цикл поиска разрывается, 
					т.к. поиск идёт от большего к меньшему, а задача в нахождении длинейшего палиндрома*/
					break;
				}
				co.b--;
			}
			/* Если длинна полиндрома больше предыдущего найденного, 
			его координаты заносятся в конечные */
			if (len < pal)
			{
				len = pal;
				end.a = co.a;
				end.b = co.b;
			}
			co.a++;
		}
		/* В программе ожидается возврат первого символа, если ни одного палиндрома не найдено */
		if (len == 0)
		{
			end.a = 0;
			end.b = 0;
		}
		return (end);
	}
	/* Рекурсивный алгоритм нахождения палиндрома, возвращает true,
	если в указанных границах - палиндром */
	private boolean isIt(String s, int start, int end)
	{
		if (s.charAt(start) == s.charAt(end)
			&& start + 1 >= end - 1)
			return true;
		if (s.charAt(start) == s.charAt(end)
			&& isIt(s, start + 1, end - 1))
			return true;
		return false;
		
	}
}
// main
class Tess
{
	public static void main(String[] args)
	{
		// Так как класс не static - создаётся объект (это хуйня так делать не надо, в этом случае лучше было использовать static)
		LongestPalindromicSubstring a = new LongestPalindromicSubstring();
		System.out.println(a.LongestPalindrome("aacabdkacaa"));
	}
}
