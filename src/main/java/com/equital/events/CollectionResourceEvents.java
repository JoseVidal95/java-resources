package com.equital.events;

public enum CollectionResourceEvents implements ResourcesEvents {
    CREATED("created"),
    ADD("add"),
    REMOVE("remove");

    private final String name;

    CollectionResourceEvents(String name) {
        this.name = "resource-" + name;
    }

    public String getName() {
        return name;
    }
}
