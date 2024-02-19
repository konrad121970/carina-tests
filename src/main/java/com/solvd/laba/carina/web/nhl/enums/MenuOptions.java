package com.solvd.laba.carina.web.nhl.enums;

public enum MenuOptions {

    NEWS("News", 1, URLs.NEWS),
    SCORES("Scores", 1, URLs.SCORES),
    STANDINGS("Standings", 1, URLs.STANDINGS),
    SCHEDULE("Schedule", 2, URLs.SCHEDULE),
    STATS("Stats", 2, URLs.STATS),
    VIDEO("Video", 2, URLs.VIDEO),
    PLAYERS("Players", 2, URLs.PLAYERS),
    FANTASY("Fantasy", 2, URLs.FANTASY),
    COMMUNITY("Community", 2, URLs.COMMUNITY),
    TEAMS("Teams", 2, URLs.TEAMS),
    SHOP("Shop", 2, URLs.SHOP),
    TICKETS("Tickets", 2, URLs.TICKETS);

    private final String name;
    private final int navbarNumber;
    private final URLs url;

    MenuOptions(String name, int navbarNumber, URLs url) {
        this.name = name;
        this.navbarNumber = navbarNumber;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public int getNavbarNumber() {
        return navbarNumber;
    }

    public URLs getUrl() {
        return url;
    }
}
