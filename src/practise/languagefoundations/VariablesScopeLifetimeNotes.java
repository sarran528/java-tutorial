package practise.languagefoundations;




/*
========================================================
TOPIC: VARIABLES, SCOPE, AND LIFETIME IN JAVA
========================================================

Variable = named memory location that holds a value

Three aspects:
  1. Declaration → type + name
  2. Scope       → where it can be accessed
  3. Lifetime    → how long it exists in memory

--------------------------------------------------------
1. TYPES OF VARIABLES
--------------------------------------------------------

A. LOCAL VARIABLES
   - Declared inside a method, block, or constructor
   - NO default value → MUST initialize before use
   - Stored on STACK
   - Scope: within the block { } they are declared
   - Lifetime: created when block enters, destroyed when exits

B. INSTANCE VARIABLES (Non-Static Fields)
   - Declared inside a class but outside any method
   - Get DEFAULT values (0, null, false, etc.)
   - Stored on HEAP (part of the object)
   - Scope: accessible to all methods of the object
   - Lifetime: created when object is created (new),
               destroyed when object is garbage collected

C. STATIC / CLASS VARIABLES
   - Declared with static keyword
   - Get DEFAULT values
   - Stored in METHOD AREA (metaspace since Java 8)
   - Scope: shared by ALL instances of the class
   - Lifetime: created when class is loaded,
               destroyed when class is unloaded (program end)

--------------------------------------------------------
2. SCOPE RULES
--------------------------------------------------------

Scope = region of code where variable is visible

{ } ← every opening brace creates a new scope

RULE: A variable declared in an outer scope IS visible
      in inner scopes, but NOT vice versa.

RULE: You CANNOT declare two variables with the same name
      in overlapping scopes (compile error).

RULE: Method parameters are local to that method.

--------------------------------------------------------
3. VARIABLE SHADOWING
--------------------------------------------------------

When a local variable has the same name as an
instance/static variable, the local one "shadows" it.

Use 'this.varName' to access the instance variable.
Use 'ClassName.varName' to access the static variable.

--------------------------------------------------------
4. var — LOCAL VARIABLE TYPE INFERENCE (Java 10+)
--------------------------------------------------------

var x = 10;       // compiler infers int
var name = "Hi";  // compiler infers String

RULES:
  - Only for LOCAL variables (not fields, not params)
  - MUST be initialized at declaration
  - Type is fixed after inference (not dynamic)
  - Cannot use: var x;  (no initializer)
  - Cannot use: var x = null;  (ambiguous type)

--------------------------------------------------------
5. LIFETIME SUMMARY
--------------------------------------------------------

VARIABLE TYPE    CREATED WHEN          DESTROYED WHEN
------------------------------------------------------
Local            block/method enters   block/method exits
Instance         new ClassName()       garbage collected
Static/Class     class is loaded       class is unloaded

--------------------------------------------------------
6. KEY PITFALLS
--------------------------------------------------------

- Local vars have NO default → uninitialized = compile error
- Instance vars DO have defaults (unlike locals)
- Shadowing is confusing — avoid same names when possible
- Variables in for-loop headers are scoped to the loop
- static vars are shared — changing one affects ALL objects
- var does NOT make Java dynamically typed

========================================================
*/

public class VariablesScopeLifetimeNotes {

    // ============================================
    // INSTANCE VARIABLE (per object)
    // ============================================
    int instanceVar = 100;

    // ============================================
    // STATIC / CLASS VARIABLE (shared by all)
    // ============================================
    static int staticVar = 200;
    static int objectCount = 0;      // tracks how many objects are created

    // Constructor demonstrates instance variable lifetime
    VariablesScopeLifetimeNotes() {
        objectCount++;
        System.out.println("    Object #" + objectCount + " created (instanceVar = " + instanceVar + ")");
    }


    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  VARIABLES, SCOPE & LIFETIME — DEMO");
        System.out.println("==============================================\n");


        // ============================================
        // 1. LOCAL VARIABLES
        // ============================================

        System.out.println("--- 1. Local Variables ---");

        int localVar = 42;       // must initialize!
        System.out.println("localVar = " + localVar);

        // int uninitialized;
        // System.out.println(uninitialized);  // ERROR: not initialized

        // Scoped to this method — cannot access from other methods
        System.out.println("Local vars live only inside their method/block.\n");


        // ============================================
        // 2. BLOCK SCOPE
        // ============================================

        System.out.println("--- 2. Block Scope ---");

        {
            int blockVar = 10;
            System.out.println("Inside block: blockVar = " + blockVar);
        }
        // System.out.println(blockVar);  // ERROR: out of scope

        // For-loop scope
        for (int j = 0; j < 3; j++) {
            // j is scoped to this loop
        }
        // System.out.println(j);  // ERROR: j is out of scope

        System.out.println("Variables declared in {} are only visible inside {}.\n");


        // ============================================
        // 3. INSTANCE VARIABLES
        // ============================================

        System.out.println("--- 3. Instance Variables ---");

