public class oops {

    public static void main(String[] args) {

        //inheritance - attributes and method from one class to another
        // extends keyword in used to pass the parent methods to the child
        //

        children sarran = new children();
        System.out.println(sarran.age);
        System.out.println(sarran.nationality);
        sarran.food();
    }


    static class grandparent {

        String nationality ;

    }

    static class parent extends grandparent {
//       String nationality = "indian";

        void food() {

            System.out.println("Non vegetarian");

        }

    }

    static class children extends parent {

        int age = 30;
    }
}//hgfghj
