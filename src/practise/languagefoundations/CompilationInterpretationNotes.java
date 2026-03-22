package practise.languagefoundations;

/*
========================================================
TOPIC: COMPILATION vs INTERPRETATION IN JAVA
========================================================

Java uses BOTH compilation AND interpretation
→ it is a HYBRID language

--------------------------------------------------------
1. PURE COMPILATION (C, C++, Rust)
--------------------------------------------------------

Source Code  ──▶  Machine Code  ──▶  CPU
  (.c)             (.exe / .out)

• Compiled once for a SPECIFIC platform
• Fast execution (native machine code)
• NOT portable (recompile for each OS/arch)

--------------------------------------------------------
2. PURE INTERPRETATION (Python, JS, Ruby)
--------------------------------------------------------

Source Code  ──▶  Interpreter  ──▶  CPU
  (.py)          (reads & runs line by line)

• No compilation step
• Portable (interpreter handles platform)
• Slower (translates every time it runs)

--------------------------------------------------------
3. JAVA's HYBRID APPROACH
--------------------------------------------------------

Phase 1 — COMPILATION (javac)
Source Code   ──▶   Bytecode
  (.java)          (.class)

• javac (Java Compiler) converts to bytecode
• Bytecode is NOT machine code — it's intermediate
• Bytecode is PLATFORM-INDEPENDENT

Phase 2 — INTERPRETATION + JIT (JVM)
Bytecode   ──▶   JVM   ──▶   Machine Code   ──▶  CPU
 (.class)      Interpreter
               + JIT Compiler

• JVM interpreter reads bytecode line-by-line
• JIT compiler optimizes "hot" code to native code
• Execution is platform-dependent via JVM

RESULT: "Write Once, Run Anywhere" (WORA)

--------------------------------------------------------
4. STEP-BY-STEP FLOW
--------------------------------------------------------

  1. Write:     HelloWorld.java
  2. Compile:   javac HelloWorld.java  →  HelloWorld.class
  3. Run:       java HelloWorld
     └─ JVM loads .class
     └─ Verifies bytecode
     └─ Interpreter starts executing
     └─ JIT compiles hot methods to native
     └─ CPU executes native instructions

--------------------------------------------------------
5. JIT COMPILER (Just-In-Time)
--------------------------------------------------------

• JVM initially interprets bytecode (slow start)
• Monitors which methods are called frequently ("hot spots")
• JIT compiles hot methods to native machine code
• Subsequent calls run native code directly (FAST)
• This is why Java "warms up" — first run is slower

Levels of JIT (HotSpot JVM):
  C1 → quick compilation (client compiler)
  C2 → deep optimization (server compiler)
  Tiered → starts with C1, promotes to C2

--------------------------------------------------------
6. AOT COMPILATION (Ahead-Of-Time)
--------------------------------------------------------

• Java 9+ introduced AOT compilation (jaotc)
• GraalVM native-image compiles to native binary
• Eliminates warm-up time
• Trade-off: less runtime optimization

--------------------------------------------------------
7. KEY COMPARISONS
--------------------------------------------------------

FEATURE          COMPILED      INTERPRETED     JAVA
-------------------------------------------------------
Speed            Fast          Slow            Fast*
Portability      No            Yes             Yes
Output           Machine code  None            Bytecode
Debug ease       Harder        Easier          Moderate
Platform dep.    Yes           No              No**

 *  After JIT warm-up
 ** Bytecode is portable; JVM is platform-specific

--------------------------------------------------------
8. KEY PITFALLS
--------------------------------------------------------

- Java is NOT purely compiled OR interpreted (it's both)
- .class files are NOT executable by OS directly
- JIT ≠ AOT (JIT is at runtime; AOT is before runtime)
- javac is NOT the JIT compiler
  (javac = source→bytecode, JIT = bytecode→native)
- First run of Java program is slower (cold start)
  due to class loading + interpretation before JIT

========================================================
*/

