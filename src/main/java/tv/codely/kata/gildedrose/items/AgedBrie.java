package tv.codely.kata.gildedrose.items;

import tv.codely.kata.gildedrose.Item;
import tv.codely.kata.gildedrose.annotation.ItemName;

@ItemName("Aged Brie")
public final class AgedBrie extends UpdateItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        reduceSellInDays();
        increaseQuality();

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            increaseQuality();
        }
    }
}
