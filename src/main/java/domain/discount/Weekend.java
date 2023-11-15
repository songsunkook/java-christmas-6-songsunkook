package domain.discount;

import constant.DayOfTheWeek;
import constant.Discounts;
import domain.order.Orders;
import java.util.List;

public class Weekend extends Discount {
    private static final int DISCOUNT_AMOUNT = 2_023;
    private static final List<DayOfTheWeek> VALID_DAY_OF_THE_WEEK =
            List.of(
                    DayOfTheWeek.FRIDAY,
                    DayOfTheWeek.SATURDAY
            );
    
    public Weekend(Orders orders) {
        super(orders);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return orders.getMainMenuCount() * DISCOUNT_AMOUNT;
        }
        return 0;
    }
    
    @Override
    public boolean isDiscountable() {
        if (validateDayOfTheWeek()) {
            return super.isDiscountable();
        }
        return false;
    }
    
    private boolean validateDayOfTheWeek() {
        return VALID_DAY_OF_THE_WEEK.contains(orders.dayOfTheWeek());
    }
    
    @Override
    public Discounts getType() {
        return Discounts.WEEKEND;
    }
}
