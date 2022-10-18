package com.jeroenreijn.examples.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PresentationsControllerTest {

	@Autowired
	private PresentationsController controller;
	private ModelMap modelMap;

	@BeforeEach
	public void setUp() {
		modelMap = new ModelMap();
	}

	@Test
	public void should_return_jsp_view() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setServerName("localhost");
		request.setRequestURI("/");

		String view = controller.home(request, modelMap);
		Assertions.assertEquals("index-jsp", view);
	}

	@Test
	public void should_return_other_view() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setServerName("localhost");
		request.setRequestURI("/test");

		final String view = controller.showList(request, "test", modelMap);
		Assertions.assertEquals("index-test", view);
	}

}
