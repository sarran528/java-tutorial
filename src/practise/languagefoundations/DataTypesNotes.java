package practise.languagefoundations;

/*
========================================================
TOPIC: DATA TYPES IN JAVA
========================================================

Java is STRONGLY TYPED → every variable must have a type

Two categories:
1. Primitive Types (store actual values)
2. Non-Primitive / Reference Types (store memory reference)

--------------------------------------------------------
1. PRIMITIVE DATA TYPES (8 TYPES)
--------------------------------------------------------

TYPE      SIZE      RANGE / PRECISION              DEFAULT
-----------------------------------------------------------
byte      1 byte    -128 to 127                    0
short     2 bytes   -32,768 to 32,767              0
int       4 bytes   ~ -2.1B to +2.1B               0
long      8 bytes   very large (±9.2 quintillion)   0L

float     4 bytes   ~6-7 decimal digits             0.0f
double    8 bytes   ~15 decimal digits              0.0d

char      2 bytes   single Unicode char (0–65535)   '\u0000'
boolean   JVM dep   true / false                    false

WHY 8 TYPES?
  - Integers: byte < short < int < long
    (use smallest type that fits your data)
  - Decimals: float < double
    (double is default; float saves memory)
  - char: for characters (Unicode, not ASCII only)
  - boolean: for logic (not 0/1 like C)

--------------------------------------------------------
2. REFERENCE DATA TYPES
--------------------------------------------------------

TYPE          EXAMPLES
---------------------------------------------
String        "Hello" (immutable sequence of chars)
Array         int[], String[]
Class/Object  Scanner, ArrayList, custom classes
Interface     List, Comparable

Key differences from primitives:
  • Stored on HEAP (primitive values on stack)
  • Can be null (primitives cannot)
  • Have methods (primitives don't)
  • Compared with .equals() not == (for content)

--------------------------------------------------------
3. DECLARATION SYNTAX
--------------------------------------------------------

type variableName = value;

--------------------------------------------------------
4. TYPE SUFFIXES (IMPORTANT)
--------------------------------------------------------

long   → must end with L  (e.g., 100L)
float  → must end with F  (e.g., 3.14F)
double → optional D        (e.g., 3.14D)

Without suffix:
  - integer literals default to int
  - decimal literals default to double

--------------------------------------------------------
5. NUMERIC LITERAL FORMATS (Java 7+)
--------------------------------------------------------

Binary:      0b1010      → 10
Octal:       012         → 10
Hexadecimal: 0xA         → 10
Underscore:  1_000_000   → 1000000 (readability)

--------------------------------------------------------
6. TYPE CASTING
--------------------------------------------------------

A. WIDENING (AUTOMATIC / IMPLICIT)
   byte → short → int → long → float → double
   char → int
   Safe: no data loss

B. NARROWING (MANUAL / EXPLICIT)
   double → float → long → int → short → byte
   Risky: possible data loss or overflow

--------------------------------------------------------
7. WRAPPER CLASSES
--------------------------------------------------------

Each primitive has a corresponding object wrapper:
  int     → Integer
  double  → Double
  char    → Character
  boolean → Boolean
  ...

Autoboxing:   int → Integer (automatic)
Unboxing:     Integer → int (automatic)

--------------------------------------------------------
8. MEMORY LOGIC
--------------------------------------------------------

Primitive → stored in stack (value directly)
Reference → stack holds address → heap holds object

--------------------------------------------------------
9. KEY PITFALLS
--------------------------------------------------------

- float vs double precision difference
- integer overflow (wraps silently — no error!)
- char is numeric internally (can do math on it)
- boolean CANNOT be cast to/from numbers (unlike C)
- == on reference types compares ADDRESS, not value
- default values apply to FIELDS only, not local vars
  (local vars must be initialized before use)

========================================================
*/

public class DataTypesNotes {

    // Instance fields get DEFAULT VALUES
    static byte   defaultByte;       // 0
    static short  defaultShort;      // 0
    static int    defaultInt;        // 0
    static long   defaultLong;       // 0L
    static float  defaultFloat;      // 0.0f
    static double defaultDouble;     // 0.0
    static char   defaultChar;       // '\u0000'
    static boolean defaultBool;      // false

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  DATA TYPES IN JAVA — COMPREHENSIVE DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. INTEGER TYPES
        // ============================================

