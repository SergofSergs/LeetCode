// Transforming int values to roman number system  (1 <= num <= 3999)
public class IntegerToRoman {
	public String intToRoman(int num) {
		int nLen = digitNumber(num); // Calculating number's length
		String roman = ""; // The number being build down there

		if (nLen > 4) // This check redundant in this case
			return null;
		while (nLen != 0) {
			int n = (num / (int) Math.pow(10, nLen - 1));
			// Roman number system is too bordered in the terms of values size
			// For the M (1000) it's that simple
			if (nLen == 4) {
				while (n != 0) {
					roman = roman.concat(Roman.ONE_THOUSAND.toString());
					n--;
				}
				// Every other case is following the one same pattern
				// I don't want to explain it, you can just google how this number system works
			} else if (nLen == 3) {
				while (n > 0) {
					if (n == 9) {
						roman = roman.concat(Roman.ONE_HUNDRED.toString());
						roman = roman.concat(Roman.ONE_THOUSAND.toString());
						break;
					}
					if (n == 4) {
						roman = roman.concat(Roman.ONE_HUNDRED.toString());
						roman = roman.concat(Roman.FIVE_HUNDREDS.toString());
						break;
					}
					if (n >= 5) {
						roman = roman.concat(Roman.FIVE_HUNDREDS.toString());
						n -= 5;
					}
					if (n != 0) {
						roman = roman.concat(Roman.ONE_HUNDRED.toString());
					}
					n--;
				}
			} else if (nLen == 2) {
				while (n > 0) {
					if (n == 9) {
						roman = roman.concat(Roman.TEN.toString());
						roman = roman.concat(Roman.ONE_HUNDRED.toString());
						break;
					}
					if (n == 4) {
						roman = roman.concat(Roman.TEN.toString());
						roman = roman.concat(Roman.FIFTY.toString());
						break;
					}
					if (n >= 5) {
						roman = roman.concat(Roman.FIFTY.toString());
						n -= 5;
					}
					if (n != 0) {
						roman = roman.concat(Roman.TEN.toString());
					}
					n--;
				}
			} else {
				while (n > 0) {
					if (n == 9) {
						roman = roman.concat(Roman.ONE.toString());
						roman = roman.concat(Roman.TEN.toString());
						break;
					}
					if (n == 4) {
						roman = roman.concat(Roman.ONE.toString());
						roman = roman.concat(Roman.FIVE.toString());
						break;
					}
					if (n >= 5) {
						roman = roman.concat(Roman.FIVE.toString());
						n -= 5;
					}
					if (n != 0) {
						roman = roman.concat(Roman.ONE.toString());
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

	// Also redundant, just playing with enums
	private enum Roman {
		ONE,
		FIVE,
		TEN,
		FIFTY,
		ONE_HUNDRED,
		FIVE_HUNDREDS,
		ONE_THOUSAND;

		@Override
		public String toString() {
			switch (this) {
				case ONE:
					return "I";
				case FIVE:
					return "V";
				case TEN:
					return "X";
				case FIFTY:
					return "L";
				case ONE_HUNDRED:
					return "C";
				case FIVE_HUNDREDS:
					return "D";
				default:
					return "M";
			}
		}
	}
}
/*
	Runtime: 7 ms, faster than 72.53% of Java online submissions for Integer to Roman.
	Memory Usage: 47 MB, less than 17.62% of Java online submissions for Integer to Roman.
*/
