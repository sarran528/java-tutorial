package Basics;

abstract class grand {

    String name = "grand parent";
    static Integer a = 10;
}


abstract class parent extends grand{



}


class Student extends parent {
    String name;
    int age;


    // Constructor without 'this'
    Student(String name, int age, int a ) {
        this.name = super.name; // Local variable assigned to itself
        this.age = age;// Instance variables remain uninitialized
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age+" num: "+ super.a);
    }
}

public class WithoutThisDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20,10);//object creates
        s1.display();

//        final int a =5;
//
//        System.out.print(a);
    }
}
//1)pass any value to new data type(each time want to create new type)
//2)we can pass the value to the same type(we cant pass the value to different type)
//3) use this keyword to avoid the confusion