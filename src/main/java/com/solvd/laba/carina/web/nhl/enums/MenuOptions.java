package com.solvd.laba.carina.web.nhl.enums;

public enum MenuOptions {

    NEWS("News", 1, "https://www.nhl.com/news/"),
    SCORES("Scores", 1, "https://www.nhl.com/scores"),
    STANDINGS("Standings", 1, "https://www.nhl.com/standings"),
    SCHEDULE("Schedule", 2, "https://www.nhl.com/schedule"),
    STATS("Stats", 2, "https://www.nhl.com/stats/"),
    VIDEO("Video", 2, "https://www.nhl.com/video/"),
    PLAYERS("Players", 2, "https://www.nhl.com/player"),
    FANTASY("Fantasy", 2, "https://www.nhl.com/fantasy/"),
    COMMUNITY("Community", 2, "https://www.nhl.com/community/"),
    TEAMS("Teams", 2, "https://www.nhl.com/info/teams/"),
    SHOP("Shop", 2, "https://shop.nhl.com/"),
    TICKETS("Tickets", 2, "https://www.nhl.com/tickets/");

    private String name;
    private int navbarNumber;
    private String url;

    MenuOptions(String name, int navbarNumber, String url) {
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

    public String getUrl() {
        return url;
    }
}
