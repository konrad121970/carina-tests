package com.solvd.laba.carina.web.nhl.enums;

public enum FooterOptions {
    TERMS_OF_SERVICE("Terms of Service", URLs.TERMS_OF_SERVICE),
    PRIVACY_POLICY("NHL.com Privacy Policy", URLs.PRIVACY_POLICY),
    COOKIE_POLICY("Cookie Policy", URLs.COOKIE_POLICY),
    COOKIE_SETTINGS("Cookie Settings", URLs.COOKIE_SETTINGS),
    COPYRIGHT_POLICY("Copyright Policy", URLs.COPYRIGHT_POLICY),
    PRIVACY_CHOICES("Your Privacy Choices", URLs.PRIVACY_CHOICES),
    CAREERS("Careers", URLs.CAREERS),
    ABOUT("About", URLs.ABOUT);

    private final String name;
    private final URLs url;

    FooterOptions(String name, URLs url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public URLs getUrl() {
        return url;
    }
}
