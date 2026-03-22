package practise.languagefoundations;

/*
========================================================
TOPIC: BYTECODE EXECUTION MODEL
========================================================

Bytecode = intermediate representation between
           source code and machine code

Java's key innovation:
  Source → Bytecode (portable) → JVM (platform-specific)

--------------------------------------------------------
1. WHAT IS BYTECODE?
--------------------------------------------------------

• Instruction set for the JVM (not for real CPU)
• Stored in .class files
• Each instruction is 1 byte opcode + operands
• Human-readable form viewable with: javap -c ClassName

Example Bytecodes:
  iconst_1    → push int constant 1 onto stack
  iload_0     → load local variable 0 (int)
  iadd        → add two ints from stack
  ireturn     → return int from method
  invokevirtual → call a method

--------------------------------------------------------
2. .class FILE STRUCTURE
--------------------------------------------------------

Every .class file contains:
  ┌─────────────────────────────┐
  │  Magic Number: 0xCAFEBABE  │  ← identifies as .class
  │  Minor/Major Version       │  ← Java version
  │  Constant Pool             │  ← literals, refs, names
  │  Access Flags              │  ← public, final, etc.
  │  This Class / Super Class  │  ← class hierarchy
  │  Interfaces                │  ← implemented interfaces
  │  Fields                    │  ← field definitions
  │  Methods                   │  ← method bytecode
  │  Attributes                │  ← metadata (debug, etc.)
  └─────────────────────────────┘

MAGIC NUMBER: 0xCAFEBABE
  - Every valid .class file starts with this
  - Fun fact: chosen by James Gosling, inspired by
    a café near their office

--------------------------------------------------------
3. BYTECODE EXECUTION FLOW
--------------------------------------------------------

Step 1: Class Loading
  ClassLoader finds and loads .class into memory
  Three built-in loaders:
    Bootstrap → core Java classes (java.lang.*)
    Extension → ext directory classes
    Application → classpath classes

Step 2: Bytecode Verification
  Verifier checks:
    ✓ Valid .class format (magic number, version)
    ✓ No stack overflow/underflow
    ✓ No illegal type casts
    ✓ No access violation
  → Prevents malicious/corrupted code from running

Step 3: Execution (Interpreter + JIT)
  Interpreter: reads each bytecode instruction → executes
  JIT Compiler: compiles hot methods → native code
  → Both work together (tiered compilation)

--------------------------------------------------------
4. JVM STACK-BASED ARCHITECTURE
--------------------------------------------------------

JVM is a STACK-BASED virtual machine (not register-based)

For:  int c = a + b;

Bytecodes:
  iload_1       ← push 'a' onto operand stack
  iload_2       ← push 'b' onto operand stack
  iadd          ← pop both, add, push result
  istore_3      ← pop result, store in 'c'

Stack at each step:
  []         → iload_1  → [a]
  [a]        → iload_2  → [a, b]
  [a, b]     → iadd     → [a+b]
  [a+b]      → istore_3 → []     (stored in c)

WHY STACK-BASED?
  • Simpler to implement across platforms
  • No need to map to specific CPU registers
  • Easier to verify safety

--------------------------------------------------------
5. METHOD FRAME
--------------------------------------------------------

Each method call creates a FRAME on the JVM stack:

  ┌─────────────────────┐
  │  Operand Stack      │  ← for computation
  │  Local Variable Array│ ← params + local vars
  │  Frame Data         │  ← return addr, exception info
  └─────────────────────┘

  - Frame is pushed when method is invoked
  - Frame is popped when method returns
  - Each thread has its own stack of frames

--------------------------------------------------------
6. VIEWING BYTECODE (javap tool)
--------------------------------------------------------

Command: javap -c ClassName
  Shows disassembled bytecode of compiled class

Command: javap -v ClassName
  Shows verbose output (constant pool, flags, etc.)

Command: javap -p ClassName
  Shows private members too

--------------------------------------------------------
7. KEY PITFALLS
--------------------------------------------------------

- Bytecode ≠ machine code (JVM interprets it)
- Bytecode is portable; .exe files are not
- You CANNOT run .class files without a JVM
- javap does NOT show source code (only bytecode)
- Bytecode verification happens before execution
  (helps prevent security exploits)
- Stack-based ≠ slow (JIT compiles to register-based
  native code at runtime)

========================================================
*/

