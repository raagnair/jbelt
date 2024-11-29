package com.raagnair.belt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum CollectionTools {
    INSTANCE;

    public <E> List<E> noList() {return Collections.emptyList();}

    public <E> Set<E> noSet() {return Collections.emptySet();}

    public <E, T> T fold(Collection<E> in, T base, BiFunction<T, E, T> integrator) {
        T rv = base;
        for (E elem : in) {
            rv = integrator.apply(rv, elem);
        }
        return rv;
    }

    public <E> int sizeIf(Collection<E> in, Predicate<E> pred) {
        int rv = 0;
        for (E elem : in) {
            if (pred.test(elem)) rv++;
        }
        return rv;
    }

    public <E> boolean isEmptyIf(Collection<E> in, Predicate<E> pred) {
        for (E e : in) {
            if (pred.test(e)) return false;
        }
        return true;
    }

    public <E, C extends Collection<E>> C filter(Collection<E> in, Predicate<E> pred, C dest) {
        for (E elem : in) {
            if (pred.test(elem)) dest.add(elem);
        }
        return dest;
    }

    public <E, C extends Collection<E>>
    C filter(Collection<E> in, Predicate<E> pred, Supplier<C> newDestFn, C defaultDest) {
        C rv = defaultDest;
        boolean noneFound = true;
        for (E elem : in) {
            if (pred.test(elem)) {
                if (noneFound) {
                    noneFound = false;
                    rv = newDestFn.get();
                }
                rv.add(elem);
            }
        }
        return rv;
    }
}
