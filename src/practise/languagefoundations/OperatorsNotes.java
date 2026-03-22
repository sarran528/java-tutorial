package practise.languagefoundations;

/*
========================================================
TOPIC: OPERATORS IN JAVA
========================================================

Operator = symbol that performs an operation on operands

Categories:
1. Arithmetic Operators
2. Relational / Comparison Operators
3. Logical Operators
4. Bitwise Operators
5. Shift Operators
6. Assignment Operators
7. Unary Operators
8. Ternary Operator
9. instanceof Operator

--------------------------------------------------------
1. ARITHMETIC OPERATORS
--------------------------------------------------------

OPERATOR   NAME           EXAMPLE    RESULT
+          Addition        5 + 3      8
-          Subtraction     5 - 3      2
*          Multiplication  5 * 3      15
/          Division        5 / 3      1 (int div!)
%          Modulus         5 % 3      2 (remainder)

CAUTION: 5/3 = 1 (integer division — truncated)
         5.0/3 = 1.666... (double division)

--------------------------------------------------------
2. RELATIONAL / COMPARISON OPERATORS
--------------------------------------------------------

OPERATOR   NAME                  RETURNS
==         Equal to              boolean
!=         Not equal to          boolean
>          Greater than          boolean
<          Less than             boolean
>=         Greater than or equal boolean
<=         Less than or equal    boolean

WARNING: == on reference types compares ADDRESS, not value
         Use .equals() for content comparison

--------------------------------------------------------
3. LOGICAL OPERATORS
--------------------------------------------------------

OPERATOR   NAME           BEHAVIOR
&&         AND (short-ckt) true if BOTH true
||         OR  (short-ckt) true if EITHER true
!          NOT             inverts boolean

SHORT-CIRCUIT:
  && → if left is false, right is NEVER evaluated
  || → if left is true,  right is NEVER evaluated

NON-SHORT-CIRCUIT:
  &  → evaluates both sides (also bitwise AND on ints)
  |  → evaluates both sides (also bitwise OR on ints)

--------------------------------------------------------
4. BITWISE OPERATORS
--------------------------------------------------------

Work on individual bits of integer types

OPERATOR   NAME           TRUTH TABLE
&          AND            1&1=1, 1&0=0, 0&0=0
|          OR             1|1=1, 1|0=1, 0|0=0
^          XOR            1^1=0, 1^0=1, 0^0=0
~          NOT / Complement  ~1=0, ~0=1

--------------------------------------------------------
5. SHIFT OPERATORS
--------------------------------------------------------

OPERATOR   NAME              EFFECT
<<         Left shift         multiply by 2^n
>>         Right shift (signed)  divide by 2^n (preserves sign)
>>>        Right shift (unsigned) fills with 0s

n << k  =  n * 2^k
n >> k  =  n / 2^k

--------------------------------------------------------
6. ASSIGNMENT OPERATORS
--------------------------------------------------------

OPERATOR   EQUIVALENT TO
=          x = value
+=         x = x + value
-=         x = x - value
*=         x = x * value
/=         x = x / value
%=         x = x % value
&=         x = x & value
|=         x = x | value
^=         x = x ^ value
<<=        x = x << value
>>=        x = x >> value
>>>=       x = x >>> value

--------------------------------------------------------
7. UNARY OPERATORS
--------------------------------------------------------

OPERATOR   NAME                EXAMPLE
+          Unary plus           +5  → 5
-          Unary minus          -5  → -5
++         Increment            x++ or ++x
--         Decrement            x-- or --x
!          Logical NOT          !true → false

pre-increment (++x): increments THEN uses value
post-increment(x++): uses value THEN increments

--------------------------------------------------------
8. TERNARY OPERATOR
--------------------------------------------------------

condition ? valueIfTrue : valueIfFalse

Shorthand for simple if-else

--------------------------------------------------------
9. OPERATOR PRECEDENCE (HIGH → LOW)
--------------------------------------------------------

1. ()          Parentheses
2. ++ -- !     Unary
3. * / %       Multiplicative
4. + -         Additive
5. << >> >>>   Shift
6. < <= > >=   Relational
7. == !=       Equality
8. &           Bitwise AND
9. ^           Bitwise XOR
10. |          Bitwise OR
11. &&         Logical AND
12. ||         Logical OR
13. ?:         Ternary
14. = += -= …  Assignment

TIP: When in doubt, use parentheses!

--------------------------------------------------------
10. KEY PITFALLS
--------------------------------------------------------

- Integer division: 5/2 = 2 (not 2.5)
- == vs .equals() on Strings
- Short-circuit can skip side effects
- Bitwise & | ^ work on ints (not just booleans)
- ~ inverts ALL bits (result may surprise you)
- >>> does NOT work with long as expected sometimes
- Operator precedence: && binds tighter than ||

========================================================
*/

