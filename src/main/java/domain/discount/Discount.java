package domain.discount;

import domain.order.Orders;

public abstract class Discount {
    protected final Orders orders;
    
    Discount(Orders orders) {
        this.orders = orders;
    }
    
    abstract int discountAmount();
    
    protected boolean isDiscountable() {
        if (orders.getOrderPrice() < 10_000) {
            return false;
        }
        if (orders.getDrinkMenuCount() == orders.getAllMenuCount()) {
            return false;
        }
        return true;
    }
}
