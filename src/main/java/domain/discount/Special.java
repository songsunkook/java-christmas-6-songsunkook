package domain.discount;

public class Special extends Discount {

    public Special(OrderInformation orderInformation) {
        super(orderInformation);
    }
    
    @Override
    protected int discountAmount() {
        if (isDiscountable()) {
            return 0;
        }
        return 0;
    }
}
