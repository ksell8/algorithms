package org.kurt.teaches.sort.quicksort.partition;

public class HalfPartition extends Partition {
  @Override
  public int choosePivot(int[] unsorted, int left, int right) {
    int index = left + right >>> 1;
    int pivot = unsorted[index];
    swapper.swap(unsorted, index, right);
    return pivot;
  }
}
