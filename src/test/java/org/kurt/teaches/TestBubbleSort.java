package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.kurt.teaches.sort.bubblesort.BubbleSort.bubbleSort;

import org.junit.jupiter.api.Test;
import org.kurt.util.Swapper;

public class TestBubbleSort {

  @Test
  public void testBubbleSort() {
    Swapper swapper = new Swapper();
    int[] testArray = new int[] {7, 6, 5, 123, 3, 4, 5, 3, 4};
    bubbleSort(testArray, swapper);
    assertArrayEquals(new int[] {3, 3, 4, 4, 5, 5, 6, 7, 123}, testArray);
    assertTrue(swapper.swaps < 100, String.format("Number of swaps was %d", swapper.swaps));
  }
}
