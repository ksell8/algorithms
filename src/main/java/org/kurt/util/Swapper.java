package org.kurt.util;

public class Swapper {
  public int swaps = 0;

  public void swap(int[] toSwap, int index1, int index2) {
    int var1 = toSwap[index1];
    toSwap[index1] = toSwap[index2];
    toSwap[index2] = var1;
    swaps++;
  }
}
