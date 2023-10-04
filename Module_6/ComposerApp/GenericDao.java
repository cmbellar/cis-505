/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.List; // Import the List class.

/** interface named GenericDao to represent the operations in a data persistence layer. */
public interface GenericDao<E, K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
} // end GenericDao
