import java.util.Random;

/**
 * Password Generator Class generates a random password using a variety of
 * characters and numbers allowing for a strong and secure password.
 * 
 * @author Ashton Foulger
 * @version (0.01) December 14, 2020
 */
public class PasswordGenerator {

	// Variables
	private static char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9' };
	private static char[] alphabetSpecial = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1',
			'2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '#', '$', '%', '^', '&', '*', '-', '_', '+', '=' };

	private static boolean hasSpecial;
	private static int length;

	/**
	 * Constructor used by PasswordGenerator class to set a length for the desired
	 * random password.
	 * 
	 * @param size - length of password.
	 */
	public PasswordGenerator(int size, boolean special) {
		hasSpecial = special;
		length = size;
	}

	/**
	 * Builds the randomly generated password.
	 * 
	 * @return - password.
	 */
	public String generatePassword() {
		return passwordStringBuilder();
	}

	/**
	 * PasswordGenerator is toString method in order to give us an accurate
	 * generated password with no whitespace.
	 * 
	 * @return - String cast of password.
	 */
	private String passwordStringBuilder() {
		StringBuilder pw = new StringBuilder();
		if (hasSpecial) {
			for (int i = 0; i < length; i++) {
				pw.append(alphabetSpecial[randomChar()]);
			}
		} else {
			for (int i = 0; i < length; i++) {
				pw.append(alphabet[randomChar()]);
			}
		}
		return pw.toString();
	}

	/**
	 * Gets a random character or number to be placed in the char[].
	 * (A-Z,a-z,0-9,!-*)
	 * 
	 * @return - random character from char[].
	 */
	private static int randomChar() {
		Random rng = new Random();
		int index;
		if (hasSpecial) {
			index = rng.nextInt(alphabetSpecial.length);
			return index;
		} else {
			index = rng.nextInt(alphabet.length);
			return index;
		}
	}
}
