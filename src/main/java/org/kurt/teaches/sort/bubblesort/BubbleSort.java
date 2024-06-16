package org.kurt.teaches.sort.bubblesort;

import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class BubbleSort {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  public static int[] bubbleSort(int[] unsorted) {
    int length = unsorted.length;
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < length - 1; i++) {
        if (unsorted[i] > unsorted[i + 1]) {
          swap(unsorted, i, i + 1);
          swapped = true;
        }
      }
    } while (swapped);
    return unsorted;
  }

  public static void swap(int[] toSwap, int index1, int index2) {
    int var1 = toSwap[index1];
    toSwap[index1] = toSwap[index2];
    toSwap[index2] = var1;
  }
}
