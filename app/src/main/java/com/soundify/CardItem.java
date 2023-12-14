package com.soundify;

public class CardItem {

    private String name;
    private String price;
    private String subscript;
    private String subscription1;
    private String subscription2;
    private String subscription3;
    private int icon1;
    private int icon2;
    private int icon3;
    private int cardBackgroundColor;

    public CardItem(String name, String price, String subscript, String subscription1,
                    String subscription2, String subscription3, int icon1,
                    int icon2, int icon3, int cardBackgroundColor) {

        this.name = name;
        this.price = price;
        this.subscript = subscript;
        this.subscription1 = subscription1;
        this.subscription2 = subscription2;
        this.subscription3 = subscription3;
        this.icon1 = icon1;
        this.icon2 = icon2;
        this.icon3 = icon3;
        this.cardBackgroundColor = cardBackgroundColor;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSubscript() {
        return subscript;
    }

    public int getCardBackgroundColor() { return cardBackgroundColor; }

    public String getSubscription1() {
        return subscription1;
    }

    public String getSubscription2() {
        return subscription2;
    }

    public String getSubscription3() {
        return subscription3;
    }

    public int getIcon1() {
        return icon1;
    }

    public int getIcon2() {
        return icon2;
    }

    public int getIcon3() {
        return icon3;
    }
}
