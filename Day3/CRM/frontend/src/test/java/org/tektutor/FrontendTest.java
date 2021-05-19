package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontendTest {

	private String actualResponse, expectedResponse;

	@Test
	public void testFrontend() {
		Frontend fe = new Frontend();
		
		actualResponse   = fe.getModuleName();
		expectedResponse = "Frontend Module";

		assertEquals ( expectedResponse, actualResponse );
	}


}