        VariablesScopeLifetimeNotes obj1 = new VariablesScopeLifetimeNotes();
        VariablesScopeLifetimeNotes obj2 = new VariablesScopeLifetimeNotes();

        // Each object has its own copy
        obj1.instanceVar = 999;
        System.out.println("obj1.instanceVar = " + obj1.instanceVar);
        System.out.println("obj2.instanceVar = " + obj2.instanceVar); // still 100
        System.out.println();


        // ============================================
        // 4. STATIC VARIABLES (shared)
        // ============================================

        System.out.println("--- 4. Static Variables (shared) ---");

        System.out.println("staticVar via class : " + VariablesScopeLifetimeNotes.staticVar);
        System.out.println("staticVar via obj1  : " + obj1.staticVar);
        System.out.println("staticVar via obj2  : " + obj2.staticVar);

        // Changing through one affects all
        obj1.staticVar = 500;
        System.out.println("After obj1.staticVar = 500:");
        System.out.println("  obj2.staticVar = " + obj2.staticVar);  // also 500!
        System.out.println("  Total objects created: " + objectCount);
        System.out.println();


        // ============================================
        // 5. VARIABLE SHADOWING
        // ============================================

        System.out.println("--- 5. Variable Shadowing ---");

        int staticVar = 999;  // local shadows class-level static
        System.out.println("Local staticVar (shadows class): " + staticVar);
        System.out.println("Class staticVar (using class name): " +
                VariablesScopeLifetimeNotes.staticVar);
        System.out.println();


        // ============================================
        // 6. 'this' KEYWORD FOR SHADOWING
        // ============================================

        System.out.println("--- 6. 'this' to resolve shadowing ---");
        obj1.demonstrateShadowing(777);
        System.out.println();


        // ============================================
        // 7. METHOD PARAMETER SCOPE
        // ============================================

        System.out.println("--- 7. Method Parameters ---");
        printSum(10, 20);
        // System.out.println(a);  // ERROR: a is local to printSum
        System.out.println();


        // ============================================
        // 8. var — TYPE INFERENCE (Java 10+)
        // ============================================

        System.out.println("--- 8. var — Local Type Inference ---");

        var number  = 42;            // inferred as int
        var message = "Hello";       // inferred as String
        var pi      = 3.14159;       // inferred as double
        var flag    = true;          // inferred as boolean

        System.out.println("var number  = " + number  + "  → " + ((Object) number).getClass().getSimpleName());
        System.out.println("var message = " + message + "  → " + ((Object) message).getClass().getSimpleName());
        System.out.println("var pi      = " + pi      + "  → " + ((Object) pi).getClass().getSimpleName());
        System.out.println("var flag    = " + flag    + "   → " + ((Object) flag).getClass().getSimpleName());

        // var is NOT dynamic — type is fixed after inference
        // number = "text";  // ERROR: incompatible types
        System.out.println();


        // ============================================
        // 9. LIFETIME DEMONSTRATION
        // ============================================

        System.out.println("--- 9. Lifetime Demo ---");

        System.out.println("Creating objects in a loop...");
        for (int j = 0; j < 3; j++) {
            VariablesScopeLifetimeNotes temp = new VariablesScopeLifetimeNotes();
            // 'temp' reference is local to this iteration
            // Object becomes eligible for GC after each iteration
        }
        System.out.println("Loop ended. Objects may be garbage collected.");
        System.out.println("Total objects ever created: " + objectCount);
        System.out.println();


        // ============================================
        // 10. DEFAULT VALUES vs NO-DEFAULT
        // ============================================

        System.out.println("--- 10. Default Values ---");
        DefaultValueDemo demo = new DefaultValueDemo();
        demo.printDefaults();


        System.out.println("\n========================================");
        System.out.println("  KEY TAKEAWAYS");
        System.out.println("========================================");
        System.out.println("• Local vars: no default, must init, stack, block scope");
        System.out.println("• Instance vars: defaults, heap, object lifetime");
        System.out.println("• Static vars: defaults, shared, class lifetime");
        System.out.println("• Scope = visibility, Lifetime = existence");
        System.out.println("• 'this' resolves instance var shadowing");
        System.out.println("• var infers type but is NOT dynamic typing");
    }

    // Demonstrates shadowing with 'this'
    void demonstrateShadowing(int instanceVar) {
        // parameter 'instanceVar' shadows the field
        System.out.println("  Parameter instanceVar = " + instanceVar);     // 777
        System.out.println("  this.instanceVar      = " + this.instanceVar); // 999 (from obj1)
    }

    // Method parameters are scoped to the method
    static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println("  a=" + a + ", b=" + b + ", sum=" + sum);
    }
}

// Helper class to show default values
class DefaultValueDemo {
    int     intDefault;
    double  doubleDefault;
    boolean boolDefault;
    char    charDefault;
    String  strDefault;     // reference type

    void printDefaults() {
        System.out.println("  int     → " + intDefault);
        System.out.println("  double  → " + doubleDefault);
        System.out.println("  boolean → " + boolDefault);
        System.out.println("  char    → '" + charDefault + "' (\\u0000)");
        System.out.println("  String  → " + strDefault + " (null)");
    }
}
