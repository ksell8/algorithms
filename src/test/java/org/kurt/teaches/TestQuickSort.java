package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.kurt.teaches.sort.quicksort.Quicksort.quicksort;

import org.junit.jupiter.api.Test;

public class TestQuickSort {

  @Test
  public void testQuicksort() {
    int[] testArray = new int[] {7, 6, 5, 123, 3, 4, 5, 3, 4};
    quicksort(testArray, 0, testArray.length - 1);
    assertArrayEquals(new int[] {3, 3, 4, 4, 5, 5, 6, 7, 123}, testArray);
  }
}
