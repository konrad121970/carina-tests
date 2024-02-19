package com.solvd.laba.carina.web.nhl.enums;

public enum FooterOptions {
    TERMS_OF_SERVICE("Terms of Service"),
    PRIVACY_POLICY("NHL.com Privacy Policy"),
    COOKIE_POLICY("Cookie Policy"),
    COOKIE_SETTINGS("Cookie Settings"),
    COPYRIGHT_POLICY("Copyright Policy"),
    PRIVACY_CHOICES("Your Privacy Choices"),
    CAREERS("Careers"),
    ABOUT("About");

    public final String name;

    FooterOptions(String name) {
        this.name = name;
    }
}
