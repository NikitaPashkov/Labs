import org.example.Item;
import org.example.Preiscurant;
import org.example.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PreiscurantTest {

    @Test
    void addItemTest() {
        Preiscurant preiscurant = new Preiscurant();
        Item item1 = new Item("Курица", 10);
        Price price1 = new Price(150, 10);
        Item item2 = new Item("Колбаса", 18);
        Price price2 = new Price(90, 0);

        Assertions.assertTrue(preiscurant.addItem(item1, price1));
        Assertions.assertTrue(preiscurant.addItem(item2, price2));
        Assertions.assertFalse(preiscurant.addItem(item1, price1));
    }

    @Test
    void deleteItemTest() {
        Preiscurant preiscurant = new Preiscurant();
        Item item1 = new Item("Курица", 10);
        Price price1 = new Price(150, 10);
        Item item2 = new Item("Колбаса", 18);
        Price price2 = new Price(90, 0);
        Item item3 = new Item("Йогурт", 50);

        Assertions.assertTrue(preiscurant.addItem(item1, price1));
        Assertions.assertTrue(preiscurant.addItem(item2, price2));
        Assertions.assertTrue(preiscurant.deleteItem(item2));
        Assertions.assertFalse(preiscurant.deleteItem(item3));
    }

    @Test
    void changeNameTest() {
        Preiscurant preiscurant = new Preiscurant();
        Item item1 = new Item("Ананасовый сироп", 45);
        Price price1 = new Price(200, 15);
        Item item2 = new Item("Йогурт", 50);

        Assertions.assertTrue(preiscurant.addItem(item1,
                price1));
        Assertions.assertTrue(preiscurant.changeName(item1, "Сироп из ананасов"));
        Assertions.assertFalse(preiscurant.changeName(item2, "Йогурт банановый"));
    }

    @Test
    void changePriceTest() {
        Preiscurant preiscurant = new Preiscurant();
        Item item1 = new Item("Курица", 10);
        Price price1 = new Price(150, 10);
        Item item2 = new Item("Ананасовый сироп", 45);

        Assertions.assertTrue(preiscurant.addItem(item1, price1));
        Assertions.assertTrue(preiscurant.changePrice(item1, 180, 0));
        Assertions.assertFalse(preiscurant.changePrice(item2, 300, 25));
    }

    @Test
    void countTest() {
        Preiscurant preiscurant = new Preiscurant();
        Item item1 = new Item("Курица", 10);
        Price price1 = new Price(150, 10);
        Item item2 = new Item("Ананасовый сироп", 45);
        Price price2 = new Price(260, 30);
        Item item3 = new Item("Берёзовый сок", 77);
        Price price3 = new Price(90, 0);

        Assertions.assertTrue(preiscurant.addItem(item1, price1));
        Assertions.assertTrue(preiscurant.addItem(item2, price2));
        Assertions.assertTrue(preiscurant.addItem(item3, price3));
        Assertions.assertEquals(1301.5, preiscurant.count(45, 5));
        Assertions.assertEquals(360.0, preiscurant.count(77, 4));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            preiscurant.count(10, -3);
        });
        Assertions.assertEquals("Invalid args", exception.getMessage());

        IllegalStateException exception1 = Assertions.assertThrows(IllegalStateException.class, () -> {
            preiscurant.count(101, 5);
        });
        Assertions.assertEquals("No such item in a preiscurant", exception1.getMessage());

    }
}
