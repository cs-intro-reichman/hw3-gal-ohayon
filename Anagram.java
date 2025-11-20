/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {

		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;

		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}

		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		// 1. Preprocess both strings
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);

		// 2. Ignore spaces for actual anagram logic
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");

		// 3. If different lengths → not anagrams
		if (s1.length() != s2.length()) {
			return false;
		}

		// 4. Try matching every char of s1 with s2
		String temp = s2;

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			boolean found = false;

			for (int j = 0; j < temp.length(); j++) {
				if (c == temp.charAt(j)) {
					temp = temp.substring(0, j) + temp.substring(j + 1);
					found = true;
					break;
				}
			}

			if (!found) return false;
		}

		return true;
	}
	   
	// Preprocess: keep letters + spaces, letters become lowercase.
	public static String preProcess(String str) {
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLetter(c)) {
				result += Character.toLowerCase(c);
			} else if (c == ' ') {
				result += ' ';
			}
		}

		return result;
	} 
	   
	// Returns a random permutation of the given string.
	public static String randomAnagram(String str) {

		String result = "";
		String temp = str;

		while (temp.length() > 0) {

			int r = (int)(Math.random() * temp.length());

			result += temp.charAt(r);
			temp = temp.substring(0, r) + temp.substring(r + 1);
		}

		return result;
	}
}
