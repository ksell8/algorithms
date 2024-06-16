package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.answers.LIS.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kurt.util.BaseTest;
import org.kurt.util.IntArrayFunction;

public class TestLIS extends BaseTest {

  @Override
  protected Class<?> getClassUnderTest() {
    return org.kurt.answers.LIS.class;
  }

  // functions to test
  static Stream<Arguments> provideFunctions() {
    return Stream.of(
        Arguments.of(longestIncreasingSubsequence),
        Arguments.of(longestIncreasingSubsequenceQuick));
  }

  @ParameterizedTest(name = "lis={0}")
  @MethodSource("provideFunctions")
  public void testGeorgiaTechProblem(IntArrayFunction lis) {
    int[] seq = {5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3};
    assertEquals(6, lis.run(seq));
  }

  @ParameterizedTest(name = "lis={0}")
  @MethodSource("provideFunctions")
  public void testKurtsProblem(IntArrayFunction lis) {
    assertEquals(5, lis.run(new int[] {4, 7, 5, -4, -3, 2, 10, 9, 11}));
  }

  @ParameterizedTest(name = "lis={0}")
  @MethodSource("provideFunctions")
  public void testKurtsProblem2(IntArrayFunction lis) {
    assertEquals(5, lis.run(new int[] {8, 5, -2, 4, 5, 3, 4, 7, 9, 5}));
  }
}
