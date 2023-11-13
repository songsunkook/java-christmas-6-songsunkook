package domain.discount;

public class Christmas implements Discountable {
    private static final int CHRISTMAS_DATE = 25;
    private static final int MIN_DISCOUNT_AMOUNT = 1000;
    private static final int DISCOUNT_AMOUNT_PER_DAY = 100;
    
    private final OrderInformation orderInformation;
    
    public Christmas(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        int date = orderInformation.getDate();
        if (date <= CHRISTMAS_DATE) {
            return MIN_DISCOUNT_AMOUNT + DISCOUNT_AMOUNT_PER_DAY * (date - 1);
        }
        return 0;
    }
}
