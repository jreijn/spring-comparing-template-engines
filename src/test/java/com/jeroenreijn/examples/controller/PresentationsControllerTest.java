package com.jeroenreijn.examples.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;

public class PresentationsControllerTest {

  private PresentationsController controller;
  private ModelMap modelMap;

  @Before
  public void setUp() throws Exception {
    controller = new PresentationsController();
    modelMap = new ModelMap();
  }

  @Test
  public void should_return_jsp_view() throws Exception {
    final String view = controller.home(modelMap);
    assertEquals("index-jsp", view);
  }

  @Test
  public void should_return_other_view() throws Exception {
    final String view = controller.showList("test", modelMap);
    assertEquals("index-test", view);
  }

}
