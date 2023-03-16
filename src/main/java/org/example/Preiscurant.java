package org.example;

import java.util.HashMap;
import java.util.Map;

public final class Preiscurant {
    private final Map<Item, Price> basicMap = new HashMap<>();

    public boolean addItem(Item item, Price price) {
        if (!basicMap.containsKey(item)) {
            basicMap.put(item, price);
            return true;
        }
        else return false;
    }

    public boolean deleteItem(Item item) {
        boolean flag = basicMap.containsKey(item);
        basicMap.remove(item);
        return flag;
    }

    public boolean changeName(Item item, String name) {
        if (basicMap.containsKey(item)) {
            for (Item item1: basicMap.keySet()) {
                if (item1 == item) {
                    item1.setName(name);
                }
            }
            return true;
        }
        else return false;
    }

    public boolean changePrice(Item item, int newRoubles, int newCopeks) {
        if (basicMap.containsKey(item)) {
            Price oldPrice = basicMap.get(item);
            Price newPrice = new Price(newRoubles, newCopeks);
            basicMap.replace(item, oldPrice, newPrice);
            return true;
        }
        else return false;
    }

    public float count(int code, int amount) {
        if (code < 0 || amount < 0)
            throw new IllegalArgumentException("Invalid args");
        float res = -1;
        for (Item item: basicMap.keySet()) {
            if (item.getCode() == code) {
                float roubles = (float) basicMap.get(item).getRoubles();
                float copeks = (float) basicMap.get(item).getCopeks();
                res = (roubles + copeks / 100) * amount;
            }
        }
        if (res != -1) return res;
        else throw new IllegalStateException("No such item in a preiscurant");
    }

}
