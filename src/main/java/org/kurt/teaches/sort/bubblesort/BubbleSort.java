package org.kurt.teaches.sort.bubblesort;

import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;
import org.kurt.util.Swapper;

public class BubbleSort {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  public static void bubbleSort(int[] unsorted, Swapper swapper) {
    int length = unsorted.length;
    boolean swapped;
    do {
      swapped = false;
      for (int i = 0; i < length - 1; i++) {
        if (unsorted[i] > unsorted[i + 1]) {
          swapper.swap(unsorted, i, i + 1);
          swapped = true;
        }
      }
    } while (swapped);
  }
}
