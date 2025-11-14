package com.equital.test;

import com.equital.models.PropertyResource;
import com.equital.test.data.IntegerPropertyResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyResourceTest extends ResourceApiTest<PropertyResource<Integer, ?, ?>> {

    private final int defaultValue = 25;

    public PropertyResourceTest() {
        super(new IntegerPropertyResource(0));
    }

    @Test
    @DisplayName("Should assert [ defaultValue ] value")
    void get() {
        assertEquals(this.defaultValue, this.resource.get());
    }

    @Test
    @DisplayName("Should assert [ newValue ] value")
    void set() {
        final int newValue = 38;
        this.resource.set(newValue);

        assertEquals(newValue, this.resource.get());
    }

    @BeforeEach
    void init() {
        this.resource.set(this.defaultValue);
    }

}