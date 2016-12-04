package se.lendo.test.common.googlePlaceApi.builder;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public interface ParentSubClassBuilder<T, U> extends SubClassBuilder<U> {

    T self();
}
