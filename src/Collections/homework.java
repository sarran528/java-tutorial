package Collections;

import java.util.*;

public class homework {
    public static void main(String[] args) {
//        q1();
        // q2();
        //ReverseArray();
        MinMax();
    }


    static void q1() {
        ArrayList<Integer> List = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            List.add(i);
        }
        System.out.println(List);
    }

    static void q2() {
        List<Integer> List = new LinkedList<>(Arrays.asList(4, 4, 2, 5, 5, 2, 6));
        System.out.println(List);
        Set<Integer> set = new HashSet<>(List);
        System.out.println(set);
        List.clear();
        System.out.println(List);
        List.addAll(set);
        System.out.println(List);

    }

    static void ReverseArray() {

        ArrayList<String> List = new ArrayList<>();

        List.add("vijay");
        List.add("ajay");
        List.add("bob");
        List.add("alex");
        List.add("sujay");
        System.out.println(List);

        Collections.reverse(List);


    }

    static void MinMax() {


        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(5, 2, 8, 1, 3));
        System.out.print(pq);
        while (!pq.isEmpty()) System.out.print(pq.poll() + " "); // ascending order


    }
}