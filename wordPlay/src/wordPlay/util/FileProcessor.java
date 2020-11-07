package wordPlay.util;
import java.io.File;
import java.util.Scanner;

/*
** purpose - to read a file line by line
*/
public class FileProcessor {
	private String inputFileName;

	// Default constructor
	public FileProcessor() {
		inputFileName = null;
	}

	// Overloaded constructor that takes a file name
	public FileProcessor(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	// @return - returns the inputFileName string
	public String getInputFileName() {
		return inputFileName;
	}

	// @param - name of the input file
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	@Override
	public String toString() {
		return String.format("FileProcessor[inputFileName: %s]", inputFileName);
	}

	/*
	* purpose - process the input file by reversing each word and
	* calculate metrics (AVG_NUM_CHARS_PER_SENTENCE, etc.).
	* @return - returns a Results object with reversed sentences AND calculated metrics
	*/
	public Results processFile() throws Exception {
		File inputFile = new File(this.inputFileName);

		// Check if file is empty
		if (inputFile.length() == 0) {
			throw new Exception(this.inputFileName + " is an empty file.");
		}

		Results resObj = new Results();
		Scanner in = new Scanner(inputFile);

		// Read each line and process them through Results object
		while (in.hasNextLine()) {
			String line = in.nextLine();

			String reversedLine = resObj.getSentenceHandler().parseSentence(line);

			resObj.addRevSentence(reversedLine);

			resObj.getMetricsCalculator().updateMetrics(line);
		}

		resObj.getMetricsCalculator().calculateAverages();

		in.close();

		return resObj;
	}
}
