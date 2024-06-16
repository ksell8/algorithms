package org.kurt.teaches;

import static org.junit.jupiter.api.Assertions.*;
import static org.kurt.teaches.Fibonacci.*;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 *
 *
 * <h1>Beginners Start your Test Driven Development Journey Here</h1>
 *
 * You can write a whole bunch of code, but without tests it's very hard to know you satisfied all
 * cases your program will encounter without manually testing each one. Without automated testing
 * you will have to run every single test case manually each time you want to make a change! <iframe
 * src="https://giphy.com/embed/IxLeSDtUaZRmSiyCTf" width="480" height="317" style=""
 * frameBorder="0" class="giphy-embed" allowFullScreen></iframe> It is best to write tests once each
 * time you add a new feature. Test Driven Design suggests the ideal behavior is to write the test
 * before implementing a feature. Start out with it failing and then work to get it to pass.
 *
 * <h2>Exercises</h2>
 *
 * There is one test failing in this test suite! It's your job to diagnosis it!
 *
 * <h3>Run Tests From the Terminal:</h3>
 *
 * The terminal is how to interface with your computer without a GUI (graphical user interface). A
 * terminal is also called a command line. And tools called CLIs or command line interfaces are run
 * against them.
 *
 * <ol>
 *   <li>Download the <a href="https://github.com/ksell8/algorithms.git">source code.</a>.<br>
 *       To get the source code on to your computer you need to install a tool called git. It is
 *       likely git will already exist on your computer. You can check by entering {@code which git}
 *       in your terminal (on windows use {@code where git} or hop into Powershell). <br>
 *       If it exists congrats, run {@code git clone https://github.com/ksell8/algorithms.git}.<br>
 *       Else, case(operating_system):
 *       <ul>
 *         <li>Mac: if you have xcode: {@code xcode-select --install} // will install xcode command
 *             line tools<br>
 *             else if you have brew: {@code brew install git}<br>
 *             else: install xcode from App Store or brew with {@code /bin/bash -c "$(curl -fsSL
 *             https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"}
 *         <li>Linux: it depends what flavor of Linux you have. That distribution will have a
 *             package manager and with that package manager you can install git. Look up "how to
 *             install git on [insert linux distribution]" and there should be answers. But once you
 *             find your package manager it's a good bet the package is called git. <br>
 *             If you don't know what Linux distribution you are running run: {@code cat
 *             /etc/os-release}. The linux distribution is the Name.
 *         <li>Windows: Install using <a href="https://gitforwindows.org/">Git for Windows</a>.
 *       </ul>
 *   <li>OK, you should have a folder now called algorithms! Run {@code ls} or {@code dir} on
 *       windows to list the files in your current working directory. If algorithms does not exist,
 *       try cloning again with git. <br>
 *       We are going to change directory into the algorithms folder using: {@code cd algorithms}.
 *       On Windows the ls equivalent is {@code dir}.<br>
 *       Once you are in the folder run {@code ls -R} or {@code dir /s}. This will recursively list
 *       all the files from the root of the project.<br>
 *       You should see the following hierarchy.<br>
 *       <pre>{@code
 *       .
 * ├── src/
 * │   ├── main/
 * │   │   └── java/
 * │   │       └── org/
 * │   │           ├── you/
 * │   │           │   └── code/
 * │   │           │       └── LIS.java
 * │   │           └── kurt/
 * │   │               ├── teaches/
 * │   │               │   ├── Fib/
 * │   │               │   │   ├── Fibonacci.java
 * │   │               │   │   └── BigNumbers.java
 * │   │               │   ├── sort/
 * │   │               │   │   └── quicksort/
 * │   │               │   │       └── partition
 * │   │               │   └── LIS/
 * │   │               │       └── utils/
 * │   │               │           ├── Max.java
 * │   │               │           └── ProblemInterface.java
 * │   │               └── answers/
 * │   │                   └── LIS.java
 * │   └── test/
 * │       └── java/
 * │           └── org/
 * │               ├── you/
 * │               │   └── code/
 * │               │       └── TestLIS.java
 * │               └── kurt/
 * │                   └── teaches/
 * │                       └── TestFibonacci.java
 * ├── .pre-commit-config.yaml
 * ├── build.gradle.kts
 * ├── properties.gradle.kts
 * ├── gradlew
 * ├── gradle.bat
 * └── .gitignore
 * }</pre>
 *   <li>Run the tests with Gradle.<br>
 *       On *nix (Mac, Linux) flavors run the following:
 *       <pre>{@code
 * ./gradlew build
 *
 * }</pre>
 *       On Windows flavors run:
 *       <pre>{@code
 * execute gradlew.bat build
 *
 * }</pre>
 *       Once you've identified the failing test run only that test:
 *       <pre>{@code
 * test --tests org.kurt.teaches.TestFibonacci.FAILING_TEST_NAME
 * }</pre>
 * </ol>
 *
 * <h3>Diagnose with IDE Debugger:</h3>
 *
 * IDE stands for Integrated Development Environment. This tutorial will help you get one setup and
 * you'll learn how to use the debugger!<br>
 *
 * <ol>
 *   <li>Install the <a href="https://www.jetbrains.com/idea/download/">Community Edition of
 *       Intellij</a> (it's free -- don't download ultimate by accident)! <br>
 *       <a href="https://www.jetbrains.com/idea/download/"><img
 *       src="{@docRoot}/resource-files/Intellij-IDEA-CE.png" alt="screenshot-CE" width=1000px
 *       height=500px> </a> <br>
 *   <li><img alt="green-arrow" src="{@docRoot}/resource-files/green-means-go.png"> Click the green
 *       arrow next to the class definition to run all the tests. <br>
 *       <img alt="failed-run" src="{@docRoot}/resource-files/failed-run.png"> The failed test you
 *       identified from your terminal should now show up as failed. Click the run on the icon next
 *       the failing function name to only run that test.
 *   <li>Add a breakpoint to the first line of the function in Fibonacci.java with the failed test.
 *       <br>
 *       <img alt="breakpoint" src="{@docRoot}/resource-files/breakpoint.png"><br>Clicking the margin
 *       next to the line number will add a breakpoint to the execution for debugging purposes. We
 *       will be able to look into the state of the program and determine the cause for failure.<br>
 *   </li>
 *   <li>
 *      Debug the failing test by right clicking the green arrow and clicking debug.
 *      <img alt="run-debugger" src="{@docRoot}/resource-files/run-debugger.png"><br>
 *      <p>
 *      This will allow the debugger to halt at the breakpoint you added.  The debugger should pop up at the bottom
 *      of your IDE, if not navigate to the lower left corner and click the Debug icon.  Your screen should look like:
 *      </p>
 *      <img alt="run-debugger" src="{@docRoot}/resource-files/debugger.png">
 *      <p>
 *      Clicking on the step-over button (denoted by the pink box) steps to the next step of the function being
 *      debugged, step-into (which is next to it) will step-into the function being called which may use implementations
 *      outside of the function being debugged.
 *      </p>
 *      <br>
 *      <img alt="welcome-to-the-call-stack" src="{@docRoot}/resource-files/call-stack.png" width=1000px height=708px><br>
 *      As you click through the function you will see
 *   </li>
 * </ol>
 *
 *
 * <p>Once you've identified the issue try to fix it in org.kurt.teaches.Fibonacci, rerun the tests
 * until you pass! Ensure all tests pass! You can fix the failing test and fail different tests in
 * turn. Be careful!
 */
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
