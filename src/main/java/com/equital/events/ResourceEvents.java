package com.equital.events;

public enum ResourceEvents implements ResourcesEvents {
    UPDATE("updated");

    private final String name;

    ResourceEvents(String name) {
        this.name = "resource-" + name;
    }

    public String getName() {
        return name;
    }
}