        System.out.println("--- 1. Integer Types ---");

        byte b = 100;              // 1 byte: -128 to 127
        short s = 10000;           // 2 bytes
        int i = 100000;            // default integer type (4 bytes)
        long l = 10000000000L;     // must use 'L' suffix (8 bytes)

        System.out.println("byte   b = " + b);
        System.out.println("short  s = " + s);
        System.out.println("int    i = " + i);
        System.out.println("long   l = " + l);

        // Size verification
        System.out.println("\nSizes:");
        System.out.println("  Byte.SIZE   = " + Byte.SIZE + " bits");
        System.out.println("  Short.SIZE  = " + Short.SIZE + " bits");
        System.out.println("  Integer.SIZE= " + Integer.SIZE + " bits");
        System.out.println("  Long.SIZE   = " + Long.SIZE + " bits");


        // ============================================
        // 2. FLOATING POINT TYPES
        // ============================================

        System.out.println("\n--- 2. Floating Point Types ---");

        float f = 10.5F;           // must use 'F' suffix
        double d = 10.5;           // default decimal type

        System.out.println("float  f = " + f);
        System.out.println("double d = " + d);

        // Precision difference
        float  fPrecision = 1.123456789012345F;
        double dPrecision = 1.123456789012345;
        System.out.println("\nPrecision comparison:");
        System.out.println("  float  = " + fPrecision + "  (6-7 digits)");
        System.out.println("  double = " + dPrecision + " (15 digits)");


        // ============================================
        // 3. CHARACTER TYPE
        // ============================================

        System.out.println("\n--- 3. Character Type ---");

        char c1 = 'A';            // character literal
        char c2 = 65;             // same as 'A' (ASCII/Unicode value)
        char c3 = '\u0041';       // Unicode escape for 'A'

        System.out.println("char 'A'     = " + c1);
        System.out.println("char 65      = " + c2);
        System.out.println("char \\u0041  = " + c3);

        // char is numeric — you can do math!
        char c4 = 'A';
        c4 += 1;                   // 'A' + 1 = 'B'
        System.out.println("'A' + 1      = " + c4);
        System.out.println("(int) 'A'    = " + (int) 'A');  // 65


        // ============================================
        // 4. BOOLEAN TYPE
        // ============================================

        System.out.println("\n--- 4. Boolean Type ---");

        boolean isJavaFun = true;
        boolean isBoring  = false;

        System.out.println("isJavaFun = " + isJavaFun);
        System.out.println("isBoring  = " + isBoring);

        // boolean in conditions
        if (isJavaFun) {
            System.out.println("Java IS fun!");
        }
        // boolean CANNOT be 0 or 1 (unlike C/C++)
        // int x = isJavaFun;  // ERROR: incompatible types


        // ============================================
        // 5. DEFAULT VALUES (fields only)
        // ============================================

        System.out.println("\n--- 5. Default Values (static fields) ---");
        System.out.println("byte    → " + defaultByte);
        System.out.println("short   → " + defaultShort);
        System.out.println("int     → " + defaultInt);
        System.out.println("long    → " + defaultLong);
        System.out.println("float   → " + defaultFloat);
        System.out.println("double  → " + defaultDouble);
        System.out.println("char    → '" + defaultChar + "' (\\u0000)");
        System.out.println("boolean → " + defaultBool);
        // Local variables have NO default — must initialize!


        // ============================================
        // 6. NUMERIC LITERALS (Java 7+)
        // ============================================

        System.out.println("\n--- 6. Numeric Literal Formats ---");

        int decimal     = 26;
        int binary      = 0b11010;       // 0b prefix
        int octal       = 032;           // 0 prefix
        int hex         = 0x1A;          // 0x prefix
        int readable    = 1_000_000;     // underscores

