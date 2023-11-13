package domain.discount;

import constant.DayOfTheWeek;
import domain.Order;
import java.util.List;

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
    
    public DayOfTheWeek dayOfTheWeek() {
        return DayOfTheWeek.of(date);
    }
    
    public int dessertMenuCount() {
        return 0;
    }
    
    public int mainMenuCount() {
        return 0;
    }
}
