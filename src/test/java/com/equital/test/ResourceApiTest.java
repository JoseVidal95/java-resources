package com.equital.test;

import com.equital.models.Resource;
import com.equital.models.ResourceApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class ResourceApiTest<R extends Resource<?, ?>> {
    protected final R resource;

    public ResourceApiTest(R resource) {
        this.resource = resource;
    }

    @Test
    @DisplayName("Api should not be [ null ]")
    void api() {
        assertDoesNotThrow(this.resource::api);

        ResourceApi api = this.resource.api();
        assertNotNull(api);
    }

}
