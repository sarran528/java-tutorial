package practise.controlflow;

/*
========================================================
TOPIC: break, continue, return — FLOW CONTROL KEYWORDS
========================================================

These keywords alter the normal flow of execution
within loops and methods.

1. break     → EXIT the loop/switch immediately
2. continue  → SKIP rest of current iteration, go to next
3. return    → EXIT the method entirely

Plus:
4. Labeled break/continue → control nested loops

--------------------------------------------------------
1. break
--------------------------------------------------------

Usage:
  - In loops: exits the INNERMOST loop
  - In switch: exits the switch block

Cannot be used outside loops or switch → compile error

--------------------------------------------------------
2. continue
--------------------------------------------------------

Usage:
  - In loops: skips remaining body of CURRENT iteration
  - Goes directly to the update (for) or condition (while)

Cannot be used outside loops → compile error
NOT valid inside switch (unless switch is inside a loop)

--------------------------------------------------------
3. return
--------------------------------------------------------

Usage:
  - Exits the current METHOD immediately
  - void methods: return;
  - Non-void: return value;

Can exit loops implicitly (since it exits the method)

--------------------------------------------------------
4. LABELED break / continue
--------------------------------------------------------

Syntax:
  label:
  for (...) {
      for (...) {
          break label;      // exits the LABELED loop
          continue label;   // continues the LABELED loop
      }
  }

• Useful for controlling NESTED loops
• Label must be immediately before a loop
• Labeled break can also exit labeled blocks { }

--------------------------------------------------------
5. COMPARISON TABLE
--------------------------------------------------------

KEYWORD       SCOPE            EFFECT
--------------------------------------------------
break         loop/switch      Exit immediately
continue      loop             Skip to next iteration
return        method           Exit method
break label   labeled loop     Exit labeled loop
continue label  labeled loop   Next iteration of label

--------------------------------------------------------
6. KEY PITFALLS
--------------------------------------------------------

- break exits ONLY the innermost loop (use label for outer)
- continue in for loop: update still runs! (i++ executes)
- continue in while loop: make sure update happens BEFORE
  continue, otherwise infinite loop!
- return in finally block overrides exceptions (bad practice)
- Too many break/continue makes code hard to read
  → consider refactoring to methods instead

========================================================
*/

