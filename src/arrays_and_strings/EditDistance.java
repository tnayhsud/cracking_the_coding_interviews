package arrays_and_strings;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println(unitDistant("pale", "pae"));
	}

	public static boolean unitDistant(String s1, String s2) {
		boolean answer = false;
		if (s1.equals(s2)) {
			return !answer;
		}
		if (Math.abs(s1.length() - s2.length()) <= 1) {
//			Using bit vector
//			return s1.length() - s2.length() >= 0 ? unitDistantUsingBitVector(s1, s2)
//					: unitDistantUsingBitVector(s2, s1);

//			Using simple logic to check indexes
			if (s1.length() - s2.length() == 0) {
				return unitDistantUsingReplace(s1, s2);
			} else if (s1.length() - s2.length() == 1) {
				return unitDistantUsingInsertionOrDeletion(s1, s2);
			} else if (s1.length() - s2.length() == -1) {
				return unitDistantUsingInsertionOrDeletion(s2, s1);
			}
		}
		return answer;
	}

	public static boolean unitDistantUsingReplace(String s1, String s2) {
		boolean flag = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (flag)
					return false;
				flag = true;
			}
		}
		return true;
	}

	public static boolean unitDistantUsingInsertionOrDeletion(String s1, String s2) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (i != j) {
					return false;
				}
				i++;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	// Assuming string is lower case only
	public static boolean unitDistantUsingBitVector(String s1, String s2) {
		int checker = 0;
		for (int i = 0; i < s1.length(); i++) {
			int val = s1.charAt(i) - 'a';
			checker |= 1 << val;
		}
		for (int i = 0; i < s2.length(); i++) {
			int val = s1.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				checker &= ~(1 << val);
			} else
				checker |= 1 << val;
		}
		if ((checker & (checker - 1)) == 0) {
			return true;
		}
		return false;
	}

}
