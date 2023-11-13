package domain.discount;

public class Weekend extends Discount {
    
    public Weekend(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    public int discountAmount() {
        if (isDiscountable()) {
            return 0;
        }
        return 0;
    }
}
