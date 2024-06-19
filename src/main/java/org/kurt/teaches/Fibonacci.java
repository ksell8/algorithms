package org.kurt.teaches;

import java.math.BigInteger;
import java.util.logging.Logger;
import org.kurt.util.LoggerUtil;

/**
 * Holds code for Fibonacci algorithm.
 *
 * <H1>What are BigIntegers?</H1>
 *
 * <p>BigInteger are used because they support larger numbers than the primative data types:<br>
 * Max signed long is: 2^63 - 1 (9,223,372,036,854,775,807)<br>
 * Max signed int is: 2^31 - 1 (2,147,483,647)<br>
 * Max unsigned int is: 2^32 - 1 (4,294,967,295)<br>
 * <a
 * href="https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/math/BigInteger.java">Source</a>
 * The have contain an int array called mag that has this definition:
 *
 * <p>The magnitude of this BigInteger, in <i>big-endian</i> order: the zeroth element of this array
 * is the most-significant int of the magnitude. The magnitude must be "minimal" in that the
 * most-significant int ({@code mag[0]}) must be non-zero. This is necessary to ensure that there is
 * exactly one representation for each BigInteger value. Note that this implies that the BigInteger
 * zero has a zero-length mag array.
 *
 * <H1>What are BigIntegers? According to Kurt.</H1>
 *
 * <p>Let's break this complex explanation down, starting with big-endian. <br>
 * All blocks of memory are addressed with a number. Each memory block is 8 bits or 1 byte. A
 * computer reads a set of memory blocks at a time. This set is called a word. Words come in size 32
 * and 64. You should only ever work on a 64 bit laptops. If you are building a robot or another
 * electronic system, you may use 32-bit architectures. Back to the Endians. There are little and
 * big endians. Little endians have the littlest address at the end of the word. And Big endians
 * have the biggest address at the end of the word. <br>
 * Say you have: <br>
 * ! = 2, S = 3, A = 4, N = 5, A = 6, N = 7, A = 8, B = 9 <br>
 * Little endian makes: BANANAS! <br>
 * Big endian makes: !SANANAB <br>
 * The missing piece is what is little endian. And that is the number. So it's going to be an array
 * of unsigned integers. Signed ints have a flip digit as the most significant digit. If the most
 * significant bit is 0 then it is a positive number. If the most significant bit is 1 then it is a
 * negative number. BigInteger has a separate instance variable for tracking sign. Each BigInteger
 * has a radix of 2^32. A radix is the base of a number. For example, our normal everyday numbers
 * hava a radix of 10 and binary has a radix of 2. Unlike binary and decimal, however, there are not
 * 2^32 special characters. Instead, a number with radix 2^32 is given as an array of integers.
 * Unsigned integers have a range of 0 to 2^32. Therefore. to convert an array: [ 4, 4294967295,
 * 4294967295 ] <br>
 * We would do 4*(2^32)^4294967295+4*(2^32)^1+4294967295*(2^32)^0. Note: because it is little endian
 * the 0th element of the array is actually the end. A more generic algorithm given in psuedocode
 * would be: <br>
 *
 * <pre>{@code
 * length = array.length-1
 * for i in array:
 *      array[i]*(2^32)^(length-i)
 * }</pre>
 */
public class Fibonacci {
  private static final Logger LOGGER = LoggerUtil.getLogger();

  private Fibonacci() {} // ensures non-instantiability (static functions only)

  /**
   * This utilizes a loop. The loop is the ideal solution because it only remembers the previous and
   * current number. This is all that is need to find the current+1 fibonacci number. Memory is an
   * important resource in computers, don't remember more than you need!
   *
   * @param fib: int
   * @return BigInteger fib-th fibonacci number
   */
  public static BigInteger fib(int fib) {
    LOGGER.info(String.format("Running fib(%d)", fib));
    if (fib == 0) {
      return BigInteger.ZERO;
    }
    BigInteger curr = BigInteger.ONE;
    BigInteger prev = BigInteger.ZERO;
    for (int incr = 1; incr < fib; incr++) {
      BigInteger newPrev = curr;
      curr = curr.add(prev);
      prev = newPrev;
    }
    LOGGER.info(String.format("Result = %d", curr));
    return curr;
  }

  /**
   * This function uses dynamic programming. Dynamic programming can save time compared to
   * traditional recursion. But, it stores all the numbers up to fib which costs space! Recursion
   * also stores the numbers up to fib in frames!
   *
   * @param fib: int
   * @return BigInteger fib-th fibonacci number
   */
  public static BigInteger fibDynamic(int fib) {
    LOGGER.info(String.format("Running fibDynamic(%d)", fib));
    // TODO for student: add comment about the length of Fib
    BigInteger[] Fib = new BigInteger[fib + 1];
    Fib[0] = BigInteger.ZERO;
    Fib[1] = BigInteger.ONE;
    for (int incr = 2; incr <= fib; incr++) {
      Fib[incr] = Fib[incr - 1].add(Fib[incr - 2]);
    }
    LOGGER.info(String.format("Result = %d", Fib[fib]));
    return Fib[fib];
  }

  /**
   * This function uses terrible recursion. An algorithms professor in college will give you this
   * trash before spoon-feeding you dynamic programming. It's O(2^n) time. &larr; This notation
   * (big-oh) is an upper bound on a particular constraint. Each recursive sub-call computes all the
   * other places in the Fibonacci sequence before it can compute itself and return. This is fine in
   * most cases, it's practically a definition of recursion. But, since this recursive sub-call is
   * recursing 2x each step in the Recursion increases the recursive streams by a multiple of 2!
   *
   * @param fib int
   * @return BigInteger fib-th fibonacci number
   */
  public static BigInteger fibRecursive(int fib) {
    // TODO for student: how many times will this logger run as a function of fib?
    // why is it hard to log the result in this function?
    LOGGER.info(String.format("Running fibRecursive(%d)", fib));
    if (fib == 0) {
      return BigInteger.ZERO;
    } else if (fib == 1) {
      return BigInteger.ONE;
    }
    return fibRecursive(fib - 1).add(fibRecursive(fib - 2));
  }

  /**
   * Java heap space runs out with this call (given max heap 512m). These are the heap settings:
   * -Xms256m (min) -Xmx512m (max). This is why the loop is the better option. It only tracks the
   * information needed to solve Fibonacci! If you run this in an IDE: In your terminal after run
   * (unix flavors only, I don't support Windows): {@code ps aux | grep java}. You may have to
   * manually kill the process: {@code kill $pid}. PID should be the second column after USER.
   *
   * @return BigInteger fibDynamic(1000000)
   */
  public static BigInteger fibHeapOverflow() {
    return fibDynamic(1000000);
  }
}
