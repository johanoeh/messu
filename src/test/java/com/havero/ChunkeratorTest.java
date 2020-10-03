package com.havero;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

class ChunkeratorTest {

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Test
    public void testNext() {

        List<Integer> inputList = new ArrayList<>();
        List<Integer> outPutList = new ArrayList<>();
        IntStream.range(0, 7777).forEach(inputList::add);

        final Chunkerator<Integer> ch = new Chunkerator<Integer>(9, inputList);
        final Iterator<List<Integer>> iterator = ch.iterator();
        while (iterator.hasNext()) {
            outPutList.addAll(iterator.next());
        }
        softAssertions.assertThat(inputList.size()).isEqualTo(outPutList.size());
    }

    @Test
    public void testNext_exception() {
        try {
            final Chunkerator<Integer> ch = new Chunkerator<Integer>(0, Collections.emptyList());
            Assert.fail("Expected exception");
        } catch (IllegalArgumentException e) {

        }
    }
}
