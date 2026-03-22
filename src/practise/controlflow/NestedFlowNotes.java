package practise.controlflow;

/*
========================================================
TOPIC: NESTED FLOW STRUCTURES
========================================================

Nesting = placing one control structure inside another

Common nesting patterns:
1. Nested if inside if
2. Nested loops (for inside for)
3. Loop + if combination
4. Nested switch
5. Complex multi-level nesting

--------------------------------------------------------
1. NESTED if
--------------------------------------------------------

if (outerCondition) {
    if (innerCondition) {
        // runs only when BOTH are true
    }
}

Equivalent to: if (outer && inner) { }
BUT nested form allows different else branches

--------------------------------------------------------
2. NESTED LOOPS
--------------------------------------------------------

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        // inner loop runs FULLY for each outer iteration
    }
}

Total iterations = outer × inner → O(n²)

Use cases:
  - 2D arrays / matrices
  - Pattern printing
  - Pair/combination generation
  - Matrix operations

--------------------------------------------------------
3. LOOP + if COMBINATION
--------------------------------------------------------

Most common nesting pattern:
  - Filter elements during iteration
  - Conditional processing inside loops
  - Search algorithms

--------------------------------------------------------
4. NESTED switch
--------------------------------------------------------

switch (outer) {
    case X:
        switch (inner) {
            case Y: ...
        }
}

Less common — usually better as methods

--------------------------------------------------------
5. BEST PRACTICES
--------------------------------------------------------

- Maximum 3 levels of nesting (more = refactor)
- Extract inner logic into methods for readability
- Use early return/continue to reduce nesting
- Label nested loops if using break/continue

--------------------------------------------------------
6. KEY PITFALLS
--------------------------------------------------------

- Deep nesting → "arrow code" → hard to read
- O(n²) or O(n³) performance from nested loops
- Forgetting that inner loop resets each outer iteration
- Variable name conflicts in nested scopes
- Complex nested conditions → extract to boolean methods

========================================================
*/

