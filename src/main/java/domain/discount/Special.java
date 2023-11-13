package domain.discount;

public class Special implements Discountable {
    private final OrderInformation orderInformation;
    
    public Special(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        return 0;
    }
}
