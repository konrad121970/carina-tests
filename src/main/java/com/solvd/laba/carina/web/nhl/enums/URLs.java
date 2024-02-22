package com.solvd.laba.carina.web.nhl.enums;

public enum URLs {

    // Header
    NEWS("https://www.nhl.com/news/"),
    SCORES("https://www.nhl.com/scores"),
    STANDINGS("https://www.nhl.com/standings"),
    SCHEDULE("https://www.nhl.com/schedule"),
    STATS("https://www.nhl.com/stats/"),
    VIDEO("https://www.nhl.com/video/"),
    PLAYERS("https://www.nhl.com/player"),
    FANTASY("https://www.nhl.com/fantasy/"),
    COMMUNITY("https://www.nhl.com/community/"),
    TEAMS("https://www.nhl.com/info/teams/"),
    SHOP("https://shop.nhl.com/"),
    TICKETS("https://www.nhl.com/tickets/"),

    // Footer
    TERMS_OF_SERVICE("https://www.nhl.com/info/terms-of-service"),
    PRIVACY_POLICY("https://www.nhl.com/info/privacy-policy"),
    COOKIE_POLICY("https://www.nhl.com/info/cookie-policy"),
    COOKIE_SETTINGS("https://www.nhl.com/info/cookie-settings"),
    COPYRIGHT_POLICY("https://www.nhl.com/info/copyright-policy"),
    PRIVACY_CHOICES("https://www.nhl.com/info/your-privacy-choices"),
    CAREERS("https://www.nhl.com/info/careers"),
    ABOUT("https://www.nhl.com/info/about-the-nhl"),

    //SHOP
    SHOP_MEN("https://shop.nhl.com/men");


    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
