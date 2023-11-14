package domain.discount;

import static constant.menu.Menu.*;
import static org.junit.jupiter.api.Assertions.*;

import domain.order.Order;
import domain.order.Orders;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeekdayTest {
    
    @Test
    public void 디저트_할인이_정상적으로_적용되는가() {
        //given
        Discount weekday1 = new Weekday(new Orders(List.of(
                new Order(CAESAR_SALAD, 1),
                new Order(CHRISTMAS_PASTA, 1),
                new Order(RED_WINE, 1)
        ), 3));
        Discount weekday2 = new Weekday(new Orders(List.of(
                new Order(CAESAR_SALAD, 1),
                new Order(CHRISTMAS_PASTA, 1),
                new Order(ICE_CREAM, 3),
                new Order(RED_WINE, 1)
        ), 4));
        Discount weekday3 = new Weekday(new Orders(List.of(
                new Order(ICE_CREAM, 3)
        ), 5));
        Discount notWeekday = new Weekday(new Orders(List.of(
                new Order(ICE_CREAM, 10)
        ), 8));
        
        //then
        assertEquals(0, weekday1.discountAmount());
        assertEquals(2023 * 3, weekday2.discountAmount());
        assertEquals(2023 * 3, weekday3.discountAmount());
        assertEquals(0, notWeekday.discountAmount());
    }
}
