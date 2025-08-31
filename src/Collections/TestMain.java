package Collections;
public class TestMain {
    public static void main(String[] args) {
        MyCollection<String> list = new MyArrayList<>();
        MyCollection<String> link = new MyLinkedList<>();
        link.add("Hello");
        link.add("World");
        link.add("!");

        for (MyIterator<String> it = link.iterator(); it.hasNext();) {
            System.out.printf(it.next());
        }
        System.out.println("Size: " + link.size());  // 3
        System.out.println("Contains 'World'? " + link.contains("World")); // true

        link.remove("World");
        System.out.println("Size after removal: " + link.size()); // 2

        for (MyIterator<String> it = link.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}