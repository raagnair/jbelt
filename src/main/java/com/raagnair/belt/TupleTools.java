package com.raagnair.belt;

import com.raagnair.belt.primitives.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public enum TupleTools {
    INSTANCE;

    public <A, B> Tuple2<A, B> of(A a, B b) {return new Tuple2<>(a, b);}

    public <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {return new Tuple3<>(a, b, c);}

    public <A, B, C, D> Tuple4<A, B, C, D> of(A a, B b, C c, D d) {return new Tuple4<>(a, b, c, d);}

    public <A, B, C, D, E> Tuple5<A, B, C, D, E> of(A a, B b, C c, D d, E e) {return new Tuple5<>(a, b, c, d, e);}

    public <A, B, Out> Function<Tuple2<A, B>, Out> fn(Fn2<A, B, Out> fn) {
        return t2 -> fn.apply(t2.a(), t2.b());
    }

    public <A, B, C, Out> Function<Tuple3<A, B, C>, Out> fn(Fn3<A, B, C, Out> fn) {
        return t3 -> fn.apply(t3.a(), t3.b(), t3.c());
    }

    public <A, B, C, D, Out> Function<Tuple4<A, B, C, D>, Out> fn(Fn4<A, B, C, D, Out> fn) {
        return t4 -> fn.apply(t4.a(), t4.b(), t4.c(), t4.d());
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Out> fn(Fn5<A, B, C, D, E, Out> fn) {
        return t5 -> fn.apply(t5.a(), t5.b(), t5.c(), t5.d(), t5.e());
    }

    public <A, B> Consumer<Tuple2<A, B>> to(Cn2<A, B> cn) {
        return t2 -> cn.accept(t2.a(), t2.b());
    }

    public <A, B, C> Consumer<Tuple3<A, B, C>> to(Cn3<A, B, C> cn) {
        return t3 -> cn.accept(t3.a(), t3.b(), t3.c());
    }

    public <A, B, C, D> Consumer<Tuple4<A, B, C, D>> to(Cn4<A, B, C, D> cn) {
        return t4 -> cn.accept(t4.a(), t4.b(), t4.c(), t4.d());
    }

    public <A, B, C, D, E> Consumer<Tuple5<A, B, C, D, E>> to(Cn5<A, B, C, D, E> cn) {
        return t5 -> cn.accept(t5.a(), t5.b(), t5.c(), t5.d(), t5.e());
    }

    public <A, B, Out> Function<Tuple2<A, B>, Tuple2<Out, B>> fnA2(Function<A, Out> fn) {
        return t2 -> new Tuple2<>(fn.apply(t2.a()), t2.b());
    }

    public <A, B, Out> Function<Tuple2<A, B>, Tuple2<A, Out>> fnB2(Function<B, Out> fn) {
        return t2 -> new Tuple2<>(t2.a(), fn.apply(t2.b()));
    }

    public <A extends Dest, B extends Dest, Dest>
    Dest[] asArray(Tuple2<A, B> input, Dest[] dest) {
        dest[0] = input.a();
        dest[1] = input.b();
        return dest;
    }

    public <A, B> Tuple2<A, B> fromEntry(Map.Entry<A, B> entry) {
        return new Tuple2<>(entry.getKey(), entry.getValue());
    }

    public <A, B> Set<Tuple2<A, B>> fromMap(Map<A, B> map) {
        var rv = new HashSet<Tuple2<A, B>>(map.size());
        for (var entry : map.entrySet()) {
            rv.add(new Tuple2<>(entry.getKey(), entry.getValue()));
        }
        return rv;
    }

    public <A, B, C, Out> Function<Tuple3<A, B, C>, Tuple3<Out, B, C>> fnA3(Function<A, Out> fn) {
        return t3 -> new Tuple3<>(fn.apply(t3.a()), t3.b(), t3.c());
    }

    public <A, B, C, Out> Function<Tuple3<A, B, C>, Tuple3<A, Out, C>> fnB3(Function<B, Out> fn) {
        return t3 -> new Tuple3<>(t3.a(), fn.apply(t3.b()), t3.c());
    }

    public <A, B, C, Out> Function<Tuple3<A, B, C>, Tuple3<A, B, Out>> fnC3(Function<C, Out> fn) {
        return t3 -> new Tuple3<>(t3.a(), t3.b(), fn.apply(t3.c()));
    }

    public <A extends Dest, B extends Dest, C extends Dest, Dest>
    Dest[] asArray(Tuple3<A, B, C> input, Dest[] dest) {
        dest[0] = input.a();
        dest[1] = input.b();
        dest[2] = input.c();
        return dest;
    }

    public <A, B, C, D, Out> Function<Tuple4<A, B, C, D>, Tuple4<Out, B, C, D>> fnA4(Function<A, Out> fn) {
        return t4 -> new Tuple4<>(fn.apply(t4.a()), t4.b(), t4.c(), t4.d());
    }

    public <A, B, C, D, Out> Function<Tuple4<A, B, C, D>, Tuple4<A, Out, C, D>> fnB4(Function<B, Out> fn) {
        return t4 -> new Tuple4<>(t4.a(), fn.apply(t4.b()), t4.c(), t4.d());
    }

    public <A, B, C, D, Out> Function<Tuple4<A, B, C, D>, Tuple4<A, B, Out, D>> fnC4(Function<C, Out> fn) {
        return t4 -> new Tuple4<>(t4.a(), t4.b(), fn.apply(t4.c()), t4.d());
    }

    public <A, B, C, D, Out> Function<Tuple4<A, B, C, D>, Tuple4<A, B, C, Out>> fnD4(Function<D, Out> fn) {
        return t4 -> new Tuple4<>(t4.a(), t4.b(), t4.c(), fn.apply(t4.d()));
    }

    public <A extends Dest, B extends Dest, C extends Dest, D extends Dest, Dest>
    Dest[] asArray(Tuple4<A, B, C, D> input, Dest[] dest) {
        dest[0] = input.a();
        dest[1] = input.b();
        dest[2] = input.c();
        dest[3] = input.d();
        return dest;
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Tuple5<Out, B, C, D, E>> fnA5(Function<A, Out> fn) {
        return t5 -> new Tuple5<>(fn.apply(t5.a()), t5.b(), t5.c(), t5.d(), t5.e());
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Tuple5<A, Out, C, D, E>> fnB5(Function<B, Out> fn) {
        return t5 -> new Tuple5<>(t5.a(), fn.apply(t5.b()), t5.c(), t5.d(), t5.e());
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Tuple5<A, B, Out, D, E>> fnC5(Function<C, Out> fn) {
        return t5 -> new Tuple5<>(t5.a(), t5.b(), fn.apply(t5.c()), t5.d(), t5.e());
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Tuple5<A, B, C, Out, E>> fnD5(Function<D, Out> fn) {
        return t5 -> new Tuple5<>(t5.a(), t5.b(), t5.c(), fn.apply(t5.d()), t5.e());
    }

    public <A, B, C, D, E, Out> Function<Tuple5<A, B, C, D, E>, Tuple5<A, B, C, D, Out>> fnE5(Function<E, Out> fn) {
        return t5 -> new Tuple5<>(t5.a(), t5.b(), t5.c(), t5.d(), fn.apply(t5.e()));
    }

    public <A extends Dest, B extends Dest, C extends Dest, D extends Dest, E extends Dest, Dest>
    Dest[] asArray(Tuple5<A, B, C, D, E> input, Dest[] dest) {
        dest[0] = input.a();
        dest[1] = input.b();
        dest[2] = input.c();
        dest[3] = input.d();
        dest[4] = input.e();
        return dest;
    }
}
