package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.kurt.teaches.sort.bubblesort.BubbleSort.bubbleSort;
import org.kurt.util.Swapper;

public class TestBubbleSort {

  @Test
  public void testBubbleSort() {
      Swapper swapper = new Swapper();
      assertArrayEquals(new int[] {3, 3, 4, 4, 5, 5,6, 7, 123}, bubbleSort(new int[] {7, 6, 5, 123, 3, 4, 5, 3, 4},swapper));
      assertTrue(swapper.swaps<100, String.format("Number of swaps was %d", swapper.swaps));
  }
}
