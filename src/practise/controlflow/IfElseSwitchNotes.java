package practise.controlflow;

/*
========================================================
TOPIC: if / else / switch — CONDITIONAL STATEMENTS
========================================================

Conditional statements control WHICH code runs
based on boolean conditions.

Three forms:
1. if / else if / else
2. switch (classic)
3. switch expressions (Java 14+, enhanced)

--------------------------------------------------------
1. if STATEMENT
--------------------------------------------------------

Syntax:
  if (condition) {
      // runs if condition is true
  }

• condition MUST evaluate to boolean
• {} optional for single statements (but always use them!)

--------------------------------------------------------
2. if-else STATEMENT
--------------------------------------------------------

Syntax:
  if (condition) {
      // runs if true
  } else {
      // runs if false
  }

--------------------------------------------------------
3. if-else if-else LADDER
--------------------------------------------------------

Syntax:
  if (cond1) {
      // ...
  } else if (cond2) {
      // ...
  } else if (cond3) {
      // ...
  } else {
      // default — none of the above
  }

• Evaluated TOP to BOTTOM
• First true branch executes; rest are SKIPPED
• else is optional (but good for default cases)

--------------------------------------------------------
4. CLASSIC switch STATEMENT
--------------------------------------------------------

Syntax:
  switch (expression) {
      case value1:
          // ...
          break;
      case value2:
          // ...
          break;
      default:
          // ...
  }

Supported expression types:
  byte, short, int, char
  String (Java 7+)
  Enum types
  NOT: long, float, double, boolean

FALL-THROUGH:
  Without break, execution "falls through" to next case!
  This is intentional (sometimes useful, often a bug)

--------------------------------------------------------
5. ENHANCED switch EXPRESSION (Java 14+)
--------------------------------------------------------

Syntax:
  var result = switch (expr) {
      case val1 -> expression1;
      case val2 -> expression2;
      case val3, val4 -> expression3;  // multi-value
      default -> defaultExpression;
  };

• Arrow (->) syntax — no fall-through
• Can return a value (it's an expression!)
• Multi-value case labels: case 1, 2, 3 ->
• yield keyword for multi-line blocks

--------------------------------------------------------
6. KEY PITFALLS
--------------------------------------------------------

- Forgetting break in switch → fall-through bug
- Using == on Strings in if (works, but .equals is safer
  for objects from external sources)
- switch doesn't support long, float, double, boolean
- Dangling else: else pairs with NEAREST if
- Nested if-else can be replaced with switch for clarity

========================================================
*/

