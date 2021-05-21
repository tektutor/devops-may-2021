package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BackendTest {

	private String actualResponse, expectedResponse;

	@Test
	public void testBackend() {
		Backend fe = new Backend();
		
		actualResponse   = fe.getModuleName();
		expectedResponse = "Backend Module";

		assertEquals ( expectedResponse, actualResponse );
	}


}
