package domain.discount;

import static constant.menu.Menu.*;
import static org.junit.jupiter.api.Assertions.*;

import domain.order.Order;
import domain.order.Orders;
import java.util.List;
import org.junit.jupiter.api.Test;

class WeekendTest {
    
    @Test
    public void 주말_할인이_정상적으로_적용되는가() {
        //given
        Discount notWeekend = new Weekend(new Orders(List.of(
                new Order(CAESAR_SALAD, 1),
                new Order(CHRISTMAS_PASTA, 10),
                new Order(ICE_CREAM, 1),
                new Order(RED_WINE, 1)
        ), 3));
        Discount weekend1 = new Weekend(new Orders(List.of(
                new Order(CAESAR_SALAD, 1),
                new Order(ICE_CREAM, 1),
                new Order(RED_WINE, 1)
        ), 1));
        Discount weekend2 = new Weekend(new Orders(List.of(
                new Order(CAESAR_SALAD, 1),
                new Order(CHRISTMAS_PASTA, 3),
                new Order(ICE_CREAM, 1),
                new Order(RED_WINE, 1)
        ), 1));
        
        //then
        assertEquals(0, notWeekend.discountAmount());
        assertEquals(0, weekend1.discountAmount());
        assertEquals(2023 * 3, weekend2.discountAmount());
    }
}