public class BytecodeExecutionNotes {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  BYTECODE EXECUTION MODEL — DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. VERIFY .class FILE EXISTS
        // ============================================

        System.out.println("--- 1. Class File Info ---");
        Class<?> thisClass = BytecodeExecutionNotes.class;
        System.out.println("Class Name    : " + thisClass.getName());
        System.out.println("Simple Name   : " + thisClass.getSimpleName());
        System.out.println("Package       : " + thisClass.getPackageName());
        System.out.println("Superclass    : " + thisClass.getSuperclass().getName());
        System.out.println("Class Location: " +
                thisClass.getProtectionDomain().getCodeSource().getLocation());


        // ============================================
        // 2. CONSTANT POOL EVIDENCE (reflection)
        // ============================================

        System.out.println("\n--- 2. Class Metadata (from constant pool) ---");
        System.out.println("Methods in this class:");

        var methods = thisClass.getDeclaredMethods();
        for (var method : methods) {
            System.out.println("  → " + method.getReturnType().getSimpleName()
                    + " " + method.getName() + "()");
        }


        // ============================================
        // 3. STACK-BASED COMPUTATION DEMO
        // ============================================

        System.out.println("\n--- 3. Stack-Based Computation ---");

        int a = 10;
        int b = 20;
        int c = a + b;  // Bytecode: iload, iload, iadd, istore

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("c = a + b = " + c);

        System.out.println("""

        What JVM does internally:
          iload_1       → push 10 onto stack    → [10]
          iload_2       → push 20 onto stack    → [10, 20]
          iadd          → pop both, add          → [30]
          istore_3      → pop, store in 'c'      → []
        """);


        // ============================================
        // 4. METHOD INVOCATIONS IN BYTECODE
        // ============================================

        System.out.println("--- 4. Method Invocation Types ---");

        // invokevirtual → instance methods
        String greeting = "hello";
        int len = greeting.length();     // invokevirtual
        System.out.println("invokevirtual: \"hello\".length() = " + len);

        // invokestatic → static methods
        int max = Math.max(10, 20);      // invokestatic
        System.out.println("invokestatic:  Math.max(10,20) = " + max);

        // invokespecial → constructors and super calls
        Object obj = new Object();       // invokespecial <init>
        System.out.println("invokespecial: new Object() = " + obj);

        System.out.println("""

        Bytecode invocation types:
          invokevirtual  → instance methods (polymorphic)
          invokestatic   → static methods
          invokespecial  → constructors, super, private
          invokeinterface→ interface methods
          invokedynamic  → lambdas, method references
        """);


        // ============================================
        // 5. CLASS LOADING PHASES
        // ============================================

        System.out.println("--- 5. Class Loading Demo ---");

        ClassLoader cl = BytecodeExecutionNotes.class.getClassLoader();
        System.out.println("App ClassLoader   : " + cl);
        System.out.println("Parent (Platform) : " + cl.getParent());
        System.out.println("Bootstrap (null)  : " + String.class.getClassLoader());

        System.out.println("""

        Class Loading Phases:
          1. Loading    → find .class file, read bytes
          2. Linking
             a. Verify  → check bytecode validity
             b. Prepare → allocate static fields (defaults)
             c. Resolve → symbolic refs → direct refs
          3. Initialization → run static blocks & initializers
        """);


        // ============================================
        // 6. MAGIC NUMBER DEMO
        // ============================================

        System.out.println("--- 6. Magic Number ---");
        System.out.println("Every .class file starts with: 0xCAFEBABE");
        System.out.println("Hex: " + Integer.toHexString(0xCAFEBABE).toUpperCase());
        System.out.println("(Run: xxd YourClass.class | head -1  to verify)\n");


        // ============================================
        // 7. PRACTICE HINT
        // ============================================

        System.out.println("--- Practice ---");
        System.out.println("Try running: javap -c practise.languagefoundations.BytecodeExecutionNotes");
        System.out.println("to see the actual bytecode of this class!");


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• Bytecode = platform-independent instructions for JVM");
        System.out.println("• .class file starts with 0xCAFEBABE magic number");
        System.out.println("• JVM is stack-based (operand stack for computation)");
        System.out.println("• Class loading: Load → Link → Initialize");
        System.out.println("• Use javap -c to inspect bytecode");
        System.out.println("• JIT compiles hot bytecode → native for speed");
    }
}
