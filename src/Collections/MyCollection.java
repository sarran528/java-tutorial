package Collections;

public interface MyCollection<E> {
    boolean add(E element);
    boolean remove(Object o);
    boolean contains(Object o);
    int size();
    boolean isEmpty();
    Object[] toArray();
    MyIterator<E> iterator();
}
