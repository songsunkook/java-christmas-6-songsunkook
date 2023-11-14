package domain.discount;

import domain.order.OrderInformation;

public class Christmas extends Discount {
    
    private static final int CHRISTMAS_DATE = 25;
    private static final int MIN_DISCOUNT_AMOUNT = 1000;
    private static final int DISCOUNT_AMOUNT_PER_DAY = 100;
    
    Christmas(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return MIN_DISCOUNT_AMOUNT + DISCOUNT_AMOUNT_PER_DAY * (orderInformation.getDate() - 1);
        }
        return 0;
    }
    
    @Override
    protected boolean isDiscountable() {
        if (orderInformation.getDate() <= CHRISTMAS_DATE) {
            return super.isDiscountable();
        }
        return false;
    }
}
