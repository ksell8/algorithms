package org.kurt.teaches.nonGenericIntArrays;

public class IntArray {
  private int[] elementData;
  private int capacity;

  public IntArray(int[] array) {
    elementData = array;
    capacity = array.length;
  }

  /**
   * TODO: explain how System.java is implemented using IntrinsicCandidate
   * @param o
   * @param n
   * @param startingIndex
   * @param length
   */
  public static void copyTo(int[] o, int[] n, int startingIndex, int length) {
    System.arraycopy(o, startingIndex, n, startingIndex, length);
  }

  public void grow(int desiredCapacity) {
    if (desiredCapacity > capacity) {
      int[] newArray = new int[desiredCapacity];
      copyTo(elementData, newArray, 0, capacity);
      elementData = newArray;
      capacity = desiredCapacity;
    }
  }

  public void put(int index, int value) {
    if (index < capacity) {
      elementData[index] = value;
    } else {
      throw new IndexOutOfBoundsException(
          "IntArray.put(int index, int toAdd) does not support growing capacity greater than 1. Use"
              + " IntArray.append(int value).");
    }
  }

  public void append(int item) {
    grow(capacity + 1);
    elementData[capacity - 1] = item;
  }

  public int get(int index) {
    return elementData[index];
  }

  /**
   * Returns the maximum element of the given int[].
   *
   * <p>This method iterates over the entire array, hence it requires time proportional to the size
   * of the array.
   *
   * @return the maximum element of the int[].
   */
  public int max() {
    int candidate = 0;
    for (int i = 0; i < capacity; i++) {
      candidate =
          elementData[i] > candidate
              ? elementData[i]
              : candidate; // equivalent to Math.max(int,int)
    }
    return candidate;
  }

  // note: this will need to be redefined for the student activity
  public int size() {
    return capacity;
  }

  public int[] toArray() {
    return elementData;
  }
}
