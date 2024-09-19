package tv.codely.kata.gildedrose.items;

import tv.codely.kata.gildedrose.Item;
import tv.codely.kata.gildedrose.annotation.ItemName;

@ItemName("Backstage passes to a TAFKAL80ETC concert")
public final class Backstage extends UpdateItem {

    public Backstage(Item item) {
        super(item);
    }

    @Override
    public void update() {
        reduceSellInDays();
        increaseQuality();

        if (item.sellIn < BACKSTAGE_THRESHOLD_INC_DOUBLE_QUALITY) {
            increaseQuality();
        }

        if (item.sellIn < BACKSTAGE_THRESHOLD_INC_TRIPLE_QUALITY) {
            increaseQuality();
        }

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            item.quality = THRESHOLD_MIN_QUALITY;
        }
    }
}
