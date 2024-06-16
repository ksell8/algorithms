package org.kurt.util;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.fail;


public abstract class BaseTest {

  @BeforeEach
  public void checkForRestrictedMethods() {
    try {
      BytecodeInspector.inspectClassForRestrictedMethods(getClassUnderTest());
    } catch (AssertionError e) {
      fail(e.getMessage());
    }
  }

  protected abstract Class<?> getClassUnderTest();

}