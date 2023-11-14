package domain.giveaway;

import static org.junit.jupiter.api.Assertions.*;

import constant.menu.Drink;
import org.junit.jupiter.api.Test;

class GiveawayTest {
    
    @Test
    public void 특정_금액_이상_주문_시_증정품이_주어지는가() {
        //given
        Giveaway noGiveaway1 = new Giveaway(10000);
        Giveaway noGiveaway2 = new Giveaway(50000);
        Giveaway noGiveaway3 = new Giveaway(100000);
        Giveaway giveaway1 = new Giveaway(120000);
        Giveaway giveaway2 = new Giveaway(200000);
        
        //then
        assertFalse(noGiveaway1.isHave());
        assertFalse(noGiveaway2.isHave());
        assertFalse(noGiveaway3.isHave());
        assertTrue(giveaway1.isHave());
        assertTrue(giveaway2.isHave());
    }
    
    @Test
    public void 상품이_올바르게_증정되는가() {
        //given
        Giveaway giveaway1 = new Giveaway(120000);
        Giveaway giveaway2 = new Giveaway(200000);
        
        //then
        assertEquals(Drink.CHAMPAGNE, giveaway1.getGivewayPrize());
        assertEquals(Drink.CHAMPAGNE, giveaway2.getGivewayPrize());
    }
}
