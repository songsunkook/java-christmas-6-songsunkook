package domain.discount;

import static constant.menu.Menu.*;
import static org.junit.jupiter.api.Assertions.*;

import domain.order.Order;
import domain.order.Orders;
import java.util.List;
import org.junit.jupiter.api.Test;

class ChristmasTest {
    
    @Test
    public void 크리스마스_할인이_정상적으로_적용되는가() {
        //given
        Discount christmasDay1 = new Christmas(new Orders(
                List.of(new Order(CAESAR_SALAD, 10)), 1));
        Discount christmasDay2 = new Christmas(new Orders(
                List.of(new Order(CAESAR_SALAD, 10)), 20));
        Discount christmasDay3 = new Christmas(new Orders(
                List.of(new Order(CAESAR_SALAD, 10)), 25));
        Discount christmasDay4 = new Christmas(new Orders(
                List.of(new Order(CAESAR_SALAD, 10)), 26));
        
        //then
        assertEquals(1000, christmasDay1.discountAmount());
        assertEquals(2900, christmasDay2.discountAmount());
        assertEquals(3400, christmasDay3.discountAmount());
        assertEquals(0, christmasDay4.discountAmount());
    }
}
