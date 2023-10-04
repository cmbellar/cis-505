/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** 
 * An interface named ComposerDao to represent the operations in a composer data persistence layer. 
 * This interface extends the GenericDao interface, using the Composer object and Integer as its 
 * generic arguments.
 */
public interface ComposerDao extends GenericDao<Composer, Integer> {

} // end ComposerDao
