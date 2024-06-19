package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.teaches.search.binary.BinarySearch.*;

import org.junit.jupiter.api.Test;

public class TestBinarySearch {

  @Test
  public void testIndexExists() {
    assertEquals(2, binarySearch(new int[] {2, 3, 4, 5, 6, 7, 8, 9}, 4));
  }
}
