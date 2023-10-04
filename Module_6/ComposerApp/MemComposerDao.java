/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.util.ArrayList; // Import the ArrayList class.
import java.util.List; // Import the List class.

public class MemComposerDao implements ComposerDao {

    private List<Composer> composers = new ArrayList<Composer>(); // List of composer objects.

    /**
     * Constructor which is used to create a MemComposerDao object with the default composers set.
     * @return none.
     */
    MemComposerDao() {
        /** Create the required default set of composers in five different Composer objects. */
        Composer composer1 = new Composer(1007, "Ludwig Van Beethoven", "Classical");
        Composer composer2 = new Composer(1008, "Johann Sebastian Bach", "Classical");
        Composer composer3 = new Composer(1009, "Wolfgang Amadeus Mozart", "Classical");
        Composer composer4 = new Composer(1010, "Johannes Brahms", "Classical");
        Composer composer5 = new Composer(1011, "Joseph Haydn", "Classical");
        
        /** Add the created Composer objects to the private List<Composer> composers. */
        composers.add(composer1);
        composers.add(composer2);
        composers.add(composer3);
        composers.add(composer4);
        composers.add(composer5);
    } // end MemComposerDao

    /**
     * Public List<Composer> method with no arguments which is used to return the composers List.
     * Overrides List<E> findAll() in public interface GenericDao<E, K>.
     * @return the current composers List.
     */
    @Override
    public List<Composer> findAll() {
        return composers; // Return composers List.
    } // end findAll

    /**
     * Public Composer method with one argument which is used to return a specific composer based on id.
     * Overrides E findBy(K key) in public interface GenericDao<E, K>.
     * @param id Integer 
     * @return the matched composer object.
     */
    @Override
    public Composer findBy(Integer id) {
        /** Loop through composers and attempt to match the provided id. */
        for (int i = 0; i < composers.size(); i++) {
            if (composers.get(i).getId() == id) { // Compare id of Composer object to passed id.
                return composers.get(i); // Return matched Composer object.
            } // end if
        } // end for
        return null; // Return null if id isn't found.
    } // end findBy

    /**
     * Public void method with one argument which is used to add a composer to the composers List.
     * Overrides void insert(E entity) in public interface GenericDao<E, K>.
     * @param composer Composer 
     * @return none.
     */
    @Override
    public void insert(Composer composer) {
        composers.add(composer); // Add composer to composers List.
    } // end insert
} // end MemComposerDao
