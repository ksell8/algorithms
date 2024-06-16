package org.kurt.teaches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.kurt.teaches.sort.bubblesort.BubbleSort.bubbleSort;

public class TestBubbleSort {

  @Test
  public void testBubbleSort(){
    assertArrayEquals(new int[]{5,6,7}, bubbleSort(new int[]{7,6,5}));
  }
}