public class CompilationInterpretationNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  COMPILATION vs INTERPRETATION — DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. PROVING JAVA IS COMPILED (bytecode exists)
        // ============================================

        System.out.println("--- 1. Bytecode Evidence ---");
        System.out.println("This class was compiled from .java → .class");
        System.out.println("Class file: " +
                CompilationInterpretationNotes.class
                        .getProtectionDomain()
                        .getCodeSource()
                        .getLocation());


        // ============================================
        // 2. PROVING JAVA IS INTERPRETED (JVM runs it)
        // ============================================

        System.out.println("\n--- 2. JVM Interpretation Evidence ---");
        System.out.println("JVM Name : " + System.getProperty("java.vm.name"));
        System.out.println("JVM Info : " + System.getProperty("java.vm.info"));
        // "mixed mode" → interpreter + JIT both active


        // ============================================
        // 3. JIT WARM-UP DEMONSTRATION
        // ============================================

        System.out.println("\n--- 3. JIT Warm-Up Demo ---");
        System.out.println("Running a method multiple times to trigger JIT...\n");

        // First run (cold — interpreted)
        long startCold = System.nanoTime();
        long resultCold = heavyComputation();
        long endCold = System.nanoTime();
        System.out.println("Run 1 (cold):  " + (endCold - startCold) + " ns  result=" + resultCold);

        // Warm-up runs (JIT compiles after repeated calls)
        for (int warmup = 0; warmup < 10000; warmup++) {
            heavyComputation();
        }

        // Hot run (should be faster after JIT optimization)
        long startHot = System.nanoTime();
        long resultHot = heavyComputation();
        long endHot = System.nanoTime();
        System.out.println("Run 10002 (hot): " + (endHot - startHot) + " ns  result=" + resultHot);

        System.out.println("\nNote: Hot run is typically faster due to JIT compilation.");
        System.out.println("(Results may vary — JVM decides what to optimize)");


        // ============================================
        // 4. CLASS LOADING DEMONSTRATION
        // ============================================

        System.out.println("\n--- 4. Class Loading (part of JVM flow) ---");

        ClassLoader loader = CompilationInterpretationNotes.class.getClassLoader();
        System.out.println("ClassLoader: " + loader);
        System.out.println("Parent:      " + loader.getParent());

        // Classes are loaded lazily — only when first referenced
        System.out.println("\nString class loader: " + String.class.getClassLoader());
        System.out.println("(null = Bootstrap ClassLoader — native C++ code)");


        // ============================================
        // 5. COMPILATION PIPELINE SUMMARY
        // ============================================

        System.out.println("\n--- 5. Java Compilation Pipeline ---");
        System.out.println("""
            ┌──────────────┐
            │  .java file  │   (Source Code)
            └──────┬───────┘
                   │  javac (compiler)
                   ▼
            ┌──────────────┐
            │  .class file │   (Bytecode)
            └──────┬───────┘
                   │  java (JVM launcher)
                   ▼
            ┌──────────────┐
            │     JVM      │
            │  Interpreter │──▶ slow start
            │  JIT Compiler│──▶ optimized native code
            └──────┬───────┘
                   │
                   ▼
            ┌──────────────┐
            │     CPU      │   (Machine Code)
            └──────────────┘
        """);


        // ============================================
        // 6. QUICK QUIZ PRINT
        // ============================================

        System.out.println("--- Key Takeaways ---");
        System.out.println("• javac compiles .java → .class (bytecode)");
        System.out.println("• JVM interprets bytecode at runtime");
        System.out.println("• JIT compiles hot bytecode → native code");
        System.out.println("• Java = compiled + interpreted (hybrid)");
        System.out.println("• Bytecode is portable; JVM is platform-specific");
    }

    /**
     * A computation-heavy method to demonstrate JIT warm-up.
     * JIT should optimize this after many invocations.
     */
    static long heavyComputation() {
        long sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i * i;
        }
        return sum;
    }
}
