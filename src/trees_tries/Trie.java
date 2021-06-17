package trees_tries;

class TrieNode {
	char c;
	int word;
	TrieNode[] kids = new TrieNode[26];

	public TrieNode() {
	}

	public TrieNode(char c, int word) {
		this.c = c;
		this.word = word;
	}

}

public class Trie {

	final TrieNode root = new TrieNode('\0', 0);

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("help");
		trie.insert("he");
		trie.insert("heel");
		trie.insert("heap");
		System.out.println(trie.startsWith("hes"));
	}

	public void insert(String word) {
		TrieNode curr = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			if (curr.kids[c - 'a'] == null) {
				curr.kids[c - 'a'] = new TrieNode(c, 0);
			}
			curr = curr.kids[c - 'a'];
		}
		curr.word = curr.word + 1;
	}

	public boolean search(String word) {
		TrieNode curr = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			if (curr.kids[c - 'a'] == null) {
				return false;
			}
			curr = curr.kids[c - 'a'];
		}
		return curr.word == 1;
	}

	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		int len = prefix.length();
		for (int i = 0; i < len; i++) {
			char c = prefix.charAt(i);
			if (curr.kids[c - 'a'] == null) {
				return false;
			}
			curr = curr.kids[c - 'a'];
		}
		return curr.word == 0 || curr.word == 1;
	}

}
