public class RomanToInteger {

	public static int romanToInt(String s) {
		char[] str = s.toCharArray();
		int len = str.length;
		Utils utils = new Utils('C', 'D', 'M');

		//Special "too simple" case
		while (utils.i < str.length && str[utils.i] == 'M') {
			utils.num += 1000;
			utils.i++;
		}
		if (!(parseAndTransform(str, len, 100, utils))) {
			return utils.num;
		}
		utils.setRoman('X', 'L', 'C');
		if (!(parseAndTransform(str, len, 10, utils))) {
			return utils.num;
		}
		utils.setRoman('I', 'V', 'X');
		parseAndTransform(str, len, 1, utils);
		return utils.num;
	}

	private static boolean parseAndTransform(char[] str, int len, int multiplier, Utils utils) {
		int prevPos = utils.i;

		//For instant return
		if (utils.i >= len) {
			return false;
		}
		//Handling situations with '4' and '9'
		if (str[prevPos] == utils.def && prevPos + 1 < len && (str[prevPos + 1] == utils.mid || str[prevPos + 1] == utils.over)) {
			if (str[prevPos + 1] == utils.mid) {
				utils.num += 4 * multiplier;
			} else {
				utils.num += 9 * multiplier;
			}
			utils.i += 2;
		}
		//Default case
		while (utils.i < len && (str[utils.i] == utils.def || str[utils.i] == utils.mid)) {
			if (str[utils.i] == utils.def) {
				utils.num += multiplier;
			} else {
				utils.num += 5 * multiplier;
			}
			utils.i++;
		}
		return true;
	}

	private static class Utils {
		//Roman digits
		public char def;
		public char mid;
		public char over;

		//Returning number and index for parsing
		public int num;
		public int i;

		public Utils(char def, char mid, char over) {
			this.def = def;
			this.mid = mid;
			this.over = over;
			i = 0;
			num = 0;
		}

		public void setRoman(char def, char mid, char over) {
			this.def = def;
			this.mid = mid;
			this.over = over;
		}
	}
}

/*
	Runtime: 4 ms, faster than 93.57% of Java online submissions for Roman to Integer.
	Memory Usage: 42.5 MB, less than 90.66% of Java online submissions for Roman to Integer.
*/