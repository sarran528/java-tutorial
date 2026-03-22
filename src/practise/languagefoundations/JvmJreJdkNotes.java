package practise.languagefoundations;

/*
========================================================
TOPIC: JVM, JRE, JDK ARCHITECTURE
========================================================

Java Platform has THREE key components:

1. JDK  (Java Development Kit)
2. JRE  (Java Runtime Environment)
3. JVM  (Java Virtual Machine)

Hierarchy:   JDK  ⊃  JRE  ⊃  JVM

--------------------------------------------------------
1. JDK — Java Development Kit
--------------------------------------------------------

PURPOSE : Development + Compilation + Execution
CONTAINS:
  - JRE (entire runtime)
  - javac      → compiler (.java → .class)
  - javadoc    → documentation generator
  - jar        → archive tool
  - jdb        → debugger
  - jconsole   → monitoring tool
  - keytool    → security certificates

WHO NEEDS IT: Developers writing & compiling Java code

--------------------------------------------------------
2. JRE — Java Runtime Environment
--------------------------------------------------------

PURPOSE : Run compiled Java programs
CONTAINS:
  - JVM
  - Core libraries (java.lang, java.util, java.io …)
  - Class loader subsystem
  - rt.jar (core class archive, up to Java 8)

WHO NEEDS IT: End users who only run Java apps

--------------------------------------------------------
3. JVM — Java Virtual Machine
--------------------------------------------------------

PURPOSE : Execute bytecode on any platform
CONTAINS:
  - Class Loader     → loads .class files
  - Bytecode Verifier → security & validity checks
  - Execution Engine:
      • Interpreter   → line-by-line execution
      • JIT Compiler  → hot-spot optimization
  - Garbage Collector → automatic memory management

KEY PROPERTY: Platform-dependent implementation,
              but provides platform-independent execution
              → "Write Once, Run Anywhere" (WORA)

--------------------------------------------------------
4. JVM MEMORY AREAS
--------------------------------------------------------

AREA             PURPOSE
------------------------------------------
Method Area      class metadata, static vars
Heap             objects, instance variables
Stack            method frames, local vars
PC Register      current instruction address
Native Stack     native method calls (C/C++)

--------------------------------------------------------
5. KEY DISTINCTIONS
--------------------------------------------------------

JDK vs JRE:
  - JDK = JRE + dev tools (javac, jdb, etc.)
  - You CANNOT compile without JDK
  - You CAN run .class files with just JRE

JRE vs JVM:
  - JRE = JVM + libraries
  - JVM alone cannot run programs (needs libs)

JVM vs OS:
  - JVM is OS-specific (different for Win/Mac/Linux)
  - But bytecode is the SAME across all platforms

--------------------------------------------------------
6. KEY PITFALLS
--------------------------------------------------------

- JRE alone cannot compile code
- JVM is NOT platform-independent (bytecode is)
- Since Java 11, JRE is no longer separately downloadable
  (you install the full JDK instead)
- Different vendors ship different JVMs
  (Oracle HotSpot, Eclipse OpenJ9, GraalVM, etc.)

========================================================
*/

public class JvmJreJdkNotes {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  JVM, JRE, JDK — RUNTIME DEMO");
        System.out.println("========================================\n");

        // ============================================
        // 1. DETECT JAVA VERSION & VENDOR
        // ============================================

        String javaVersion  = System.getProperty("java.version");
        String javaVendor   = System.getProperty("java.vendor");
        String jvmName      = System.getProperty("java.vm.name");
        String jvmVersion   = System.getProperty("java.vm.version");

        System.out.println("--- Java Installation Info ---");
        System.out.println("Java Version : " + javaVersion);
        System.out.println("Java Vendor  : " + javaVendor);
        System.out.println("JVM Name     : " + jvmName);
        System.out.println("JVM Version  : " + jvmVersion);


        // ============================================
        // 2. JDK vs JRE PATH
        // ============================================

        String javaHome = System.getProperty("java.home");
        System.out.println("\nJava Home (JRE/JDK path): " + javaHome);
        // If path ends with /jre → you're using JRE inside JDK
        // If path ends with /jdk-XX → full JDK


        // ============================================
        // 3. JVM MEMORY INFO (HEAP)
        // ============================================

        Runtime runtime = Runtime.getRuntime();

        long maxMemory   = runtime.maxMemory();       // max heap JVM can use
        long totalMemory = runtime.totalMemory();     // current heap size
        long freeMemory  = runtime.freeMemory();      // free within current heap
        long usedMemory  = totalMemory - freeMemory;

        System.out.println("\n--- JVM Heap Memory ---");
        System.out.println("Max Memory   : " + (maxMemory   / (1024 * 1024)) + " MB");
        System.out.println("Total Memory : " + (totalMemory / (1024 * 1024)) + " MB");
        System.out.println("Used Memory  : " + (usedMemory  / (1024 * 1024)) + " MB");
        System.out.println("Free Memory  : " + (freeMemory  / (1024 * 1024)) + " MB");


        // ============================================
        // 4. AVAILABLE PROCESSORS (relates to JVM threads)
        // ============================================

        int processors = runtime.availableProcessors();
        System.out.println("\nAvailable Processors: " + processors);


        // ============================================
        // 5. OS INFO (JVM sits on top of OS)
        // ============================================

        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String osVer  = System.getProperty("os.version");

        System.out.println("\n--- Operating System (JVM runs on) ---");
        System.out.println("OS Name    : " + osName);
        System.out.println("OS Arch    : " + osArch);
        System.out.println("OS Version : " + osVer);


        // ============================================
        // 6. CLASS PATH (where JVM looks for classes)
        // ============================================

        String classPath = System.getProperty("java.class.path");
        System.out.println("\n--- Class Path ---");
        System.out.println(classPath);


        // ============================================
        // 7. DEMONSTRATING WORA (Write Once Run Anywhere)
        // ============================================

        System.out.println("\n--- WORA Demo ---");
        System.out.println("This .class file runs on ANY OS with a JVM.");
        System.out.println("Current OS: " + osName);
        System.out.println("Same bytecode → different JVM → same result.");


        // ============================================
        // 8. GARBAGE COLLECTION HINT
        // ============================================

        System.out.println("\n--- Garbage Collection ---");
        long beforeGC = runtime.freeMemory();
        System.gc();   // hint to JVM (NOT guaranteed)
        long afterGC = runtime.freeMemory();
        System.out.println("Free before GC hint: " + beforeGC);
        System.out.println("Free after  GC hint: " + afterGC);
        System.out.println("(GC is automatic; System.gc() is just a suggestion)");


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• JDK = JRE + dev tools (javac, jdb ...)");
        System.out.println("• JRE = JVM + core libraries");
        System.out.println("• JVM = bytecode interpreter + GC + memory mgmt");
        System.out.println("• JVM is platform-specific; bytecode is not");
        System.out.println("• Since Java 11, JRE is bundled inside JDK");
    }
}
