package domain.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiscountableTest {
    
    @Test
    public void 할인이_정상적으로_적용되는가() {
        //given
        Discountable christmasDay1 = new Christmas(new OrderInformation(1, null));
        Discountable christmasDay2 = new Christmas(new OrderInformation(20, null));
        Discountable christmasDay3 = new Christmas(new OrderInformation(25, null));
        Discountable christmasDay4 = new Christmas(new OrderInformation(26, null));
        
        //then
        assertEquals(1000, christmasDay1.discountAmount());
        assertEquals(2900, christmasDay2.discountAmount());
        assertEquals(3400, christmasDay3.discountAmount());
        assertEquals(0, christmasDay4.discountAmount());
    }
}
