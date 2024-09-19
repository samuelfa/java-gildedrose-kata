package tv.codely.kata.gildedrose;

import tv.codely.kata.gildedrose.items.UpdateItem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException, NoSuchMethodException {
        for (Item item : items) {
            UpdateItem updateItem = ItemFactory.build(item);
            updateItem.update();
        }
    }

}
