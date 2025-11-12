package com.equital.resources.events;

public enum LoadableResourceEvents implements ResourcesEvents {
    LOADING("loading"),
    LOADED("loaded");

    private final String name;

    LoadableResourceEvents(String name) {
        this.name = "resource-" + name;
    }

    @Override
    public String getName() {
        return name;
    }
}
