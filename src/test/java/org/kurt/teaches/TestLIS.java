package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.answers.LIS.*;

import org.junit.jupiter.api.Test;

public class TestLIS {

  @Test
  public void testGeorgiaTechProblem() {
    int[] seq = {5, 7, 4, -3, 9, 1, 10, 4, 5, 8, 9, 3};
    assertEquals(6, longestIncreasingSubsequence(seq));
  }
}
