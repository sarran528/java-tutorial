package practise.languagefoundations;

/*
========================================================
TOPIC: TYPE CASTING IN JAVA (Implicit & Explicit)
========================================================

Type Casting = converting a value from one data type
               to another

Two kinds:
1. Widening  (Implicit / Automatic)
2. Narrowing (Explicit / Manual)

--------------------------------------------------------
1. WIDENING CASTING (AUTOMATIC)
--------------------------------------------------------

Smaller type → Larger type
Compiler does it automatically — NO data loss

Hierarchy (left to right = widening):
  byte → short → int → long → float → double
  char → int

Examples:
  int x = 10;
  double d = x;   // auto: int → double

WHY SAFE?
  - Larger type has more bits → can hold all values
  - double (64-bit) can hold any int (32-bit) value

EXCEPTION:
  int/long → float can lose PRECISION (not range)
  int → float:  int has 32 bits of precision
                float has only ~23 bits of mantissa
  So very large ints may lose exact value as float

--------------------------------------------------------
2. NARROWING CASTING (EXPLICIT / MANUAL)
--------------------------------------------------------

Larger type → Smaller type
Must use explicit cast syntax: (targetType) value

Hierarchy (left to right = narrowing):
  double → float → long → int → short → byte

Examples:
  double d = 99.99;
  int x = (int) d;  // explicit: decimal truncated → 99

RISKS:
  1. Decimal truncation (not rounding!)
  2. Overflow (value too large for target type)
  3. Sign loss

--------------------------------------------------------
3. CHAR CONVERSIONS
--------------------------------------------------------

char → int : WIDENING  (automatic)
  char c = 'A';  →  int i = c;  →  65

int → char : NARROWING (explicit)
  int i = 65;  →  char c = (char) i;  →  'A'

char is unsigned 0-65535; byte is signed -128-127
  → char → byte needs explicit cast

--------------------------------------------------------
4. TYPE PROMOTION IN EXPRESSIONS
--------------------------------------------------------

When mixing types in an expression, Java promotes
smaller types BEFORE the operation:

RULES:
  1. byte, short, char → int (always in expressions)
  2. If any operand is long  → whole expr → long
  3. If any operand is float → whole expr → float
  4. If any operand is double→ whole expr → double

byte + byte  → int   (both promoted first)
int  + long  → long
int  + float → float
float+ double→ double

--------------------------------------------------------
5. BOOLEAN — NO CASTING
--------------------------------------------------------

boolean CANNOT be cast to ANY other type and vice versa
  - (int) true   → ERROR
  - (boolean) 1  → ERROR

--------------------------------------------------------
6. REFERENCE TYPE CASTING (Preview)
--------------------------------------------------------

Upcasting:   Child → Parent   (automatic, safe)
Downcasting: Parent → Child   (explicit, risky → ClassCastException)

Object obj = "Hello";           // upcast: String → Object
String str = (String) obj;      // downcast: Object → String

--------------------------------------------------------
7. KEY PITFALLS
--------------------------------------------------------

- Narrowing TRUNCATES decimals (does NOT round)
- byte + byte = int (NOT byte!)
- int → float can lose precision for large values
- boolean is never castable
- Overflow during narrowing wraps silently (no error)

========================================================
*/

