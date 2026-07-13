package com.pioneers.datastructures.list;

import java.util.function.Consumer;

public class ConsumerImpl<E> implements Consumer<E> {
    @Override
    public void accept(E e) {
        if (((String) e).startsWith("A")) {
            System.out.println(e);
        }
    }
}
