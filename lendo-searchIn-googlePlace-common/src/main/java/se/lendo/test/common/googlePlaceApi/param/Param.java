package se.lendo.test.common.googlePlaceApi.param;

/**
 * Represents an extra, optional parameter that can be specified.
 */
public class Param {
    public final String name;
    public String value;

    public Param(String name) {
        this.name = name;
    }

    /**
     * Returns a new param with the specified valueOf.
     *
     * @param name to create Param from
     * @return new param
     */
    public static Param name(String name) {
        return new Param(name);
    }

    /**
     * Sets the searchTypeValue of the Param.
     *
     * @param value of param
     * @return this param
     */
    public Param searchTypeValue(Object value) {
        this.value = value.toString();
        return this;
    }
}
