package tv.codely.kata.gildedrose.items;

import tv.codely.kata.gildedrose.Item;

public abstract class UpdateItem {
    public static final int BACKSTAGE_THRESHOLD_INC_DOUBLE_QUALITY = 10;
    public static final int BACKSTAGE_THRESHOLD_INC_TRIPLE_QUALITY = 5;
    public static final int THRESHOLD_ON_SELL_IN_EXPIRED = 0;
    public static final int THRESHOLD_MIN_QUALITY = 0;
    public static final int THRESHOLD_MAX_QUALITY = 50;

    protected final Item item;
    public UpdateItem(Item item){
        this.item = item;
    }

    protected void reduceSellInDays() {
        item.sellIn--;
    }

    protected void reduceQuality() {
        if (item.quality > THRESHOLD_MIN_QUALITY) {
            item.quality--;
        }
    }

    protected void increaseQuality() {
        if (item.quality < THRESHOLD_MAX_QUALITY) {
            item.quality++;
        }
    }

    public abstract void update();
}