public class NestedFlowNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  NESTED FLOW STRUCTURES — DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. NESTED if-else
        // ============================================

        System.out.println("--- 1. Nested if-else ---");

        int age = 25;
        boolean hasLicense = true;

        if (age >= 18) {
            if (hasLicense) {
                System.out.println("You can drive! (age=" + age + ", license=true)");
            } else {
                System.out.println("Adult but no license.");
            }
        } else {
            System.out.println("Too young to drive.");
        }

        // Equivalent flattened version:
        // if (age >= 18 && hasLicense) → can drive
        // else if (age >= 18)          → no license
        // else                         → too young
        System.out.println();


        // ============================================
        // 2. LOOP + if (Filter Pattern)
        // ============================================

        System.out.println("--- 2. Loop + if (Filtering) ---");

        int[] numbers = {12, 7, 23, 44, 3, 88, 15, 6, 91, 42};

        System.out.print("Even numbers > 10: ");
        for (int n : numbers) {
            if (n > 10 && n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println("\n");


        // ============================================
        // 3. NESTED for LOOPS — PATTERNS
        // ============================================

        System.out.println("--- 3. Pattern Printing (Nested Loops) ---\n");

        // Pattern 1: Right triangle (stars)
        System.out.println("Right triangle:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 2: Inverted triangle
        System.out.println("Inverted triangle:");
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 3: Number pyramid
        System.out.println("Number pyramid:");
        for (int i = 1; i <= 5; i++) {
            // Print leading spaces
            for (int s = 5 - i; s > 0; s--) {
                System.out.print(" ");
            }
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Pattern 4: Diamond
        System.out.println("Diamond:");
        int size = 5;
        // Upper half
        for (int i = 1; i <= size; i++) {
            for (int s = size - i; s > 0; s--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        // Lower half
        for (int i = size - 1; i >= 1; i--) {
            for (int s = size - i; s > 0; s--) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        System.out.println();


        // ============================================
        // 4. NESTED LOOPS — MULTIPLICATION TABLE
        // ============================================

        System.out.println("--- 4. Multiplication Table (1-5) ---");

        System.out.print("    ");
        for (int j = 1; j <= 5; j++) System.out.printf("%4d", j);
        System.out.println();
        System.out.println("    " + "----".repeat(5));

        for (int i = 1; i <= 5; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        System.out.println();


        // ============================================
        // 5. NESTED LOOPS — 2D ARRAY PROCESSING
        // ============================================

        System.out.println("--- 5. 2D Array Processing ---");

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Print matrix
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }

        // Row sums
        System.out.println("\nRow sums:");
        for (int r = 0; r < matrix.length; r++) {
            int sum = 0;
            for (int val : matrix[r]) sum += val;
            System.out.println("  Row " + r + " sum = " + sum);
        }

        // Column sums
        System.out.println("Column sums:");
        for (int c = 0; c < matrix[0].length; c++) {
            int sum = 0;
            for (int[] row : matrix) sum += row[c];
            System.out.println("  Col " + c + " sum = " + sum);
        }
        System.out.println();


        // ============================================
        // 6. LOOP + SWITCH COMBINATION
        // ============================================

        System.out.println("--- 6. Loop + Switch ---");

        String phrase = "Hello World!";
        int vowels = 0, consonants = 0, spaces = 0, special = 0;

        for (char ch : phrase.toCharArray()) {
            switch (Character.toLowerCase(ch)) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    vowels++;
                    break;
                case ' ':
                    spaces++;
                    break;
                default:
                    if (Character.isLetter(ch)) {
                        consonants++;
                    } else {
                        special++;
                    }
            }
        }

        System.out.println("\"" + phrase + "\":");
        System.out.println("  Vowels:     " + vowels);
        System.out.println("  Consonants: " + consonants);
        System.out.println("  Spaces:     " + spaces);
        System.out.println("  Special:    " + special);
        System.out.println();


        // ============================================
        // 7. NESTED LOOPS — PAIR GENERATION
        // ============================================

        System.out.println("--- 7. All Unique Pairs ---");

        int[] arr = {1, 2, 3, 4};
        System.out.print("Pairs: ");
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                System.out.print("(" + arr[a] + "," + arr[b] + ") ");
            }
        }
        System.out.println("\n");


        // ============================================
        // 8. NESTED LOOPS — PRIME NUMBERS
        // ============================================

        System.out.println("--- 8. Prime Numbers (1-50) ---");

        System.out.print("Primes: ");
        for (int num = 2; num <= 50; num++) {
            boolean isPrime = true;
            for (int div = 2; div <= Math.sqrt(num); div++) {
                if (num % div == 0) {
                    isPrime = false;
                    break;     // no need to check more divisors
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println("\n");


        // ============================================
        // 9. THREE LEVELS OF NESTING (max recommended)
        // ============================================

        System.out.println("--- 9. 3-Level Nesting (Max Recommended) ---");

        // 3D array: floors × rows × columns
        int[][][] building = {
            {{1, 2}, {3, 4}},     // floor 0
            {{5, 6}, {7, 8}}      // floor 1
        };

        for (int floor = 0; floor < building.length; floor++) {
            System.out.println("Floor " + floor + ":");
            for (int row = 0; row < building[floor].length; row++) {
                System.out.print("  Row " + row + ": ");
                for (int col = 0; col < building[floor][row].length; col++) {
                    System.out.print(building[floor][row][col] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();


        // ============================================
        // 10. REDUCING NESTING (REFACTORING)
        // ============================================

        System.out.println("--- 10. Reducing Nesting (Best Practice) ---");

        // DEEPLY NESTED (bad):
        System.out.println("Bad style (4 levels deep):");
        System.out.println("""
          if (user != null) {
              if (user.isActive()) {
                  if (user.hasPermission("admin")) {
                      if (user.getAge() >= 18) {
                          // do something
                      }
                  }
              }
          }
        """);

        // FLATTENED with early returns (good):
        System.out.println("Good style (early return / guard clauses):");
        System.out.println("""
          if (user == null) return;
          if (!user.isActive()) return;
          if (!user.hasPermission("admin")) return;
          if (user.getAge() < 18) return;
          // do something
        """);

        // Extract to methods (even better):
        System.out.println("Best: Extract inner logic to methods!");


        // ============================================
        // 11. BUBBLE SORT (Classic Nested Loop Algorithm)
        // ============================================

        System.out.println("--- 11. Bubble Sort (Nested Loop Classic) ---");

        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Before: ");
        for (int v : unsorted) System.out.print(v + " ");
        System.out.println();

        // Bubble sort
        int n = unsorted.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - pass; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    // swap
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;   // already sorted
        }

        System.out.print("After:  ");
        for (int v : unsorted) System.out.print(v + " ");
        System.out.println();


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• Nested loops: total iterations = outer × inner");
        System.out.println("• Common use: 2D arrays, patterns, pair generation");
        System.out.println("• Loop + if = filtering/searching pattern");
        System.out.println("• Keep nesting ≤ 3 levels (refactor otherwise)");
        System.out.println("• Use guard clauses / early returns to reduce depth");
        System.out.println("• Extract inner logic to methods for readability");
    }
}
