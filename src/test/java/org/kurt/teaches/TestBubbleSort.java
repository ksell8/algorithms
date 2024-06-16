package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.kurt.teaches.sort.bubblesort.BubbleSort.bubbleSort;

import org.junit.jupiter.api.Test;

public class TestBubbleSort {

  @Test
  public void testBubbleSort() {
    assertArrayEquals(new int[] {5, 6, 7}, bubbleSort(new int[] {7, 6, 5}));
  }
}
