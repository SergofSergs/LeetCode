public class ZigzagConversion
{

	public String Convert(String s, int numRows) // Вход в функцию
	{
        if (numRows == 1) // Возврат одной строки
			return s;
		else
			return (Zigzag(s, numRows));
    }

	public String Zigzag(String s, int rows)
	{
		String str = new String(); // Новая строка в которую будут склеиваться (конкат) символы

		for (int i = 0; i != rows; i++) // Цикл для каждой строки
		{
			if (i == 0 || i == rows - 1 || rows == 2) // В первой и последней формула лёгко выводится, для 2х строк она также годится
			{
				for (int j = i; j < s.length(); j += 2 * ( rows - 1))
					str = str.concat(s.substring(j, j + 1));
			}
			else
			/* Рекурсия (мне так удобнее) для промежуточных срок. 
			Между столбцами нужно просчитывать промежутки,
			в них буквы стоят задом наперёд */
				str = Concat(s, str, i, i, rows); 
			/*
			В этой функции две входные i 
			i - номер строки,
			j - индекс элемента,
			на входе они равны 
			 */
		}
		return (str);
	}

	public String Concat(String s, String str, int i, int j, int rows)
	{
		if (j < s.length())
		{
			str = str.concat(s.substring(j, j + 1));
			/*Формула для нахождения элемента в промежутке:
			j + 2 * (rows - i - 1),
			её было очень сложно вывести...*/
			if (j + 2 * (rows - i - 1) < s.length())
				str = str.concat(s.substring(j + 2 * (rows - i - 1), j + 1 + 2 * (rows - i - 1)));
			j += 2 * ( rows - 1); // Это таже формула что и выше - для смещения по столбцам
			str = Concat(s, str, i, j, rows); // Чтобы не создавать класс для хранения - рекурсивная функция заполнения
		}
		return (str);
	}
}

class Start // Меняй параметр, чтобы затестить
{
	public static void main(String[] args)
	{
		ZigzagConversion go = new ZigzagConversion();
		System.out.println(go.Convert("paypalishiring", 5));
	}
}