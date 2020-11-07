package wordPlay.driver;
import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import wordPlay.util.CommandArgHandler;

/**
 * @author Nicholas Vallejos
 *
 */
public class Driver {
	public static void main(String[] args) {
		try {
			/*
			** BONUS: create a CommandArgHandler object which validates cmd args
			** in the CommandArgHandler constructor
			*/
			new CommandArgHandler(args.length, args);


			System.out.println("Hello World! Lets get started with the assignment");

			FileProcessor fileProcessorObject = new FileProcessor(args[0]);
			Results resObj = null;

			resObj = fileProcessorObject.processFile();
			resObj.displayMetrics();
			resObj.writeToFile(args[1], args[2]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
