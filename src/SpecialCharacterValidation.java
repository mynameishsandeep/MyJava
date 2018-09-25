public class SpecialCharacterValidation {

	public static void main(String[] args) {
		print(testInput("jhgjhgjh.#"));
		print(testInput("jhgjhgjh"));
		print(testInput("!jhgjhgjh"));

	}

	public static void print(boolean good) {
		if (good) {
			System.out.println("Good String without Special Character");
		} else {
			System.out.println("Bad String. It has Special Character");
		}
	}

	public static boolean testInput(String input) {
		String REGEX = "^[^&%$#@!~]*";
		return input.matches(REGEX);
	}
}
