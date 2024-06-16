package org.kurt.util;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

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
