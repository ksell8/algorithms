package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.teaches.search.binary.BinarySearch.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestBinarySearch {

  @Test
  public void testIndexExists() {
    assertEquals(2, binarySearch(new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 8, 9)), 4));
  }
}
