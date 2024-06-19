package org.kurt.teaches.sort.bubblesort;

import java.util.logging.Logger;
import org.kurt.teaches.sort.Sort;
import org.kurt.util.LoggerUtil;
import org.kurt.util.Swapper;

public class BubbleSort implements Sort {
  private static final Logger LOGGER = LoggerUtil.getLogger();
  private Swapper swapper;

  public BubbleSort() {
    swapper = new Swapper();
  }

  @Override
  public void sort(int[] unsorted) {
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
    LOGGER.info(String.format("You used %d swaps.", swapper.getSwaps()));
  }

  public Swapper getSwapper() {
    return swapper;
  }
}
