package org.kurt.teaches.search.binary;

import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class BinarySearch {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  private BinarySearch() {}

  /**
   * Modified from <a
   * href="https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/Collections.java#L221">OpenJDK
   * Binary Search</a>.
   *
   * @param array: ArrayList sorted array to search -- must be sorted!
   * @param variable: int
   * @return int
   */
  public static int binarySearch(int[] array, int variable) {
    LOGGER.finest(String.format("searching for %d", variable));
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      LOGGER.finest(String.format("high: %d, low: %d", high, low));
      int mid = (low + high) >>> 1;
      int midVal = array[mid];
      LOGGER.finest(String.format("Checking against middle value %d", midVal));
      if (variable > midVal) low = mid + 1;
      else if (variable < midVal) high = mid - 1;
      else return mid; // key found
    }
    return -low; // key not found
  }
}
