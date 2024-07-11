package org.kurt.experiments.dynamicProgramming;

import org.kurt.util.LoggerFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeapSpaceOutOfMemory {
  public static final Logger LOGGER = Logger.getLogger(HeapSpaceOutOfMemory.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }

  private HeapSpaceOutOfMemory() {}

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
    int counter = 0;
    try {
      int length = Integer.MAX_VALUE; // 2^31-1
      int[] huge = new int[length];
      for (counter = 0; counter < length; counter++) {
        huge[counter] = counter;
      }
    } catch (OutOfMemoryError e) {
      LOGGER.severe(String.format("Out of Memory after adding %d elements.", counter));
    }
  }

  public static void main(String[] args) {
    arrayOOM();
    arrayListOOM();
  }
}
