package domain.giveaway;

import constant.menu.Drink;
import constant.menu.Menu;

public class Giveaway {
    private static final Menu GIVEAWAY_PRIZE = Drink.CHAMPAGNE;
    private static final int DISCOUNT_STANDARD_PRICE = 120_000;
    
    private final boolean haveGiveaway;
    
    public Giveaway(int amountBeforeDiscount) {
        haveGiveaway = amountBeforeDiscount >= DISCOUNT_STANDARD_PRICE;
    }
    
    public boolean isHave() {
        return haveGiveaway;
    }
    
    public Menu getGivewayPrize() {
        return GIVEAWAY_PRIZE;
    }
}
