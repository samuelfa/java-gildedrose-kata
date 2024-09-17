package tv.codely.kata.gildedrose;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final int BACKSTAGE_THRESHOLD_INC_DOUBLE_QUALITY = 10;
    public static final int BACKSTAGE_THRESHOLD_INC_TRIPLE_QUALITY = 5;
    public static final int THRESHOLD_ON_SELL_IN_EXPIRED = 0;
    public static final int NO_QUALITY = 0;

    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    break;

                case AGED_BRIE:
                    onAgedBrieUpdateQuality(item);
                    break;

                case BACKSTAGE:
                    onBackstageUpdateQuality(item);
                    break;
                default:
                    onDefaultItemUpdateQuality(item);
            }
        }
    }

    private static void onBackstageUpdateQuality(Item item) {
        reduceSellInDays(item);
        increaseQuality(item);

        if (item.sellIn < BACKSTAGE_THRESHOLD_INC_DOUBLE_QUALITY) {
            increaseQuality(item);
        }

        if (item.sellIn < BACKSTAGE_THRESHOLD_INC_TRIPLE_QUALITY) {
            increaseQuality(item);
        }

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            item.quality = NO_QUALITY;
        }
    }

    private static void onDefaultItemUpdateQuality(Item item) {
        reduceSellInDays(item);
        reduceQuality(item);

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            reduceQuality(item);
        }
    }

    private static void onAgedBrieUpdateQuality(Item item) {
        reduceSellInDays(item);
        increaseQuality(item);

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            increaseQuality(item);
        }
    }

    private static void reduceSellInDays(Item item) {
        item.sellIn--;
    }

    private static void reduceQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
