package org.kurt.teaches.sort.quicksort;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kurt.teaches.sort.Sort;
import org.kurt.teaches.sort.quicksort.partition.*;
import org.kurt.util.LoggerFormatter;

public class QuickSort implements Sort {
  public static final Logger LOGGER = Logger.getLogger(QuickSort.class.getName());

  static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter(new LoggerFormatter());
    LOGGER.addHandler(handler);
    LOGGER.setLevel(Level.INFO);
  }
  private Partition partition;

  public QuickSort(PartitionType type) {
    if (type == PartitionType.HALF) {
      partition = new HalfPartition();
    }
  }

  @Override
  public void sort(int[] unsorted) {
    quicksort(unsorted, 0, unsorted.length - 1);
    LOGGER.info(String.format("You used %d swaps.", partition.getSwapper().getSwaps()));
  }

  public void quicksort(int[] unsorted, int left, int right) {
    if (right < left) {
      return;
    }
    int partitionKey = partition.partition(unsorted, left, right);
    quicksort(unsorted, left, partitionKey - 1);
    quicksort(unsorted, partitionKey + 1, right);
  }

  public Partition getPartition() {
    return partition;
  }
}
