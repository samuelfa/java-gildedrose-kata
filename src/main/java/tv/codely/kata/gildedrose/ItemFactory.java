package tv.codely.kata.gildedrose;

import tv.codely.kata.gildedrose.annotation.ItemName;
import tv.codely.kata.gildedrose.items.DefaultItem;
import tv.codely.kata.gildedrose.items.UpdateItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class ItemFactory {
    public static UpdateItem build(Item item) throws InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        Set<Class<UpdateItem>> classList = findAllClassesUsingClassLoader();
        for (Class<UpdateItem> classObject : classList) {
            if (!classObject.isAnnotationPresent(ItemName.class)) continue;

            String itemNameValue = classObject.getAnnotation(ItemName.class).value();
            if (!Objects.equals(itemNameValue, item.name)) continue;

            return classObject.getDeclaredConstructor(Item.class).newInstance(item);
        }

        return new DefaultItem(item);
    }

    private static Set<Class<UpdateItem>> findAllClassesUsingClassLoader() throws IOException {
        String packageName = UpdateItem.class.getPackage().getName();
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class<UpdateItem> getClass(String className, String packageName) {
        try {
            return (Class<UpdateItem>) Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}