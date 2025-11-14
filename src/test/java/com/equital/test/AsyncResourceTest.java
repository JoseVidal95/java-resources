package com.equital.test;

import com.equital.models.LoadableResource;
import com.equital.test.data.StringLoadableResource;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AsyncResourceTest extends ResourceApiTest<LoadableResource<?, ?>> {

    public AsyncResourceTest() {
        super(new StringLoadableResource());
    }

    @Test
    void loading() {
        assertFalse(this.resource.loading());
        this.resource.onLoading();
        assertTrue(this.resource.loading());
    }

    @Test
    void start() {
        assertNull(this.resource.start());

        this.resource.onLoading();

        assertNotNull(this.resource.start());
        assertInstanceOf(Date.class, this.resource.start());
    }

    @Test
    void end() {
        assertNull(this.resource.end());

        this.resource.onLoaded();

        assertNotNull(this.resource.end());
        assertInstanceOf(Date.class, this.resource.end());
    }

    @Test
    void onLoading() {
        assertNull(this.resource.start());
        assertNull(this.resource.end());
        assertFalse(this.resource.loading());

        this.resource.onLoading();

        assertNotNull(this.resource.start());
        assertInstanceOf(Date.class, this.resource.start());
        assertNull(this.resource.end());
        assertTrue(this.resource.loading());
    }

    @Test
    void onLoaded() {
        assertNull(this.resource.start());
        assertNull(this.resource.end());
        assertFalse(this.resource.loading());

        this.resource.onLoaded();

        assertNull(this.resource.start());
        assertNotNull(this.resource.end());
        assertInstanceOf(Date.class, this.resource.end());
        assertFalse(this.resource.loading());
    }

    @Test
    void full() {
        assertNull(this.resource.start());
        assertNull(this.resource.end());
        assertFalse(this.resource.loading());

        this.resource.onLoading();

        assertNotNull(this.resource.start());
        assertInstanceOf(Date.class, this.resource.start());
        assertNull(this.resource.end());
        assertTrue(this.resource.loading());

        this.resource.onLoaded();

        assertNotNull(this.resource.start());
        assertInstanceOf(Date.class, this.resource.start());
        assertNotNull(this.resource.end());
        assertInstanceOf(Date.class, this.resource.end());
        assertFalse(this.resource.loading());
    }
}