/**
 * This is an example of immutable class in Java having no setters, no Child classes
 * and using 'final' variables, private default constructors and having a factory method to instantiate the objects
 *
 * Also, NOTE this is a USE CASE/BUSINESS REQUIREMENT for "IMMUTABLE CLASS WITH A MUTABLE VARIABLE"
 */

/**
 * Always remember that your instance variables will be either mutable or immutable.
 * Identify them and return new objects with copied content for all mutable objects.
 * Immutable variables can be returned safely without extra effort.
 * */

import java.util.Date;

public final class ImmutableJavaClass {

    private final Integer immutableField1=0;

    private final String immutableField2="String";

    private final Date mutableField;

    //Default private constructor will ensure no unplanned construction of class
    private ImmutableJavaClass(Integer fld1, String fld2, Date date) {
        this.immutableField1 = fld1;
        this.immutableField2 = fld2;
        this.mutableField = new Date (date.getTime());
    }

    //Factory method to store object creation logic in single place
    public static ImmutableJavaClass createNewInstance (Integer fld1, String fld2, Date date) {
        return new ImmutableJavaClass(fld1, fld2, date);
    }

    //Now we use getter() methods to return variables
    public Integer getImmutableField1() {
        return immutableField1;
    }

    public String getImmutableField2() {
        return immutableField2;
    }

    /**
     * Date class is mutable so we need a little care here.
     * We should not return the reference of original instance variable.
     * Instead a new Date object, with content copied to it, should be returned.
     * */
    public Date getMutableField() {
        return new Date (mutableField.getTime());
    }

    @Override
    public String toString(){
        return immutableField1 + "-" + immutableField2 + "-" + mutableField;
    }


}