        System.out.println("Decimal:     " + decimal);
        System.out.println("Binary 0b:   " + binary);
        System.out.println("Octal 0:     " + octal);
        System.out.println("Hex 0x:      " + hex);
        System.out.println("Underscore:  " + readable);


        // ============================================
        // 7. TYPE CASTING
        // ============================================

        System.out.println("\n--- 7. Type Casting ---");

        // Widening (automatic) — no data loss
        int num = 100;
        double widened = num;      // int → double
        System.out.println("Widening:  int " + num + " → double " + widened);

        // Narrowing (manual) — possible data loss
        double bigValue = 99.99;
        int narrowed = (int) bigValue;   // truncates decimal
        System.out.println("Narrowing: double " + bigValue + " → int " + narrowed);

        // char to int (widening)
        char ch = 'Z';
        int charToInt = ch;
        System.out.println("char→int:  '" + ch + "' → " + charToInt);

        // int to char (narrowing)
        int code = 97;
        char intToChar = (char) code;
        System.out.println("int→char:  " + code + " → '" + intToChar + "'");


        // ============================================
        // 8. OVERFLOW EXAMPLE
        // ============================================

        System.out.println("\n--- 8. Integer Overflow ---");

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println("MAX_VALUE     = " + max);
        System.out.println("MAX_VALUE + 1 = " + (max + 1) + "  ← wraps to MIN!");
        System.out.println("MIN_VALUE     = " + min);
        System.out.println("MIN_VALUE - 1 = " + (min - 1) + "  ← wraps to MAX!");


        // ============================================
        // 9. TYPE PROMOTION IN EXPRESSIONS
        // ============================================

        System.out.println("\n--- 9. Type Promotion ---");

        byte x = 10;
        byte y = 20;
        // byte result = x + y;  // ERROR! result is int
        int result = x + y;      // byte + byte → int
        System.out.println("byte + byte → int: " + result);

        // Mixed types promote to largest type
        int     intVal   = 10;
        double  dblVal   = 3.0;
        double  mixed    = intVal / dblVal;  // int → double
        System.out.println("int / double = double: " + mixed);

        // Integer division trap
        System.out.println("5 / 2 = " + (5 / 2) + "  (int division → truncated)");
        System.out.println("5.0/2 = " + (5.0 / 2) + " (double division → precise)");


        // ============================================
        // 10. WRAPPER CLASSES & AUTOBOXING
        // ============================================

        System.out.println("\n--- 10. Wrapper Classes ---");

        // Autoboxing: primitive → object
        Integer wrapped = 42;         // int → Integer
        System.out.println("Autoboxed:  " + wrapped);

        // Unboxing: object → primitive
        int unwrapped = wrapped;      // Integer → int
        System.out.println("Unboxed:    " + unwrapped);

        // Useful wrapper methods
        System.out.println("parseInt:   " + Integer.parseInt("123"));
        System.out.println("MAX_VALUE:  " + Integer.MAX_VALUE);
        System.out.println("toBinary:   " + Integer.toBinaryString(42));
        System.out.println("toHex:      " + Integer.toHexString(42));


        // ============================================
        // 11. PRECISION PITFALL
        // ============================================

        System.out.println("\n--- 11. Floating Point Precision ---");

        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));
        System.out.println("Expected 0.3, got " + (0.1 + 0.2));
        System.out.println("(Use BigDecimal for exact decimal arithmetic)");


        // ============================================
        // 12. FINAL / CONSTANTS
        // ============================================

        System.out.println("\n--- 12. Constants (final) ---");

        final double PI = 3.14159265358979;
        // PI = 3.14;  // ERROR: cannot reassign final
        System.out.println("PI = " + PI);
        System.out.println("Convention: UPPER_SNAKE_CASE for constants");


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• 8 primitive types: byte,short,int,long,float,double,char,boolean");
        System.out.println("• int = default integer; double = default decimal");
        System.out.println("• long needs L suffix; float needs F suffix");
        System.out.println("• Widening = auto; Narrowing = explicit cast");
        System.out.println("• byte/short promote to int in expressions");
        System.out.println("• boolean ≠ number (no true=1, false=0)");
        System.out.println("• Fields get defaults; local vars do NOT");
    }
}
