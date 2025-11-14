package com.equital.test;

import com.equital.models.PropertyResource;
import com.equital.models.ResourceData;
import com.equital.test.data.IntegerPropertyResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    @DisplayName("Resource data should not be null")
    void data() {
        final ResourceData<String> data = this.resource.data();
        assertNotNull(data);

        final String content = "Resource Data";
        data.set(content);
        assertNotNull(data.get());
        assertEquals(content, data.get());
    }

    @BeforeEach
    void init() {
        this.resource.set(this.defaultValue);
    }

}