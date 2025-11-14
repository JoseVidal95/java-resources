package com.equital.test;

import com.equital.models.ListResource;
import com.equital.test.data.IntegerListResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ListResourceTest extends ResourceApiTest<ListResource<Integer, ?, ?>> {

    private final List<Integer> defaultValues;

    public ListResourceTest() {
        super(new IntegerListResource(Collections.emptyList()));
        this.defaultValues = Arrays.asList(24, 28, 35, 100, 46);
    }

    @Test
    @DisplayName("defaulsValues.size() and resource.size() should be equals")
    void size() {
        assertEquals(this.defaultValues.size(), this.resource.size());
    }

    @Test
    @DisplayName("Resource should add a single and a collection of items")
    void add() {
        final int newValue = 950103;

        this.resource.add(newValue);
        assertEquals(this.defaultValues.size() + 1, this.resource.size());

        final List<Integer> newValues = Arrays.asList(56, 21, 33);

        this.resource.add(newValues);
        assertEquals(this.defaultValues.size() + newValues.size() + 1, this.resource.size());

        List<Integer> joinedValues = new ArrayList<>(this.defaultValues);
        joinedValues.add(newValue);
        joinedValues.addAll(newValues);

        assertIterableEquals(joinedValues, this.resource.get());
    }

    @Test
    @DisplayName("Resource should remove the last element")
    void remove() {
        this.resource.remove(this.resource.size() - 1);
        assertEquals(this.defaultValues.size() - 1, this.resource.size());
    }

    @Test
    @DisplayName("Resource should return the first element")
    void first() {
        final int first = this.resource.first();
        assertEquals(this.defaultValues.get(0), first);
    }

    @Test
    @DisplayName("Resource should return the last element")
    void last() {
        final int last = this.resource.last();
        assertEquals(this.defaultValues.get(this.defaultValues.size() - 1), last);
    }

    @Test
    @DisplayName("Every call to [ get ] should return the expected array")
    void get() {
        for (int i = 0; i < this.defaultValues.size(); i++) {
            final int value = this.resource.get(i);
            assertEquals(this.defaultValues.get(i), value);
        }

        final Iterable<Integer> values = this.resource.get();
        assertIterableEquals(this.defaultValues, values);
    }

    @Test
    @DisplayName("List must be empty")
    void clear() {
        this.resource.clear();
        assertEquals(0, this.resource.size());
    }

    @BeforeEach
    void init() {
        this.resource.add(this.defaultValues);
    }

}