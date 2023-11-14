package domain.giveaway;

import constant.menu.Menu;

public class Giveaway {
    private static final Menu GIVEAWAY_PRIZE = Menu.CHAMPAGNE;
    private static final int DISCOUNT_STANDARD_PRICE = 120_000;
    
    private final boolean haveGiveaway;
    private int count = 0;
    
    public Giveaway(int amountBeforeDiscount) {
        haveGiveaway = amountBeforeDiscount >= DISCOUNT_STANDARD_PRICE;
        if (haveGiveaway) {
            count = 1;
        }
    }
    
    public boolean isHave() {
        return haveGiveaway;
    }
    
    public Menu getGivewayPrize() {
        return GIVEAWAY_PRIZE;
    }
    
    public int getCount() {
        return count;
    }
}
