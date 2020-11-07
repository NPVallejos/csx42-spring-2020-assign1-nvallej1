package wordPlay.util;

// purpose - store and validate command line arguments
// Reference: Person.java -> https://piazza.com/class/k5k3yuyx97612d?cid=37
public class CommandArgHandler {
	private int numArgs;
	private String[] args;

	private static class ValidatorFetcher {
		public static Validator numArgsValidator(CommandArgHandler c) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (c.numArgs != 3) {
						throw new Exception("Incorrect number of arguments [" + c.numArgs + "].");
					}
				}
			};
		}
		public static Validator argNamesValidator(CommandArgHandler c) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (c.args[0].equals("${arg0}")) {
						throw new Exception("Name not given for input file.");
					}
					else if (c.args[1].equals("${arg1}")) {
						throw new Exception("Name not given for output file.");
					}
					else if (c.args[2].equals("${arg2}")) {
						throw new Exception("Name not given for metrics file.");
					}
				}
			};
		}
	}

	public CommandArgHandler(int numArgs, String[] args) throws Exception {
		this.numArgs = numArgs;
		this.args = args;

		// Validating fields
		ValidatorUtil.validate("Failed: ",
			ValidatorFetcher.numArgsValidator(this),
			ValidatorFetcher.argNamesValidator(this));
	}
}
