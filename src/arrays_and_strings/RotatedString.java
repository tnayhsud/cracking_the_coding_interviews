package arrays_and_strings;

public class RotatedString {
	
	public static void main(String[] args) {
		System.out.println(isRotated("waterbottle", "erbottlewat"));
	}

	public static boolean isRotated(String s1, String s2) {
		StringBuilder s = new StringBuilder(s2);
		s.append(s2);
		return s.indexOf(s1) != -1 ? true : false;
	}

}
