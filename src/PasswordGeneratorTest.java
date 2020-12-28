import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordGeneratorTest {

	PasswordGenerator pg = new PasswordGenerator(25, true);

	@Test
	public void generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1; i++) {
			String password = pg.generatePassword();
			sb.append(password + "\n");
		}
		System.out.println(sb.toString());
	}
}
