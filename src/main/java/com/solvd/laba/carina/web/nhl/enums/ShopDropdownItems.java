package com.solvd.laba.carina.web.nhl.enums;

public enum ShopDropdownItems {

    NHL_SHOP("NHL Shop"),
    AUCTIONS("Auctions"),
    JERSEYS("Jerseys"),
    MEN("Men"),
    WOMEN("Women"),
    KIDS("Kids"),
    PHOTOS("Photos.com"),
    NHL_SHOP_NYC("NHL Shop - NYC");

    private final String name;

    ShopDropdownItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
