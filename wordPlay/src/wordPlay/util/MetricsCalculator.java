package wordPlay.util;
import java.util.HashMap;

// purpose - helper class that stores metric data
public class MetricsCalculator {
	private int totalNumChars;
	private int totalNumWords;
	private int totalNumSentences;
	private int maxFreqWordCount;
	private int longestWordLength;
	private double avgNumCharsPerSentence;
	private double avgNumWordsPerSentence;
	private String maxFreqWord;
	private String longestWord;
	private HashMap <String, Integer> wordFreqMap;

	// Default constructor
	public MetricsCalculator() {
		totalNumChars = 0;
		totalNumWords = 0;
		totalNumSentences = 0;
		maxFreqWordCount = 0;
		longestWordLength = 0;
		avgNumCharsPerSentence = 0;
		avgNumWordsPerSentence = 0;
		maxFreqWord = null;
		longestWord = null;
		wordFreqMap = new HashMap<String, Integer>();
	}

	// @return - average number of chars per sentence
	public double getAvgNumCharsPerSentence() {
		return avgNumCharsPerSentence;
	}

	// @return - average number of words per sentence
	public double getAvgNumWordsPerSentence() {
		return avgNumWordsPerSentence;
	}

	// @return - most frequent word
	public String getMaxFreqWord() {
		return maxFreqWord;
	}

	// @return - longest word
	public String getLongestWord() {
		return longestWord;
	}

	// @return - field values in a String
	@Override
	public String toString() {
		return String.format("Metrics[totalNumChars: %d, totalNumWords: %d, totalNumSentences: %d,maxFreqWordCount: %d, longestWordLength: %d, avgNumCharsPerSentence: %.2f, avgNumWordsPerSentence: %.2f, maxFreqWord: %s, longestWord: %s]",
			totalNumChars, totalNumWords, totalNumSentences,
			maxFreqWordCount, longestWordLength, avgNumCharsPerSentence,
			avgNumWordsPerSentence, maxFreqWord, longestWord);
	}

	/*
	** purpose - to update each instance variable given a sentence
	** @param sentence - a string with multiple words seperated by spaces and ends in a period
	** Assumptions:
	** 	It is assumed that this method is called after SentenceHandler.parseSentence(sentence) is called in FileProcessor
	** 	Otherwise, invalid characters can pass through undetected here
	*/
	public void updateMetrics(String sentence) throws Exception {
		// Split words by <space>
		String[] words = sentence.split("\\s");

		for (String word : words) {
			// Split single word into subwords (if any)
			String[] subWords = word.split("\\.");
			int periodIndex = word.indexOf(".");

			// Increment sentence counter if word contains a <period>
			if (periodIndex != -1) {
				int sentenceCount = 1;

				/*
				** Check if 'word' contains sub words, i.e. more than one sentence
				** Ex: word = "he.l.l.o.",
				**     subWords = [he, l, l, o],
				**     i.e. sentenceCount = subWords.length
				*/
				if (subWords.length > 1) {
					// Check if the last subword ends in a period:
					if (word.charAt(word.length() - 1) == '.') {
						sentenceCount = subWords.length;
					}
					else {
						sentenceCount = subWords.length - 1;
					}
				}
				this.totalNumSentences += sentenceCount;
			}

			// Determine longest word and most frequent word
			for (String subWord : subWords) {
				// Update longest word
				if (subWord.length() > longestWordLength) {
					this.longestWord = subWord;
					this.longestWordLength = subWord.length();
				}

				// Update word frequency map
				Integer wordFrequency = wordFreqMap.get(subWord.toLowerCase());
				int newFreq = 1;
				if (wordFrequency != null) {
					newFreq += wordFrequency.intValue();
					wordFreqMap.replace(subWord.toLowerCase(), new Integer(newFreq));
				}
				else {
					wordFreqMap.put(subWord.toLowerCase(), newFreq);
				}

				// Update maxFreqWordCount as well as maxFreqWord if needed
				if (newFreq > this.maxFreqWordCount) {
					this.maxFreqWordCount = newFreq;
					this.maxFreqWord = subWord;
				}
			}
		}

		this.totalNumWords += words.length;
		this.totalNumChars += sentence.length();
	}

	// purpose - calculate average number of characters and words per sentence
	public void calculateAverages() {
		this.avgNumCharsPerSentence = ((double)this.totalNumChars) / this.totalNumSentences;
		this.avgNumWordsPerSentence = ((double)this.totalNumWords) / this.totalNumSentences;

		// Round to two decimal places - (https://stackoverflow.com/a/11701527)
		this.avgNumCharsPerSentence = Math.round(this.avgNumCharsPerSentence * 100) / 100.0;
		this.avgNumWordsPerSentence = Math.round(this.avgNumWordsPerSentence * 100) / 100.0;
	}
}
