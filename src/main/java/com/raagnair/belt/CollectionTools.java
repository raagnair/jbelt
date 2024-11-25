package com.raagnair.belt;

import java.util.Collection;
import java.util.function.BiFunction;

public enum CollectionTools {
    INSTANCE;

    public <E, T> T fold(Collection<E> input, T base, BiFunction<T, E, T> integrator) {
        T rv = base;
        for (E in : input) {
            rv = integrator.apply(rv, in);
        }
        return rv;
    }
}
