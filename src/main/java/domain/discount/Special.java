package domain.discount;

import domain.order.OrderInformation;
import java.util.List;

public class Special extends Discount {
    private static final List<Integer> STAR_DAY = List.of(3, 10, 17, 24, 25, 31);

    public Special(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    protected int discountAmount() {
        if (isDiscountable()) {
            return 1000;
        }
        return 0;
    }
    
    @Override
    protected boolean isDiscountable() {
        if (STAR_DAY.contains(orderInformation.getDate())) {
            return super.isDiscountable();
        }
        return false;
    }
}
