package domain.discount;

public abstract class Discount {
    protected final OrderInformation orderInformation;
    
    Discount(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    abstract int discountAmount();
    
    protected boolean isDiscountable() {
        if (orderInformation.getOrderPrice() < 10000) {
            return false;
        }
        if (orderInformation.getDrinkMenuCount() == orderInformation.getAllMenuCount()) {
            return false;
        }
        return true;
    }
}
