package domain.discount;

import constant.DayOfTheWeek;
import java.util.List;

public class Weekend extends Discount {
    private static final int DISCOUNT_AMOUNT = 2023;
    private static final List<DayOfTheWeek> VALID_DAY_OF_THE_WEEK =
            List.of(
                    DayOfTheWeek.FRIDAY,
                    DayOfTheWeek.SATURDAY
            );
    
    public Weekend(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return orderInformation.getMainMenuCount() * DISCOUNT_AMOUNT;
        }
        return 0;
    }
    
    @Override
    protected boolean isDiscountable() {
        if (validateDayOfTheWeek()) {
            return super.isDiscountable();
        }
        return false;
    }
    
    private boolean validateDayOfTheWeek() {
        return VALID_DAY_OF_THE_WEEK.contains(orderInformation.dayOfTheWeek());
    }
}
