package org.kurt.teaches;

import org.kurt.util.BaseTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.kurt.answers.LCS.LCS;

public class TestLCS  extends BaseTest {

  @Override
  protected Class<?> getClassUnderTest() {
    return  org.kurt.answers.LCS.class;
  }

  @Test
  public void testABCs(){
    String x = "abcdefg";
    String y = "cdefgwx";
    assertEquals(5, LCS(x,y));
  }

  @Test
  public void testGeorgiaTechProblem(){
    String x = "bcdbcda";
    String y = "abecbab";
    assertEquals(4, LCS(x,y));
  }

  @Test
  public void testEmptyStrings(){
    String x = "";
    String y = "";
    assertEquals(0, LCS(x,y));
  }

  @Test
  public void testOneEmptyString(){
    String x = "";
    String y = "Hello, world";
    assertEquals(0, LCS(x,y));
  }

}
