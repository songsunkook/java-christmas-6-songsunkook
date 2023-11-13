package domain.discount;

import constant.DayOfTheWeek;
import java.util.List;

public class Weekday extends Discount {
    private static final int DISCOUNT_AMOUNT = 2023;
    private static final List<DayOfTheWeek> VALID_DAY_OF_THE_WEEK =
            List.of(
                    DayOfTheWeek.SUNDAY,
                    DayOfTheWeek.MONDAY,
                    DayOfTheWeek.TUESDAY,
                    DayOfTheWeek.WEDNESDAY,
                    DayOfTheWeek.THURSDAY
            );
    
    public Weekday(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return orderInformation.getDessertMenuCount() * DISCOUNT_AMOUNT;
        }
        return 0;
    }
    
    @Override
    protected boolean isDiscountable() {
        if (orderInformation.getDessertMenuCount() > 0 && validateDayOfTheWeek()) {
            return super.isDiscountable();
        }
        return false;
    }
    
    private boolean validateDayOfTheWeek() {
        return VALID_DAY_OF_THE_WEEK.contains(orderInformation.dayOfTheWeek());
    }
}
