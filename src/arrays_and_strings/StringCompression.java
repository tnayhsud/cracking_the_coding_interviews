package arrays_and_strings;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("bbc"));
	}

	public static String compress(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int i = 1, count = 1;
		char c = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		while (i < s.length()) {
			if (s.charAt(i) == c) {
				count++;
			} else {
				c = s.charAt(i);
				sb.append(count);
				sb.append(s.charAt(i));
				count = 1;
			}
			if (sb.length() >= s.length()) {
				return s;
			}
			i++;
		}
		sb.append(count);
		return sb.toString();
	}

}
