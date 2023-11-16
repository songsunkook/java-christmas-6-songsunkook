package domain.discount;

import static org.junit.jupiter.api.Assertions.*;

import constant.menu.Menu;
import domain.order.Order;
import domain.order.Orders;
import java.util.List;
import org.junit.jupiter.api.Test;

class SpecialTest {
    
    @Test
    public void 특별_할인이_정상적으로_적용되는가() {
        //given
        Discount notStarDay = new Special(new Orders(List.of(
                new Order(Menu.CAESAR_SALAD, 10)
        ), 4));
        Discount starDay = new Special(new Orders(List.of(
                new Order(Menu.CAESAR_SALAD, 10)
        ), 3));
        
        //then
        assertEquals(0, notStarDay.discountAmount());
        assertEquals(1000, starDay.discountAmount());
    }
}
