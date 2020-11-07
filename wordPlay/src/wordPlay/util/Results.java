package wordPlay.util;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

/*
** purpose - Wrapper around MetricsCalculator and SentenceHandler and stores
** reversed sentences
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private List<String> reversedSentences;
	private SentenceHandler sentenceHandler;
	private MetricsCalculator metrics;

	// purpose - default constructor
	public Results() {
		reversedSentences = new ArrayList<String>();
		sentenceHandler = new SentenceHandler();
		metrics = new MetricsCalculator();
	}

	/*
	** purpose - copy constructor needed
	** @param other - Result object to copy from
	*/
	public Results(Results other) {
		this.reversedSentences = other.reversedSentences;
		this.sentenceHandler = other.sentenceHandler;
		this.metrics = other.metrics;
	}

	/*
	** purpose - add strings to instance field 'reversedSentences'
	** @param revSentence - String to be added to instance field
	*/
	public void addRevSentence(String revSentence) {
		this.reversedSentences.add(revSentence);
	}

	// purpose - reference to metrics field
	public MetricsCalculator getMetricsCalculator() {
		return this.metrics;
	}

	// purpose - reference to sentenceHandler field
	public SentenceHandler getSentenceHandler() {
		return this.sentenceHandler;
	}

	@Override
	public void displayMetrics() {
		System.out.println("AVG_NUMBER_WORDS_PER_SENTENCE = " + metrics.getAvgNumWordsPerSentence());
		System.out.println("AVG_NUM_CHARS_PER_SENTENCE = " + metrics.getAvgNumCharsPerSentence());
		System.out.println("MAX_FREQ_WORD = " + metrics.getMaxFreqWord());
		System.out.println("LONGEST_WORD = " + metrics.getLongestWord());
	}

	@Override
	public void writeToFile(String outputFileName, String metricsFileName) throws Exception {
		// Writing Output File
		FileWriter fw = new FileWriter(outputFileName);

		for (String sentence : reversedSentences) {
			fw.write(sentence);
			fw.write("\n");
		}

		fw.close();

		// Writing Metrics File
		fw = new FileWriter(metricsFileName);

		fw.write("AVG_NUMBER_WORDS_PER_SENTENCE = " + metrics.getAvgNumWordsPerSentence() + "\n");
		fw.write("AVG_NUM_CHARS_PER_SENTENCE = " + metrics.getAvgNumCharsPerSentence() + "\n");
		fw.write("MAX_FREQ_WORD = " + metrics.getMaxFreqWord() + "\n");
		fw.write("LONGEST_WORD = " + metrics.getLongestWord() + "\n");

		fw.close();
	}
}
