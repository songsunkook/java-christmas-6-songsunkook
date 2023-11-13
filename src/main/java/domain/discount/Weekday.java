package domain.discount;

public class Weekday implements Discountable {
    private final OrderInformation orderInformation;
    
    public Weekday(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    @Override
    public int discountAmount() {
        return 0;
    }
}
