import static org.junit.Assert.*;

import org.junit.Test;

public class CountTest {

	@Test
	public void test() {
		Count count = new Count();
		int actual = count.sum(5);
		int expected = 15;
		assertEquals(expected, actual);
	}

}
