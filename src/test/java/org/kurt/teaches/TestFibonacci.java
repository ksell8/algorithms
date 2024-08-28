package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.teaches.Fibonacci.*;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class TestFibonacci {

  // ===========================================================================
  // Tests for fib()
  // ===========================================================================
  @Test
  public void test10thFib() {
    assertEquals(BigInteger.valueOf(55), fib(10));
  }

  @Test
  public void test0thFib() {
    assertEquals(BigInteger.ZERO, fib(0));
  }

  @Test
  public void test1stFib() {
    assertEquals(BigInteger.ONE, fib(1));
  }

  @Test
  public void test2ndFib() {
    assertEquals(BigInteger.ONE, fib(2));
  }

  @Test
  public void test100thFib() {
    // value found at: https://planetmath.org/listoffibonaccinumbers
    assertEquals(new BigInteger("354224848179261915075"), fib(100));
  }

  @Test
  public void test500thFib() {
    assertEquals(
        new BigInteger(
            "139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125"),
        fib(500));
  }

  // ===========================================================================
  // Tests for fibRecursive()
  // ===========================================================================

  @Test
  public void test3rdFibRecursive() {
    assertEquals(BigInteger.valueOf(2), fibRecursive(3));
  }

  @Test
  public void test4thFibRecursive() {
    assertEquals(BigInteger.valueOf(3), fibRecursive(4));
  }

  @Test
  public void test5thFibRecursive() {
    assertEquals(BigInteger.valueOf(5), fibRecursive(5));
  }

  @Test
  public void test10thFibRecursive() {
    assertEquals(BigInteger.valueOf(55), fibRecursive(10));
  }

  @Test
  public void test0thFibRecursive() {
    assertEquals(BigInteger.ZERO, fibRecursive(0));
  }

  @Test
  public void test1stFibRecursive() {
    assertEquals(BigInteger.ONE, fibRecursive(1));
  }

  @Test
  public void test2ndFibRecursive() {
    assertEquals(BigInteger.ONE, fibRecursive(2));
  }

  // ===========================================================================
  // Tests for fibDynamic()
  // ===========================================================================

  @Test
  public void test10thFibDynamic() {
    assertEquals(BigInteger.valueOf(55), fibRecursive(10));
  }

  @Test
  public void test0thFibDynamic() {
    assertEquals(BigInteger.ZERO, fibDynamic(0));
  }

  @Test
  public void test1stFibDynamic() {
    assertEquals(BigInteger.ONE, fibDynamic(1));
  }

  @Test
  public void test2ndFibDynamic() {
    assertEquals(BigInteger.ONE, fibDynamic(2));
  }

  @Test
  public void test100thFibDynamic() {
    // value found at: https://planetmath.org/listoffibonaccinumbers
    assertEquals(new BigInteger("354224848179261915075"), fibDynamic(100));
  }

  @Test
  public void test500thFibDynamic() {
    assertEquals(
        new BigInteger(
            "139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125"),
        fibDynamic(500));
  }
}
