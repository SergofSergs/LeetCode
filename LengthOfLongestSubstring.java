public class LengthOfLongestSubstring 
{
	public static int isRepeat(int pos, int start, int lOfSub, String s, boolean f[])
	{
		for (int q = pos - 1; q >= start && q >= 0; q--)
			{
				if (s.charAt(pos) == s.charAt(q))
				{
					lOfSub--;
					f[0] = true;
				}
			}
		return lOfSub;
	} 

	public static int isTrue(int pos, int len, String s, int lOfSub, boolean[] f)
	{
		int start;

		start = pos;
		while (pos < len)
		{
			lOfSub++;
			if ((pos + 1 < len) && s.charAt(pos) == s.charAt(pos + 1))
			{
				isRepeat(pos, start, lOfSub, s, f);
				/*эта функция выясняет есть ли за символом сзади повторяющиеся
				отнимает от подстроки лишний символ который начисляется до проверок
				(здесь не нужно))*/
				if (f[0] == true)
					lOfSub--;
				return lOfSub;
			}
			lOfSub = isRepeat(pos, start, lOfSub, s, f);
			if (f[0] == true)
				return lOfSub;
			pos++;
		}
		return lOfSub;
	}

	public static int lengthOfLongestSubstring(String s)
	{
		int lOfSub = 0;
		int maxValue = 0;
		boolean[] factor = {false};
		
		for(int j = 0; j < s.length(); j++)
		{
			lOfSub = isTrue(j, s.length(), s, lOfSub, factor); 
			/* эта функция проверяет является ли след символ таким же 
			и если нет, то проверяет все стоящие за ним символы на схожесть
			в результате работы выдаётся самая длинная подстрока от старта который поступает в метод
			вынесена в отдельную функцию чтобы не менялся параметр j*/
			if (lOfSub != 0)
			{
				if (maxValue < lOfSub)
					maxValue = lOfSub;
				factor[0] = false;
			}
			lOfSub = 0;
		}
		if (s.length() != 0 && maxValue == 0)
			maxValue = 1;
		return maxValue;
	}

	public static void main(String[] args)
	{
		String s = "bbbbbb";
		int len = lengthOfLongestSubstring(s);
		System.out.print(len);
	}
}
