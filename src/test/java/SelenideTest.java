import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

import org.junit.Test;

public class SelenideTest {

	@Test
	public void test() {
		open("http://google.com");
	}

}
