package domain.discount;

import constant.DayOfTheWeek;
import java.util.List;

public class Weekday implements Discountable {
    
    private static final int DISCOUNT_AMOUNT = 2023;
    private static final List<DayOfTheWeek> VALID_DAY_OF_THE_WEEK =
            List.of(
                    DayOfTheWeek.SUNDAY,
                    DayOfTheWeek.MONDAY,
                    DayOfTheWeek.TUESDAY,
                    DayOfTheWeek.WEDNESDAY,
                    DayOfTheWeek.THURSDAY
            );
    
    private final OrderInformation orderInformation;
    
    public Weekday(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        if (orderInformation.getDessertMenuCount() > 0 && validateDayOfTheWeek()) {
            return orderInformation.getDessertMenuCount() * DISCOUNT_AMOUNT;
        }
        return 0;
    }
    
    private boolean validateDayOfTheWeek() {
        return VALID_DAY_OF_THE_WEEK.contains(orderInformation.dayOfTheWeek());
    }
}
