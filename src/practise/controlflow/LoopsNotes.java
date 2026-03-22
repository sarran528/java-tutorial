package practise.controlflow;

/*
========================================================
TOPIC: LOOPS IN JAVA (for, while, do-while)
========================================================

Loop = executes a block of code repeatedly
       while a condition is true

Three loop types:
1. for       → known iteration count
2. while     → unknown count, check BEFORE body
3. do-while  → unknown count, check AFTER body

Plus:
4. Enhanced for-each (Java 5+) → iterate collections/arrays

--------------------------------------------------------
1. for LOOP
--------------------------------------------------------

Syntax:
  for (init; condition; update) {
      // body
  }

Execution order:
  1. init → runs ONCE at start
  2. condition → checked BEFORE each iteration
  3. body → runs if condition is true
  4. update → runs AFTER each iteration
  5. Go to step 2

All three parts (init, condition, update) are optional
  for (;;) { }   ← infinite loop

--------------------------------------------------------
2. while LOOP
--------------------------------------------------------

Syntax:
  while (condition) {
      // body
  }

• Condition checked BEFORE body → may never execute
• Use when iteration count is unknown

--------------------------------------------------------
3. do-while LOOP
--------------------------------------------------------

Syntax:
  do {
      // body
  } while (condition);    ← note the semicolon!

• Body runs AT LEAST ONCE (condition checked after)
• Good for input validation (ask, then check)

--------------------------------------------------------
4. ENHANCED for-each (Java 5+)
--------------------------------------------------------

Syntax:
  for (type element : collection) {
      // use element
  }

• Works with arrays and Iterable collections
• Read-only: cannot modify array via loop variable
• No index access (use regular for if you need index)

--------------------------------------------------------
5. INFINITE LOOPS
--------------------------------------------------------

for (;;) { }                // infinite for
while (true) { }            // infinite while
do { } while (true);        // infinite do-while

Must use break to exit — otherwise runs forever

--------------------------------------------------------
6. LOOP COMPARISON TABLE
--------------------------------------------------------

LOOP       CONDITION CHECK   MIN RUNS   BEST FOR
-----------------------------------------------------
for        Before body       0          Known count
while      Before body       0          Unknown count
do-while   After body        1          At-least-once
for-each   Implicit          0*         Collections/arrays

 * 0 if collection is empty

--------------------------------------------------------
7. KEY PITFALLS
--------------------------------------------------------

- Off-by-one errors (< vs <=)
- Forgetting to update loop variable → infinite loop
- Modifying collection during for-each → ConcurrentModificationException
- do-while needs semicolon after while(condition);
- for-each gives COPY of element (for primitives)
- Nested loops: O(n²) time complexity — be careful

========================================================
*/

