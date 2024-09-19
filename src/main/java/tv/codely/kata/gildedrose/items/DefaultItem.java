package tv.codely.kata.gildedrose.items;

import tv.codely.kata.gildedrose.Item;

public final class DefaultItem extends UpdateItem {

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        reduceSellInDays();
        reduceQuality();

        if (item.sellIn < THRESHOLD_ON_SELL_IN_EXPIRED) {
            reduceQuality();
        }
    }
}
