package org.kurt.experiments.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

public class HeapSpaceOutOfMemory {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  private HeapSpaceOutOfMemory() {}
  ;

  public static void arrayListOOM() {
    List<Integer> list = new ArrayList<>();
    int counter = 0;
    try {
      while (true) {
        list.add(counter++);
      }
    } catch (OutOfMemoryError e) {
      LOGGER.severe(String.format("Out of Memory after adding %d elements.", counter));
    }
  }

  public static void arrayOOM() {
    int length = Integer.MAX_VALUE; // 2^31-1
    int[] huge = new int[length];
    int counter = 0;
    try {
      for (counter = 0; counter < length; counter++) {
        huge[counter] = counter;
      }
    } catch (OutOfMemoryError e) {
      LOGGER.severe(String.format("Out of Memory after adding %d elements.", counter));
    }
  }

  public static void main(String[] args) {
    // arrayOOM();
    arrayListOOM();
  }
}
