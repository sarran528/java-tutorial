package Collections;
public class TestMain {
    public static void main(String[] args) {
        MyCollection<String> list = new MyArrayList<>();
        MyCollection<String> link = new MyLinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");

        System.out.println("Size: " + list.size());  // 3
        System.out.println("Contains 'World'? " + list.contains("World")); // true

        list.remove("World");
        System.out.println("Size after removal: " + list.size()); // 2

        for (MyIterator<String> it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}