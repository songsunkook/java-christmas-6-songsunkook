package domain.discount;

import static org.junit.jupiter.api.Assertions.*;

import constant.Appetizer;
import constant.Dessert;
import constant.Drink;
import constant.Main;
import domain.Order;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeekendTest {
    
    @Test
    public void 주말_할인이_정상적으로_적용되는가() {
        //given
        Discount notWeekend = new Weekend(new OrderInformation(3, List.of(
                new Order(Appetizer.CAESAR_SALAD, 10),
                new Order(Main.CHRISTMAS_PASTA, 10),
                new Order(Dessert.ICE_CREAM, 10),
                new Order(Drink.RED_WINE, 10)
        )));
        Discount weekend1 = new Weekend(new OrderInformation(1, List.of(
                new Order(Appetizer.CAESAR_SALAD, 1),
                new Order(Dessert.ICE_CREAM, 1),
                new Order(Drink.RED_WINE, 1)
        )));
        Discount weekend2 = new Weekend(new OrderInformation(1, List.of(
                new Order(Appetizer.CAESAR_SALAD, 1),
                new Order(Main.CHRISTMAS_PASTA, 3),
                new Order(Dessert.ICE_CREAM, 1),
                new Order(Drink.RED_WINE, 1)
        )));
        
        //then
        assertEquals(0, notWeekend.discountAmount());
        assertEquals(0, weekend1.discountAmount());
        assertEquals(2023 * 3, weekend2.discountAmount());
    }
}