public class OperatorsNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  OPERATORS IN JAVA — COMPREHENSIVE DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. ARITHMETIC OPERATORS
        // ============================================

        System.out.println("--- 1. Arithmetic Operators ---");

        int a = 17, b = 5;
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b) + "  (integer division!)");
        System.out.println(a + " % " + b + " = " + (a % b) + "  (remainder)");

        // Double division
        System.out.println(a + ".0 / " + b + " = " + ((double) a / b) + "  (double division)");

        // Modulus with negatives
        System.out.println("-17 % 5 = " + (-17 % 5) + "  (sign follows dividend)");
        System.out.println("17 % -5 = " + (17 % -5) + "  (sign follows dividend)");
        System.out.println();


        // ============================================
        // 2. RELATIONAL OPERATORS
        // ============================================

        System.out.println("--- 2. Relational Operators ---");

        int x = 10, y = 20;
        System.out.println(x + " == " + y + " → " + (x == y));
        System.out.println(x + " != " + y + " → " + (x != y));
        System.out.println(x + " >  " + y + " → " + (x > y));
        System.out.println(x + " <  " + y + " → " + (x < y));
        System.out.println(x + " >= " + y + " → " + (x >= y));
        System.out.println(x + " <= " + y + " → " + (x <= y));

        // == on reference types (TRAP!)
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("\ns1 == s2     → " + (s1 == s2) + "  (compares addresses!)");
        System.out.println("s1.equals(s2)→ " + s1.equals(s2) + " (compares content!)");
        System.out.println();


        // ============================================
        // 3. LOGICAL OPERATORS
        // ============================================

        System.out.println("--- 3. Logical Operators ---");

        boolean p = true, q = false;
        System.out.println("true  && false = " + (p && q));
        System.out.println("true  || false = " + (p || q));
        System.out.println("!true          = " + (!p));
        System.out.println("!false         = " + (!q));

        // Short-circuit demonstration
        System.out.println("\nShort-circuit demo:");
        int val = 5;
        // Second condition is NOT evaluated because first is false
        if (false && (++val > 0)) { }
        System.out.println("  false && (++val): val = " + val + "  (unchanged — short-circuited)");

        // Second condition IS evaluated (non-short-circuit &)
        if (false & (++val > 0)) { }
        System.out.println("  false &  (++val): val = " + val + "  (incremented — both evaluated)");
        System.out.println();


        // ============================================
        // 4. BITWISE OPERATORS
        // ============================================

        System.out.println("--- 4. Bitwise Operators ---");

        int m = 0b1100;   // 12
        int n = 0b1010;   // 10

        System.out.println("m = " + Integer.toBinaryString(m) + " (" + m + ")");
        System.out.println("n = " + Integer.toBinaryString(n) + " (" + n + ")");
        System.out.println();

        System.out.println("m & n = " + formatBinary(m & n) + " (" + (m & n) + ")  AND");
        System.out.println("m | n = " + formatBinary(m | n) + " (" + (m | n) + ")  OR");
        System.out.println("m ^ n = " + formatBinary(m ^ n) + " (" + (m ^ n) + ")  XOR");
        System.out.println("~m    = " + (~m) + "  (bitwise NOT — flips all 32 bits)");

        // Practical use: check if number is even/odd
        int num = 7;
        System.out.println("\n" + num + " & 1 = " + (num & 1) + "  → " + (num % 2 == 0 ? "even" : "odd"));
        num = 8;
        System.out.println(num + " & 1 = " + (num & 1) + "  → " + (num % 2 == 0 ? "even" : "odd"));
        System.out.println();


        // ============================================
        // 5. SHIFT OPERATORS
        // ============================================

        System.out.println("--- 5. Shift Operators ---");

        int v = 8;    // binary: 1000
        System.out.println("v = " + v + " (binary: " + Integer.toBinaryString(v) + ")");

        System.out.println("v << 1 = " + (v << 1) + "  (×2)  binary: " + Integer.toBinaryString(v << 1));
        System.out.println("v << 2 = " + (v << 2) + " (×4)  binary: " + Integer.toBinaryString(v << 2));
        System.out.println("v >> 1 = " + (v >> 1) + "   (÷2)  binary: " + Integer.toBinaryString(v >> 1));
        System.out.println("v >> 2 = " + (v >> 2) + "   (÷4)  binary: " + Integer.toBinaryString(v >> 2));

        // Signed vs unsigned right shift
        int neg = -8;
        System.out.println("\nneg = " + neg);
        System.out.println("neg >> 1  = " + (neg >> 1)  + "  (signed — preserves sign bit)");
        System.out.println("neg >>> 1 = " + (neg >>> 1) + "  (unsigned — fills with 0)");

        // Quick multiply/divide by powers of 2
        System.out.println("\n3 << 3 = " + (3 << 3) + "  (3 × 2³ = 24)");
        System.out.println("40 >> 3 = " + (40 >> 3) + "  (40 ÷ 2³ = 5)");
        System.out.println();


        // ============================================
        // 6. ASSIGNMENT OPERATORS
        // ============================================

        System.out.println("--- 6. Assignment Operators ---");

        int c = 100;
        System.out.println("c = " + c);

        c += 10;   System.out.println("c += 10  → " + c);
        c -= 5;    System.out.println("c -= 5   → " + c);
        c *= 2;    System.out.println("c *= 2   → " + c);
        c /= 3;    System.out.println("c /= 3   → " + c);
        c %= 15;   System.out.println("c %= 15  → " + c);
        c <<= 2;   System.out.println("c <<= 2  → " + c);
        c >>= 1;   System.out.println("c >>= 1  → " + c);
        c &= 0xFF; System.out.println("c &= 0xFF→ " + c);
        c ^= 5;    System.out.println("c ^= 5   → " + c);
        c |= 16;   System.out.println("c |= 16  → " + c);

        // Compound assignment does implicit narrowing!
        byte byt = 10;
        byt += 5;       // OK — equivalent to byt = (byte)(byt + 5)
        // byt = byt + 5; // ERROR — byt+5 is int
        System.out.println("\nbyte += works (implicit cast): " + byt);
        System.out.println();


        // ============================================
        // 7. UNARY OPERATORS
        // ============================================

        System.out.println("--- 7. Unary Operators ---");

        int u = 10;
        System.out.println("+u  = " + (+u));
        System.out.println("-u  = " + (-u));

        // Pre-increment vs Post-increment
        int preDemo = 10;
        System.out.println("\npre-increment (++x):");
        System.out.println("  Before: " + preDemo);
        System.out.println("  Using:  " + (++preDemo) + "  (increments first, then uses)");
        System.out.println("  After:  " + preDemo);

        int postDemo = 10;
        System.out.println("\npost-increment (x++):");
        System.out.println("  Before: " + postDemo);
        System.out.println("  Using:  " + (postDemo++) + "  (uses first, then increments)");
        System.out.println("  After:  " + postDemo);

        // Pre-decrement and Post-decrement
        int w = 10;
        System.out.println("\n--w = " + (--w) + "  (pre-decrement)");
        System.out.println("w-- = " + (w--) + "  (post-decrement, w is now " + w + ")");
        System.out.println();


        // ============================================
        // 8. TERNARY OPERATOR
        // ============================================

        System.out.println("--- 8. Ternary Operator ---");

        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age " + age + " → " + status);

        // Nested ternary (avoid for readability)
        int score = 85;
        String grade = (score >= 90) ? "A" :
                        (score >= 80) ? "B" :
                        (score >= 70) ? "C" : "F";
        System.out.println("Score " + score + " → Grade " + grade);

        // Ternary for min/max
        int r = 30, t = 50;
        System.out.println("Min of " + r + "," + t + " = " + (r < t ? r : t));
        System.out.println("Max of " + r + "," + t + " = " + (r > t ? r : t));
        System.out.println();


        // ============================================
        // 9. instanceof OPERATOR
        // ============================================

        System.out.println("--- 9. instanceof Operator ---");

        Object obj = "Hello";
        System.out.println("obj instanceof String  → " + (obj instanceof String));
        System.out.println("obj instanceof Integer → " + (obj instanceof Integer));
        System.out.println("null instanceof String → " + (null instanceof String)); // always false
        System.out.println();


        // ============================================
        // 10. OPERATOR PRECEDENCE DEMO
        // ============================================

        System.out.println("--- 10. Operator Precedence ---");

        // Without parentheses
        int result1 = 2 + 3 * 4;
        System.out.println("2 + 3 * 4   = " + result1 + "  (* before +)");

        // With parentheses
        int result2 = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + result2 + "  (parentheses first)");

        // && before ||
        boolean res = true || false && false;
        System.out.println("true || false && false = " + res + "  (&& before ||)");

        boolean res2 = (true || false) && false;
        System.out.println("(true || false) && false = " + res2);


        // ============================================
        // 11. XOR SWAP TRICK
        // ============================================

        System.out.println("\n--- 11. XOR Swap (No Temp Variable) ---");

        int swapA = 5, swapB = 10;
        System.out.println("Before: a=" + swapA + ", b=" + swapB);
        swapA ^= swapB;
        swapB ^= swapA;
        swapA ^= swapB;
        System.out.println("After:  a=" + swapA + ", b=" + swapB);


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• 5/2=2 (int division truncates)");
        System.out.println("• == compares address for objects; use .equals()");
        System.out.println("• && || are short-circuit; & | are not");
        System.out.println("• <<n = ×2ⁿ, >>n = ÷2ⁿ");
        System.out.println("• ++x increments first; x++ uses first");
        System.out.println("• Compound assignment (+=) does implicit cast");
        System.out.println("• When in doubt, use parentheses!");
    }

    /** Helper to format binary with leading zeros (4-bit) */
    static String formatBinary(int value) {
        return String.format("%4s", Integer.toBinaryString(value)).replace(' ', '0');
    }
}
