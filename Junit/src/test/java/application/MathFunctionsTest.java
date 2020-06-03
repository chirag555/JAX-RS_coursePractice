package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathFunctionsTest {

	@Test
	void testAdd() {

		MathFunctions mathFunction = new MathFunctions();
		int actual = mathFunction.add(10, 30);
		int expected = 41;
		assertEquals(expected, actual);
		
		
	}

}