public class LoopsNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  LOOPS IN JAVA — COMPREHENSIVE DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. BASIC for LOOP
        // ============================================

        System.out.println("--- 1. Basic for Loop ---");

        // Print 1 to 5
        System.out.print("1 to 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Countdown
        System.out.print("Countdown: ");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Custom step
        System.out.print("Even numbers (2-10): ");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");


        // ============================================
        // 2. for LOOP VARIATIONS
        // ============================================

        System.out.println("--- 2. for Loop Variations ---");

        // Multiple variables
        System.out.print("Two pointers: ");
        for (int left = 0, right = 10; left < right; left++, right--) {
            System.out.print("[" + left + "," + right + "] ");
        }
        System.out.println();

        // Empty parts (all are optional)
        int k = 0;
        System.out.print("No init/update: ");
        for (; k < 3; ) {
            System.out.print(k + " ");
            k++;
        }
        System.out.println();

        // Loop body does nothing (semicolon body)
        int sum = 0;
        for (int i = 1; i <= 100; sum += i, i++) ;  // sum 1-100 in the update
        System.out.println("Sum 1-100 (in for-update): " + sum);
        System.out.println();


        // ============================================
        // 3. while LOOP
        // ============================================

        System.out.println("--- 3. while Loop ---");

        // Count digits in a number
        int number = 123456;
        int digits = 0;
        int temp = number;
        while (temp > 0) {
            digits++;
            temp /= 10;
        }
        System.out.println("Digits in " + number + ": " + digits);

        // Reverse a number
        int original = 12345;
        int reversed = 0;
        temp = original;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Reverse of " + original + ": " + reversed);

        // while that never executes
        int x = 10;
        while (x < 5) {
            System.out.println("This never prints");
        }
        System.out.println("while(10 < 5): body never executes");
        System.out.println();


        // ============================================
        // 4. do-while LOOP
        // ============================================

        System.out.println("--- 4. do-while Loop ---");

        // Always executes at least once
        int count = 0;
        do {
            count++;
            System.out.println("  do-while iteration: " + count);
        } while (count < 3);

        // Executes once even when condition is false
        int val = 100;
        do {
            System.out.println("  Runs even though " + val + " >= 50");
        } while (val < 50);     // false, but body already ran once

        System.out.println();


        // ============================================
        // 5. ENHANCED for-each LOOP
        // ============================================

        System.out.println("--- 5. Enhanced for-each ---");

        // Array
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.print("Array: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // String array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for (String fruit : fruits) {
            System.out.println("  Fruit: " + fruit);
        }

        // 2D array
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("2D array:");
        for (int[] row : matrix) {
            System.out.print("  ");
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();


        // ============================================
        // 6. INFINITE LOOP (controlled with break)
        // ============================================

        System.out.println("--- 6. Infinite Loop with Break ---");

        int counter = 0;
        while (true) {
            counter++;
            if (counter > 5) {
                System.out.println("  Breaking at counter = " + counter);
                break;
            }
            System.out.println("  counter = " + counter);
        }
        System.out.println();


        // ============================================
        // 7. PRACTICAL EXAMPLES
        // ============================================

        System.out.println("--- 7. Practical Examples ---");

        // Factorial
        int n = 5;
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(n + "! = " + factorial);

        // Fibonacci (first 10 numbers)
        System.out.print("Fibonacci: ");
        int fib1 = 0, fib2 = 1;
        for (int i = 0; i < 10; i++) {
            System.out.print(fib1 + " ");
            int next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
        }
        System.out.println();

        // Sum of digits
        int numForSum = 9876;
        int digitSum = 0;
        temp = numForSum;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        System.out.println("Sum of digits of " + numForSum + " = " + digitSum);

        // Power of 2 check
        int powerCheck = 64;
        boolean isPower = powerCheck > 0;
        temp = powerCheck;
        while (temp > 1 && isPower) {
            if (temp % 2 != 0) isPower = false;
            temp /= 2;
        }
        System.out.println(powerCheck + " is power of 2? " + isPower);
        System.out.println();


        // ============================================
        // 8. LOOP PERFORMANCE COMPARISON
        // ============================================

        System.out.println("--- 8. Loop Performance Note ---");

        int[] data = new int[1_000_000];
        for (int i = 0; i < data.length; i++) { data[i] = i; }

        // for loop
        long start = System.nanoTime();
        long total = 0;
        for (int i = 0; i < data.length; i++) { total += data[i]; }
        long forTime = System.nanoTime() - start;

        // for-each loop
        start = System.nanoTime();
        total = 0;
        for (int d : data) { total += d; }
        long forEachTime = System.nanoTime() - start;

        System.out.println("for loop:      " + forTime + " ns");
        System.out.println("for-each loop: " + forEachTime + " ns");
        System.out.println("(Performance is similar — for-each is just syntactic sugar)");


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• for   → known count, most flexible");
        System.out.println("• while → check before body, may not run");
        System.out.println("• do-while → runs at least once");
        System.out.println("• for-each → cleanest for arrays/collections");
        System.out.println("• Infinite loops need break to exit");
        System.out.println("• Watch for off-by-one errors (< vs <=)");
        System.out.println("• for-each cannot modify underlying array");
    }
}
