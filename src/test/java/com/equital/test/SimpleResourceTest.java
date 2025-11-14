package com.equital.test;

import com.equital.models.ResourceApi;
import com.equital.models.SimplePropertyResource;
import com.equital.resources.SimplePropertyResourceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleResourceTest {

    private final Integer defaultValue = 30;
    private final SimplePropertyResource<Integer> resource;

    public SimpleResourceTest() {
        this.resource = new SimplePropertyResourceImp<>(0);
    }

    @Test
    void test() {
        assertEquals(this.defaultValue, this.resource.get());

        final Integer newValue = 80;
        this.resource.set(newValue);

        final Integer current = this.resource.get();

        assertNotNull(current);
        assertEquals(newValue, current);
    }

    @Test
    void api() {
        assertDoesNotThrow(this.resource::api);

        final ResourceApi api = this.resource.api();
        assertNull(api);
    }

    @BeforeEach
    void init() {
        this.resource.set(this.defaultValue);
    }
}
