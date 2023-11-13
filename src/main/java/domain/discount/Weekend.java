package domain.discount;

public class Weekend implements Discountable {
    private final OrderInformation orderInformation;
    
    public Weekend(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        return 0;
    }
}
