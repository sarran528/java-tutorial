package Basics;
public class treemap {

    public static void main(String[] args) {
        java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("TreeMap: " + map);

        // Accessing elements
        System.out.println("Value for key 2: " + map.get(2));

        // Removing an element
        map.remove(2);
        System.out.println("After removing key 2: " + map);

        // Checking if a key exists
        System.out.println("Contains key 2? " + map.containsKey(2));
    }
}
