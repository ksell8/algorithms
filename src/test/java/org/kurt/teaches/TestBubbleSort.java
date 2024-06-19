package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurt.teaches.sort.bubblesort.BubbleSort;

public class TestBubbleSort {
  private BubbleSort sort;

  @BeforeEach
  public void setupSort() {
    // re-initialize before each test
    sort = new BubbleSort();
  }

  @Test
  public void testBubbleSort() {
    int[] testArray = new int[] {7, 6, 5, 123, 3, 4, 5, 3, 4};
    sort.sort(testArray);
    assertArrayEquals(new int[] {3, 3, 4, 4, 5, 5, 6, 7, 123}, testArray);
    assertTrue(
        sort.getSwapper().getSwaps() < 25,
        String.format("Number of swaps was %d", sort.getSwapper().getSwaps()));
  }
}
