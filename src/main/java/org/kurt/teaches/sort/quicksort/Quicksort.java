package org.kurt.teaches.sort.quicksort;
import org.kurt.teaches.sort.quicksort.partition.*;

public class Quicksort {
  private Quicksort(){}

  public static void quicksort(int[] unsorted, int left, int right){
    if(right < left){
      return;
    }
    Partition partition = new HalfPartition();
    int partitionKey = partition.partition(unsorted, left, right);
    quicksort(unsorted, left, partitionKey-1);
    quicksort(unsorted, partitionKey+1, right);
  }
}
