// Transforming int values to roman number system  (1 <= num <= 3999)

public class IntegerToRoman {
	public String intToRoman(int num) {
		int nLen = digitNumber(num); // Calculating number's length
		String roman = ""; // The number being build down there
		String def = "M";
		String mid;
		String over;

		if (nLen > 4) // This check redundant in this case
			return null;
		while (nLen != 0) {
			int n = (num / (int) Math.pow(10, nLen - 1));
			// Roman number system is too bordered in the terms of values size
			// For the M (1000) it's that simple
			if (nLen == 4) {
				while (n != 0) {
					roman = roman.concat(def);
					n--;
				}
				// Every other case is following the one same pattern
				// I don't want to explain it, you can just google how this number system works
			} else {
				if (nLen == 3) {
					def = "C";
					mid = "D";
					over = "M";
				} else if (nLen == 2) {
					def = "X";
					mid = "L";
					over = "C";
				} else {
					def = "I";
					mid = "V";
					over = "X";
				}
				while (n > 0) {
					if (n == 9) {
						roman = roman.concat(def);
						roman = roman.concat(over);
						break;
					}
					if (n == 4) {
						roman = roman.concat(def);
						roman = roman.concat(mid);
						break;
					}
					if (n >= 5) {
						roman = roman.concat(mid);
						n -= 5;
					}
					if (n != 0) {
						roman = roman.concat(def);
					}
					n--;
				}
			}
			// We're discarding first digit of the number every time
			num = num - (int) Math.pow(10, nLen - 1) * (num / (int) Math.pow(10, nLen - 1));
			nLen--;
		}
		return roman;
	}

	private int digitNumber(int x) {
		int i;

		for (i = 0; x != 0; x /= 10)
			i++;
		return (i);
	}
}
/*
	Runtime: 6 ms, faster than 82.04% of Java online submissions for Integer to Roman.
	Memory Usage: 43.2 MB, less than 74.90% of Java online submissions for Integer to Roman.
*/
