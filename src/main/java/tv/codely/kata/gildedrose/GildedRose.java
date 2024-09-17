package tv.codely.kata.gildedrose;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case GildedRose.SULFURAS:
                    break;

                case GildedRose.AGED_BRIE:
                    increaseQuality(item);
                    item.sellIn--;
                    if (item.sellIn < 0) {
                        increaseQuality(item);
                    }
                    break;

                case GildedRose.BACKSTAGE:
                    increaseQuality(item);

                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }

                    item.sellIn--;
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality--;
                    }
                    item.sellIn--;


                    if (item.sellIn < 0) {
                        if (item.quality > 0) {
                            item.quality--;
                        }
                    }
            }
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
