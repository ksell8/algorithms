package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurt.teaches.sort.quicksort.QuickSort;
import org.kurt.teaches.sort.quicksort.partition.PartitionType;
import org.kurt.util.BaseTest;

public class TestQuickSort  extends BaseTest {
  private QuickSort sort;

  @Override
  protected Class<?> getClassUnderTest() {
    return QuickSort.class;
  }

  @BeforeEach
  public void setupSort() {
    sort = new QuickSort(PartitionType.HALF);
  }

  @Test
  public void testQuicksort() {
    int[] testArray = new int[] {7, 6, 5, 123, 3, 4, 5, 3, 4};
    sort.sort(testArray);
    assertArrayEquals(new int[] {3, 3, 4, 4, 5, 5, 6, 7, 123}, testArray);
    System.out.println(String.format("swaps: %d", sort.getPartition().getSwapper().getSwaps()));
    assertTrue(sort.getPartition().getSwapper().getSwaps() < 25);
  }

}
