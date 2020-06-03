package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayDemoTest {

	@Test
	void test() {
		ArrayDemo arrayDemo=new ArrayDemo();
		int [] actual=arrayDemo.returnArray();
		int [] expected= {3,2,1};
		assertArrayEquals(expected, actual);
	}

}
