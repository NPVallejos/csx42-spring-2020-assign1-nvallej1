package wordPlay.util;
import java.lang.StringBuilder;

// purpose - helper class that parses and manipulates individual sentences
public class SentenceHandler {
	/*
	** purpose - seperate sentence into words and then reverse each word;
	** seperates words on white space
	** @param sentence - String that contains characters and whitespace
	** @return - String with reversed words taken from parameter
	*/
	public String parseSentence(String sentence) throws Exception {
		StringBuilder reversedString = new StringBuilder();
		String[] words = sentence.split("\\s");

		// Reversing each word in the sentence
		for (String word : words) {
			reversedString.append(reverseWord(word));

			// Only append a <space> if we aren't at the last word in the sentence
			if (word != words[words.length-1]) {
				reversedString.append(" ");
			}
		}

		return reversedString.toString();
	}

	/*
	** purpose - reverse a word
	** @param word - String with no spaces
	** @return - reversed word
	** Looping over a word idea - https://stackoverflow.com/a/2451660
	*/
	private static String reverseWord(String word) throws Exception {
		StringBuilder newWord  = new StringBuilder();
		int startIndex = 0;

		for (char c : word.toCharArray()) {
			if (isValidCharacter(c)) {
				if (c == '.') {
					newWord.append(c);

					// Further char inserts start after last '.' in newWord
					startIndex = newWord.toString().lastIndexOf(".") + 1;
				}
				else {
					newWord.insert(startIndex, c);
				}
			}
			else {
				throw new Exception("invalid character '" + c + "'");
			}
		}

		return newWord.toString();
	}

	/*
	** purpose - test if char value is between ASCII values for A-Z, a-z, 0-9, '.', and '<space>'
	** @param c - a single char
	** @return - boolean value
	** Respective ASCII Valid Numbers - 65-90, 97-122, 48-57, 46, 32
	*/
	private static boolean isValidCharacter(char c) {
		if (c == 32 || c == 46 ||  (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
			return true;
		}
		return false;
	}
}
