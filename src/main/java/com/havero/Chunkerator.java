package com.havero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Chunkerator<T> implements Iterable<List<T>> {

    private final int chunkSize;
    private final List<T> list;

    public Chunkerator(int chunkSize, List<T> list) {
        if(chunkSize <= 0){ throw new IllegalArgumentException("ChunkSize must be greater than 0");}
        this.chunkSize = chunkSize;
        this.list = list;
    }

    @Override
    public Iterator<List<T>> iterator() {
        final Iterator<T> iterator = list.iterator();
        return new Iterator<List<T>>() {

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public List<T> next() {
                final List<T> list = new ArrayList<>();
                for (int i = 0; iterator.hasNext() && i < chunkSize; i++) {
                    list.add(iterator.next());
                }
                return list;
            }
        };
    }
}
