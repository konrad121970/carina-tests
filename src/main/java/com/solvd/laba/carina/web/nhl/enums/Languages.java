package com.solvd.laba.carina.web.nhl.enums;

public enum Languages {
    ENGLISH("English"),
    FRENCH("Français"),
    GERMAN("Deutsch"),
    FINNISH("Suomi"),
    SWEDISH("Svenska"),
    CZECH("Čeština"),
    SLOVAK("Slovenčina"),
    SPANISH("Español");

    private final String name;

    Languages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