public class TypeCastingNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  TYPE CASTING IN JAVA — COMPREHENSIVE DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. WIDENING CASTING (AUTOMATIC)
        // ============================================

        System.out.println("--- 1. Widening Casting (Automatic) ---");

        byte  b = 42;
        short s = b;        // byte → short
        int   i = s;        // short → int
        long  l = i;        // int → long
        float f = l;        // long → float
        double d = f;       // float → double

        System.out.println("byte   → " + b);
        System.out.println("short  → " + s);
        System.out.println("int    → " + i);
        System.out.println("long   → " + l);
        System.out.println("float  → " + f);
        System.out.println("double → " + d);

        // char → int (automatic)
        char ch = 'Z';
        int charToInt = ch;
        System.out.println("char 'Z' → int " + charToInt);
        System.out.println();


        // ============================================
        // 2. NARROWING CASTING (MANUAL)
        // ============================================

        System.out.println("--- 2. Narrowing Casting (Manual) ---");

        double bigDouble = 123.789;
        float  toFloat   = (float) bigDouble;    // double → float
        long   toLong    = (long) bigDouble;      // double → long (truncates)
        int    toInt     = (int) bigDouble;        // double → int (truncates)
        short  toShort   = (short) bigDouble;      // double → short
        byte   toByte    = (byte) bigDouble;       // double → byte

        System.out.println("double 123.789 →");
        System.out.println("  float  = " + toFloat);
        System.out.println("  long   = " + toLong   + "  (decimal truncated)");
        System.out.println("  int    = " + toInt     + "  (decimal truncated)");
        System.out.println("  short  = " + toShort);
        System.out.println("  byte   = " + toByte);
        System.out.println();


        // ============================================
        // 3. TRUNCATION vs ROUNDING
        // ============================================

        System.out.println("--- 3. Truncation (NOT rounding!) ---");

        double val1 = 9.99;
        double val2 = 9.01;
        double val3 = -9.99;

        System.out.println("(int) 9.99  = " + (int) val1 + "  (not 10!)");
        System.out.println("(int) 9.01  = " + (int) val2);
        System.out.println("(int) -9.99 = " + (int) val3 + "  (towards zero)");

        // For rounding, use Math.round()
        System.out.println("Math.round(9.99)  = " + Math.round(val1));
        System.out.println("Math.round(-9.99) = " + Math.round(val3));
        System.out.println();


        // ============================================
        // 4. OVERFLOW DURING NARROWING
        // ============================================

        System.out.println("--- 4. Overflow During Narrowing ---");

        int bigInt = 130;
        byte narrowedByte = (byte) bigInt;  // 130 > 127 (byte max)
        System.out.println("int 130 → byte = " + narrowedByte + "  (overflowed!  130 - 256 = -126)");

        int veryBig = 100000;
        short narrowedShort = (short) veryBig;
        System.out.println("int 100000 → short = " + narrowedShort + "  (overflowed!)");

        // long to int
        long hugeLong = 3_000_000_000L;
        int  narrowedInt = (int) hugeLong;
        System.out.println("long 3B → int = " + narrowedInt + "  (overflowed!)");
        System.out.println();


        // ============================================
        // 5. CHAR CASTING
        // ============================================

        System.out.println("--- 5. char Casting ---");

        char letter = 'A';
        int  ascii  = letter;         // widening: char → int
        System.out.println("'A' → int = " + ascii);

        int  code = 122;
        char back = (char) code;      // narrowing: int → char
        System.out.println("122 → char = '" + back + "'");

        // char arithmetic
        char start = 'A';
        for (int j = 0; j < 5; j++) {
            System.out.print((char)(start + j) + " ");
        }
        System.out.println("  (char + int → int, cast back to char)");
        System.out.println();


        // ============================================
        // 6. TYPE PROMOTION IN EXPRESSIONS
        // ============================================

        System.out.println("--- 6. Type Promotion in Expressions ---");

        byte  x = 10;
        byte  y = 20;
        // byte sum = x + y;  // ERROR: x+y is promoted to int
        int sum = x + y;
        System.out.println("byte + byte → int: " + x + " + " + y + " = " + sum);

        int    intVal  = 10;
        long   longVal = 20L;
        long   longResult = intVal + longVal;  // int → long
        System.out.println("int + long → long: " + intVal + " + " + longVal + " = " + longResult);

        int    intV  = 5;
        float  floatV = 2.5f;
        float  floatResult = intV + floatV;    // int → float
        System.out.println("int + float → float: " + intV + " + " + floatV + " = " + floatResult);

        float  fV = 1.5f;
        double dV = 2.5;
        double dblResult = fV + dV;            // float → double
        System.out.println("float + double → double: " + fV + " + " + dV + " = " + dblResult);
        System.out.println();


        // ============================================
        // 7. INTEGER DIVISION TRAP
        // ============================================

        System.out.println("--- 7. Integer Division Trap ---");

        int a = 7, bVal = 2;
        System.out.println("7 / 2          = " + (a / bVal)         + "  (int/int → int, truncated)");
        System.out.println("7.0 / 2        = " + (7.0 / 2)         + " (double/int → double)");
        System.out.println("(double)7 / 2  = " + ((double)a / bVal) + " (cast first, then divide)");
        System.out.println();


        // ============================================
        // 8. PRECISION LOSS: int/long → float
        // ============================================

        System.out.println("--- 8. Precision Loss (int → float) ---");

        int bigPrecise = 123456789;
        float asFloat = bigPrecise;          // widening but loses precision!
        System.out.println("int   : " + bigPrecise);
        System.out.println("float : " + asFloat + "  (rounded — float has ~7 digits precision)");
        System.out.println("Lost? : " + (bigPrecise == (int) asFloat ? "No" : "YES!"));

        double asDouble = bigPrecise;        // double has enough precision
        System.out.println("double: " + asDouble + "  (exact — double has ~15 digits)");
        System.out.println();


        // ============================================
        // 9. BOOLEAN — NO CASTING
        // ============================================

        System.out.println("--- 9. Boolean Cannot Be Cast ---");

        boolean flag = true;
        // int boolAsInt = (int) flag;      // ERROR
        // boolean intAsBool = (boolean) 1; // ERROR

        System.out.println("boolean flag = " + flag);
        System.out.println("Cannot cast boolean ↔ any numeric type");
        System.out.println("(Unlike C/C++ where 0=false, 1=true)");
        System.out.println();


        // ============================================
        // 10. REFERENCE TYPE CASTING (PREVIEW)
        // ============================================

        System.out.println("--- 10. Reference Type Casting (Preview) ---");

        // Upcasting (automatic)
        Object obj = "Hello World";    // String → Object
        System.out.println("Upcasted: " + obj);

        // Downcasting (explicit)
        String str = (String) obj;     // Object → String
        System.out.println("Downcasted: " + str.toUpperCase());

        // instanceof check before downcasting (safe)
        if (obj instanceof String s2) {    // Java 16+ pattern matching
            System.out.println("Pattern match: " + s2.length() + " chars");
        }

        System.out.println("(More on reference casting in OOP section)");


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• Widening = auto (small → large), generally safe");
        System.out.println("• Narrowing = manual cast (large → small), risky");
        System.out.println("• Narrowing TRUNCATES (doesn't round)");
        System.out.println("• Overflow wraps silently — no runtime error");
        System.out.println("• byte+byte = int (expression type promotion)");
        System.out.println("• int→float can lose precision (7 digit limit)");
        System.out.println("• boolean CANNOT be cast to/from anything");
    }
}
