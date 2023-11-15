package domain.discount;

import constant.Discounts;
import domain.order.Orders;

public class Christmas extends Discount {
    
    private static final int CHRISTMAS_DATE = 25;
    private static final int MIN_DISCOUNT_AMOUNT = 1000;
    private static final int DISCOUNT_AMOUNT_PER_DAY = 100;
    
    public Christmas(Orders orders) {
        super(orders);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return MIN_DISCOUNT_AMOUNT + DISCOUNT_AMOUNT_PER_DAY * (orders.getDate() - 1);
        }
        return 0;
    }
    
    @Override
    public boolean isDiscountable() {
        if (orders.getDate() <= CHRISTMAS_DATE) {
            return super.isDiscountable();
        }
        return false;
    }
    
    @Override
    public Discounts getType() {
        return Discounts.CHRISTMAS;
    }
}
