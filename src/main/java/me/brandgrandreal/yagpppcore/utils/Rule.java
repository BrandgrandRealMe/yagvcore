package me.brandgrandreal.yagpppcore.utils;

public class Rule {
    private final String name;
    private final String description;

    public Rule(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;

    }
}
