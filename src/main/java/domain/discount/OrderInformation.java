package domain.discount;

import domain.Order;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class OrderInformation {
    private final int date;
    private final List<Order> orders;
    
    public OrderInformation(int date, List<Order> orders) {
        this.date = date;
        this.orders = orders;
    }
    
    public int getDate() {
        return date;
    }
    
    public int dessertMenuCount() {
        return 0;
    }
    
    public int mainMenuCount() {
        return 0;
    }
}
