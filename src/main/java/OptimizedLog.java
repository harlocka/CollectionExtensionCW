import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @param <E>
 * @author Alex Harlock
 */
public class OptimizedLog<E> implements Collection
{
    private int counter;
    private Node head;

    public OptimizedLog() {
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean contains(Object o) {
        E objectToSearchFor = (E) o;
        if (counter == 0) {
            return false;
        }
        Node currentSearchNode = head;
        for (int i = 0; i < counter; i++) {
            currentSearchNode = currentSearchNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object e) {
        Node temp = new Node((E) e);
        Node current = head;
        if (current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            current.setPrevious(current);
            temp.setPrevious(current);
        }
        else {
            head = new Node((E) e);
        }
        counter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int indexToRemove = counter-1;
        if (indexToRemove < 1) {
            return false;
        }
        Node current = head;
        if (current != null) {
            for (int i = 0; i <= indexToRemove; i++) {
                if (current.getNext() == null) {
                    current.getPrevious().setNext(null);
                    counter--;
                }
                current = current.getNext();
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * This innerclass represents an individual node in a linked list
     * @author Alex Harlock
     */
    public class Node {
        Node next; // The next node
        Node previous; // The previous node
        E data; // Value of the node

        /**
         * Constructor for the Node class
         * @param data The value of the node
         */
        public Node(E data) {
            this.next = null;
            this.previous = null;
            this.data = data;
        }

        /**
         * Gets the value of the node
         *
         * @return An Object containing the value of the node
         */
        public E getData() {
            return data;
        }

        /**
         * Gets the value of the next node in the chain
         *
         * @return An instance of the next node in the chain
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the value of the next node in the chain
         *
         * @param nextValue The value to set the next node to
         */
        public void setNext(Node nextValue) {
            next = nextValue;
        }

        /**
         * Gets the value of the previous node in the chain
         *
         * @return An instance of the previous node
         */
        public Node getPrevious() {
            return previous;
        }

        /**
         * Sets the value of the previous node in the chain
         *
         * @param previousValue The value to set the previous node to
         */
        public void setPrevious(Node previousValue) {
            previous = previousValue;
        }
    }
}
