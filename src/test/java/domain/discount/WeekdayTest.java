package domain.discount;

import static org.junit.jupiter.api.Assertions.*;

import constant.Appetizer;
import constant.Dessert;
import constant.Drink;
import constant.Main;
import domain.Order;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeekdayTest {
    
    @Test
    public void 디저트_할인이_정상적으로_적용되는가() {
        //given
        Discountable weekday1 = new Weekday(new OrderInformation(3, List.of(
                new Order(Appetizer.CAESAR_SALAD, 1),
                new Order(Main.CHRISTMAS_PASTA, 1),
                new Order(Drink.RED_WINE, 1)
        )));
        Discountable weekday2 = new Weekday(new OrderInformation(4, List.of(
                new Order(Appetizer.CAESAR_SALAD, 1),
                new Order(Main.CHRISTMAS_PASTA, 1),
                new Order(Dessert.ICE_CREAM, 3),
                new Order(Drink.RED_WINE, 1)
        )));
        Discountable weekday3 = new Weekday(new OrderInformation(5, List.of(
                new Order(Dessert.ICE_CREAM, 3)
        )));
        Discountable notWeekday = new Weekday(new OrderInformation(8, List.of(
                new Order(Dessert.ICE_CREAM, 10)
        )));
        
        //then
        assertEquals(0, weekday1.discountAmount());
        assertEquals(2023 * 3, weekday2.discountAmount());
        assertEquals(2023 * 3, weekday3.discountAmount());
        assertEquals(0, notWeekday.discountAmount());
    }
}
