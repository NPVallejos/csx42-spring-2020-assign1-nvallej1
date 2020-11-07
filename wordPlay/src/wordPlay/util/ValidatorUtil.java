package wordPlay.util;


// src: ValidationTest.java -> https://piazza.com/class/k5k3yuyx97612d?cid=37
public final class ValidatorUtil {
	public static void validate(String baseErrMsg, Validator... validators) throws Exception {
		for (Validator v : validators) {
			try {
				v.run();
			} catch (Exception e) {
				throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
			}
		}

	}
}