public class IfElseSwitchNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  if / else / switch — COMPREHENSIVE DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. BASIC if STATEMENT
        // ============================================

        System.out.println("--- 1. Basic if ---");

        int temperature = 35;

        if (temperature > 30) {
            System.out.println("It's hot! (" + temperature + "°C)");
        }

        // Single line (avoid — harder to read/debug)
        if (temperature > 30) System.out.println("Single-line if (avoid this style)");
        System.out.println();


        // ============================================
        // 2. if-else
        // ============================================

        System.out.println("--- 2. if-else ---");

        int age = 16;

        if (age >= 18) {
            System.out.println("You can vote!");
        } else {
            System.out.println("Too young to vote. (age=" + age + ")");
        }
        System.out.println();


        // ============================================
        // 3. if-else if-else LADDER
        // ============================================

        System.out.println("--- 3. if-else if-else Ladder ---");

        int score = 78;
        String grade;

        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Score: " + score + " → Grade: " + grade);

        // Note: evaluates top-to-bottom, first match wins
        // A score of 95 matches (>= 90) AND (>= 80), but only "A" runs
        System.out.println();


        // ============================================
        // 4. NESTED if
        // ============================================

        System.out.println("--- 4. Nested if ---");

        int num = 15;
        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println(num + " is positive and even");
            } else {
                System.out.println(num + " is positive and odd");
            }
        } else {
            System.out.println(num + " is zero or negative");
        }
        System.out.println();


        // ============================================
        // 5. LOGICAL OPERATORS IN CONDITIONS
        // ============================================

        System.out.println("--- 5. Logical Operators in Conditions ---");

        int marks = 75;
        int attendance = 85;

        // AND (&&)
        if (marks >= 70 && attendance >= 80) {
            System.out.println("Eligible for exam (marks=" + marks + ", attendance=" + attendance + "%)");
        }

        // OR (||)
        boolean hasScholarship = false;
        boolean hasLoan = true;
        if (hasScholarship || hasLoan) {
            System.out.println("Financial support: available");
        }

        // NOT (!)
        boolean isBlocked = false;
        if (!isBlocked) {
            System.out.println("Account is active");
        }
        System.out.println();


        // ============================================
        // 6. CLASSIC switch STATEMENT
        // ============================================

        System.out.println("--- 6. Classic switch ---");

        int dayNum = 3;
        String dayName;

        switch (dayNum) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid";
        }

        System.out.println("Day " + dayNum + " = " + dayName);
        System.out.println();


        // ============================================
        // 7. switch with STRINGS (Java 7+)
        // ============================================

        System.out.println("--- 7. switch with Strings ---");

        String command = "start";

        switch (command.toLowerCase()) {
            case "start":
                System.out.println("Starting system...");
                break;
            case "stop":
                System.out.println("Stopping system...");
                break;
            case "restart":
                System.out.println("Restarting system...");
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
        System.out.println();


        // ============================================
        // 8. FALL-THROUGH (intentional and accidental)
        // ============================================

        System.out.println("--- 8. Fall-Through Demo ---");

        int month = 3;

        // ACCIDENTAL fall-through (bug) — forgot break
        System.out.print("Without break: ");
        switch (month) {
            case 1: System.out.print("Jan ");
            case 2: System.out.print("Feb ");
            case 3: System.out.print("Mar ");  // enters here
            case 4: System.out.print("Apr ");  // falls through!
            case 5: System.out.print("May ");  // falls through!
            default: System.out.print("...");
        }
        System.out.println(" ← all printed due to fall-through!\n");

        // INTENTIONAL fall-through (grouping cases)
        System.out.print("Intentional grouping: ");
        int m = 11;
        switch (m) {
            case 12: case 1: case 2:
                System.out.println("Month " + m + " → Winter");
                break;
            case 3: case 4: case 5:
                System.out.println("Month " + m + " → Spring");
                break;
            case 6: case 7: case 8:
                System.out.println("Month " + m + " → Summer");
                break;
            case 9: case 10: case 11:
                System.out.println("Month " + m + " → Autumn");
                break;
        }
        System.out.println();


        // ============================================
        // 9. ENHANCED switch EXPRESSION (Java 14+)
        // ============================================

        System.out.println("--- 9. Enhanced switch Expression ---");

        int dayNumber = 5;

        // Arrow syntax — no break needed, no fall-through
        String day = switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend";   // multi-value case
            default -> "Invalid";
        };

        System.out.println("Day " + dayNumber + " = " + day);

        // switch expression with yield (multi-line blocks)
        String type = switch (dayNumber) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("  (Calculating weekday type...)");
                yield "Weekday";
            }
            case 6, 7 -> {
                System.out.println("  (Calculating weekend type...)");
                yield "Weekend";
            }
            default -> "Unknown";
        };
        System.out.println("Type: " + type);
        System.out.println();


        // ============================================
        // 10. switch with ENUMS
        // ============================================

        System.out.println("--- 10. switch with Enums ---");

        Direction dir = Direction.NORTH;

        switch (dir) {
            case NORTH -> System.out.println("Heading North ↑");
            case SOUTH -> System.out.println("Heading South ↓");
            case EAST  -> System.out.println("Heading East  →");
            case WEST  -> System.out.println("Heading West  ←");
        }
        System.out.println();


        // ============================================
        // 11. TERNARY as if-else SHORTHAND
        // ============================================

        System.out.println("--- 11. Ternary (if-else shorthand) ---");

        int number = -5;
        String sign = (number > 0) ? "positive" : (number < 0) ? "negative" : "zero";
        System.out.println(number + " is " + sign);

        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + " = " + max);
        System.out.println();


        // ============================================
        // 12. DANGLING ELSE PROBLEM
        // ============================================

        System.out.println("--- 12. Dangling Else (Always Use Braces!) ---");

        int x = 5;
        // Without braces — else pairs with nearest if
        if (x > 0)
            if (x > 10)
                System.out.println("x > 10");
            else  // this pairs with "if (x > 10)", NOT "if (x > 0)"
                System.out.println("x > 0 but x <= 10");

        // With braces — clear and safe
        if (x > 0) {
            if (x > 10) {
                System.out.println("x > 10");
            }
        } else {
            System.out.println("x <= 0");
        }


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• if evaluates boolean conditions top-to-bottom");
        System.out.println("• switch works on int, char, String, enum");
        System.out.println("• Classic switch needs break (or fall-through!)");
        System.out.println("• Enhanced switch (->) has no fall-through");
        System.out.println("• switch expressions can return values (yield)");
        System.out.println("• Always use {} braces to avoid dangling else");
    }

    // Enum for switch demo
    enum Direction { NORTH, SOUTH, EAST, WEST }
}
