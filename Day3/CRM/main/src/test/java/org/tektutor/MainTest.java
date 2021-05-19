package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

	private String actualResponse, expectedResponse;

	@Test
	public void testMain() {
		Main fe = new Main();
		
		actualResponse   = fe.getModuleName();
		expectedResponse = "Main Module";

		assertEquals ( expectedResponse, actualResponse );
	}


}
