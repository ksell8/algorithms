package org.kurt.teaches.sort.quicksort.partition;

import org.kurt.util.Swapper;

public abstract class Partition {

  public Swapper swapper;

  public Partition() {
    swapper = new Swapper();
  }

  public abstract int choosePivot(int[] unsorted, int left, int right);

  public int partition(int[] unsorted, int left, int right) {
    int pivot = choosePivot(unsorted, left, right);

    int index = left; // where should the pivot end up?
    for (int i = left; i < right; i++) {
      if (unsorted[i] <= pivot) {
        swapper.swap(unsorted, index, i);
        index++;
      }
    }
    swapper.swap(unsorted, index, right);
    return index;
  }
}
