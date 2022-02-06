package src;

public class StringtoInteger 
{
	private class Str
	{
		boolean negative;
		int pos;
		int len;

		Str(){negative = false; this.pos = 0; this.len = 0;};
	}
	public int Atoi(String s) 
	{
        int x = 0;
		Str cont;
		
		if (s.length() == 0)
			return (0);
		cont = beforeString(s);
		if (cont.len == 0)
			return (0);
		if (cont.len > 10)
		{
			if (cont.negative == true)
				return (Integer.MIN_VALUE);
			return (Integer.MAX_VALUE);
		}
		x = stringToInt(cont, s);
		if (cont.negative == true && x > 0)
			x *= -1;
		return (x);
    }
	private Str beforeString(String s)
	{
		Str content = new Str();
		int len = s.length();

		while (content.pos < len && s.charAt(content.pos) == ' ')
			content.pos++;
		if (content.pos < len && (s.charAt(content.pos) == '+' || s.charAt(content.pos) == '-'))
		{
			if (s.charAt(content.pos) == '-')
				content.negative = true;
			content.pos++;
		}
		while (content.pos < len && s.charAt(content.pos) == '0')
			content.pos++;
		for (int i = content.pos; i < len && (s.charAt(i) >= '0' && s.charAt(i) <= '9') ; i++)
			content.len++;
		return (content);
	}
	private int stringToInt (Str cont, String s)
	{
		int x = 0;
		int len = s.length();

		while (cont.pos < len && (s.charAt(cont.pos) >= '0' && s.charAt(cont.pos) <= '9'))
		{
			if (x + (s.charAt(cont.pos) - '0') * Math.pow(10, cont.len - 1) > Integer.MAX_VALUE)
			{
				if (cont.negative)
					return (Integer.MIN_VALUE);
				return (Integer.MAX_VALUE);
			}
			x += (s.charAt(cont.pos) - '0') * Math.pow(10, cont.len - 1);
			cont.pos++;
			cont.len--;
		}
		return (x);
	}
}

class StrtoIntTest
{
	public static void main(String[] args)
	{
		StringtoInteger go = new StringtoInteger();
		System.out.println(go.Atoi("-2147483647"));
	}
}