/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.LinkedList; // Import the LinkedList class.

public class GenericQueue<E> {

    private LinkedList<E> list =  new LinkedList<E>(); // Instantiate LinkedList for generic queue objects.

    /**
     * Public void method which is used to add a generic item to a list.
     * @param item E
     * @return none.
     */
    public void enqueue(E item) {
        list.addFirst(item);
    } // end enqueue

    /**
     * Public generic method which is used to print a list object's contents and remove the first item from that list.
     * @return the list with the first index removed.
     */
    public E dequeue() {
        System.out.println(list.get(0).toString()); // Always grab index 0, since we use removeFirst on list.
        return list.removeFirst(); // return the list with the first index removed.
    } // end dequeue

    /**
     * Public int method that is used to return the size of a list.
     * @return int of the size of the list.
     */
    public int size() {
        return list.size(); // return the size of the list.
    } // end size

} // end GenericQueue
