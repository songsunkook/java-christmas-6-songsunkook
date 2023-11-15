package domain.discount;

import constant.Discounts;
import domain.order.Orders;

public abstract class Discount {
    protected final Orders orders;
    
    Discount(Orders orders) {
        this.orders = orders;
    }
    
    public abstract int discountAmount();
    
    public boolean isDiscountable() {
        if (orders.getOrderPrice() < 10_000) {
            return false;
        }
        if (orders.getDrinkMenuCount() == orders.getAllMenuCount()) {
            return false;
        }
        return true;
    }
    
    public abstract Discounts getType();
    
    public String getName() {
        return getType().getName();
    }
}