public class BreakContinueReturnNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  break / continue / return — DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. break IN A LOOP
        // ============================================

        System.out.println("--- 1. break in Loop ---");

        // Find first multiple of 7 in range 1-100
        System.out.print("First multiple of 7: ");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
                break;    // exit loop immediately
            }
        }

        // break exits only innermost loop
        System.out.print("break exits innermost: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) break;    // only exits inner loop
                System.out.print("[" + i + "," + j + "] ");
            }
        }
        System.out.println("  (j never reaches 2)");
        System.out.println();


        // ============================================
        // 2. break IN switch
        // ============================================

        System.out.println("--- 2. break in switch ---");

        int day = 3;
        switch (day) {
            case 1: System.out.println("  Monday");    break;
            case 2: System.out.println("  Tuesday");   break;
            case 3: System.out.println("  Wednesday"); break;  // ← stops here
            case 4: System.out.println("  Thursday");  break;
            default: System.out.println("  Other");
        }
        System.out.println();


        // ============================================
        // 3. continue IN for LOOP
        // ============================================

        System.out.println("--- 3. continue in for Loop ---");

        // Print only odd numbers 1-10
        System.out.print("Odd numbers: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;   // skip even numbers
            System.out.print(i + " ");
        }
        System.out.println();

        // Skip a specific value
        System.out.print("Skip 5: ");
        for (int i = 1; i <= 7; i++) {
            if (i == 5) continue;
            System.out.print(i + " ");
        }
        System.out.println("\n");


        // ============================================
        // 4. continue IN while LOOP (CAREFUL!)
        // ============================================

        System.out.println("--- 4. continue in while Loop ---");

        // CORRECT: update BEFORE continue
        System.out.print("Skip multiples of 3: ");
        int i = 0;
        while (i < 10) {
            i++;                         // update FIRST
            if (i % 3 == 0) continue;   // then skip
            System.out.print(i + " ");
        }
        System.out.println();

        // WRONG pattern (would cause infinite loop):
        // int j = 0;
        // while (j < 10) {
        //     if (j == 5) continue;  // j never increments past 5!
        //     j++;
        // }

        System.out.println("(In while, update before continue to avoid infinite loop!)");
        System.out.println();


        // ============================================
        // 5. LABELED break (Nested Loop Control)
        // ============================================

        System.out.println("--- 5. Labeled break ---");

        System.out.println("Search for value 5 in 2D array:");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        boolean found = false;
        outerLoop:                         // label
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 5) {
                    System.out.println("  Found 5 at [" + row + "][" + col + "]");
                    found = true;
                    break outerLoop;       // exits BOTH loops
                }
            }
        }
        if (!found) System.out.println("  Not found");
        System.out.println();


        // ============================================
        // 6. LABELED continue (Nested Loop Control)
        // ============================================

        System.out.println("--- 6. Labeled continue ---");

        System.out.println("Skip entire row if it contains a negative:");
        int[][] data = {
            {1, 2, 3},
            {4, -1, 6},      // this row has negative
            {7, 8, 9}
        };

        outer:
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col] < 0) {
                    System.out.println("  Row " + row + ": skipped (has negative)");
                    continue outer;        // skip to next ROW
                }
            }
            System.out.print("  Row " + row + ": ");
            for (int val : data[row]) System.out.print(val + " ");
            System.out.println();
        }
        System.out.println();


        // ============================================
        // 7. LABELED break WITH BLOCK (not just loops)
        // ============================================

        System.out.println("--- 7. Labeled break with Block ---");

        searchBlock: {
            int[] arr = {10, 20, 30, 40};
            for (int val : arr) {
                if (val == 30) {
                    System.out.println("  Found 30, breaking out of labeled block");
                    break searchBlock;
                }
            }
            System.out.println("  This won't print if 30 is found");
        }
        System.out.println("  After labeled block");
        System.out.println();


        // ============================================
        // 8. return IN void METHOD
        // ============================================

        System.out.println("--- 8. return in void method ---");
        printPositive(-5);
        printPositive(10);
        System.out.println();


        // ============================================
        // 9. return IN non-void METHOD
        // ============================================

        System.out.println("--- 9. return in non-void method ---");
        System.out.println("Max of 10, 20: " + max(10, 20));
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("Is 12 prime? " + isPrime(12));
        System.out.println();


        // ============================================
        // 10. return EXITS LOOP (via exiting method)
        // ============================================

        System.out.println("--- 10. return exits loop (exits method) ---");

        int firstNeg = findFirstNegative(new int[]{3, 7, -2, 5});
        System.out.println("First negative: " + firstNeg);

        firstNeg = findFirstNegative(new int[]{3, 7, 5});
        System.out.println("First negative: " + firstNeg + " (none found)");
        System.out.println();


        // ============================================
        // 11. PRACTICAL PATTERNS
        // ============================================

        System.out.println("--- 11. Common Patterns ---");

        // Pattern: Search with early exit
        int[] nums = {2, 4, 6, 8, 10};
        boolean hasOdd = false;
        for (int num : nums) {
            if (num % 2 != 0) {
                hasOdd = true;
                break;     // no need to check rest
            }
        }
        System.out.println("Array has odd number: " + hasOdd);

        // Pattern: Filter with continue
        System.out.print("Uppercase only from 'Hello World 123': ");
        String text = "Hello World 123";
        for (char c : text.toCharArray()) {
            if (!Character.isUpperCase(c)) continue;
            System.out.print(c);
        }
        System.out.println();

        // Pattern: Sentinel loop with break
        System.out.print("Powers of 2 until > 1000: ");
        int power = 1;
        while (true) {
            System.out.print(power + " ");
            power *= 2;
            if (power > 1000) break;
        }
        System.out.println();


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• break   → exits innermost loop/switch");
        System.out.println("• continue→ skips to next iteration");
        System.out.println("• return  → exits the entire method");
        System.out.println("• Labeled break/continue → control outer loops");
        System.out.println("• continue in while → update before continue!");
        System.out.println("• Prefer methods over labels for readability");
    }


    // --- Helper Methods for return demos ---

    /** return in void method — early exit */
    static void printPositive(int n) {
        if (n <= 0) {
            System.out.println("  printPositive(" + n + "): skipped (not positive)");
            return;    // exit method early
        }
        System.out.println("  printPositive(" + n + "): " + n + " is positive!");
    }

    /** return in non-void method — returns a value */
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /** Multiple return points */
    static boolean isPrime(int n) {
        if (n < 2) return false;           // early return
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;  // found divisor
        }
        return true;                       // no divisor found
    }

    /** return exits loop implicitly */
    static int findFirstNegative(int[] arr) {
        for (int val : arr) {
            if (val < 0) return val;       // exits loop AND method
        }
        return Integer.MAX_VALUE;          // sentinel: none found
    }
}
