package domain.discount;

public class Christmas implements Discountable {
    private static final int CHRISTMAS_DATE = 25;
    private static final int MAX_DISCOUNT_AMOUNT = 1000 + 100 * (CHRISTMAS_DATE - 1);
    
    private final OrderInformation orderInformation;
    
    public Christmas(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        return 0;
    }
}
