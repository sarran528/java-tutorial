import java.util.ArrayList;

public class Arraylist {
public static void main (String[] args) {
    ArrayList<Integer> marks = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
names.add("apple");
    names.add("banana");
    names.set(1,"blueberry");
    System.out.printf(names.get(1));
    System.out.printf(String.valueOf(names.size()));

}

}
