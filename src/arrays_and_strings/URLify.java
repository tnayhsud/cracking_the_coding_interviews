package arrays_and_strings;

public class URLify {

	public static void main(String[] args) {
		modify("Mr John Smith    ", 13);
	}

	public static void modify(String s, int l) {
		int count = 0;
		char[] arr = s.toCharArray();
		// Count the number of spaces
		for (int i = 0; i < l; i++) {
			if (arr[i] == ' ') {
				count++;
			}
		}
		int index = l + 2 * count;
		for (int i = l - 1; i >= 0; i--) {
			char c = arr[i];
			if (c == ' ') {
				arr[index - 1] = '0';
				arr[index - 2] = '2';
				arr[index - 3] = '%';
				index = index - 3;
			} else {
				arr[index - 1] = arr[i];
				index--;
			}
		}
		System.out.println(String.valueOf(arr));
	}

}
