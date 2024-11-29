package com.raagnair.belt;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum CollectionTools {
    INSTANCE;

    public <E, T> T fold(Collection<E> input, T base, BiFunction<T, E, T> integrator) {
        T rv = base;
        for (E in : input) {
            rv = integrator.apply(rv, in);
        }
        return rv;
    }

    public <E> int sizeIf(Collection<E> input, Predicate<E> pred) {
        int rv = 0;
        for (E elem : input) {
            if (pred.test(elem)) rv++;
        }
        return rv;
    }
}
