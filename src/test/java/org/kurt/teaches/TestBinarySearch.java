package org.kurt.teaches;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.teaches.search.binary.BinarySearch.*;
import java.util.ArrayList;
import java.util.List;

public class TestBinarySearch {

  @Test
  public void testIndexExists(){
    assertEquals(2, binarySearch(new ArrayList<>(List.of(2,3,4,5,6,7,8,9)), 4));
  }


}
