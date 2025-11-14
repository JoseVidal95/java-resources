package com.equital.events;

public enum DisposableResourceEvents implements ResourcesEvents {
    DISPOSED("disposed");

    private final String name;

    DisposableResourceEvents(String name) {
        this.name = "resource-" + name;
    }

    @Override
    public String getName() {
        return name;
    }
}
