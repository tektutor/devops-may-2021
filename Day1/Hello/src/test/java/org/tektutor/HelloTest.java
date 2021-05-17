package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {

	@Test
	public void testHello() {
		Hello hello = new Hello();

		String actualResponse = hello.sayHello();
		String expectedResponse =  "Java - Hello World using Maven !";

		assertEquals ( expectedResponse,  actualResponse );
	}

}
