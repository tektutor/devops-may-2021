package org.tektutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLayerTest {

	private String actualResponse, expectedResponse;

	@Test
	public void testBusinessLayer() {
		BusinessLayer fe = new BusinessLayer();
		
		actualResponse   = fe.getModuleName();
		expectedResponse = "BusinessLayer Module";

		assertEquals ( expectedResponse, actualResponse );
	}


}
