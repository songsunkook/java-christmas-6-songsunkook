package domain.discount;

import constant.DayOfTheWeek;
import constant.MenuType;
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
    
    public int getAllMenuCount() {
        return orders.stream()
                .mapToInt(Order::getOrderQuantity)
                .sum();
    }
    
    public int getAppetizerMenuCount() {
        return getMenuCount(MenuType.APPETIZER);
    }
    
    public int getMainMenuCount() {
        return getMenuCount(MenuType.MAIN);
    }
    
    public int getDessertMenuCount() {
        return getMenuCount(MenuType.DESSERT);
    }
    
    public int getDrinkMenuCount() {
        return getMenuCount(MenuType.DRINK);
    }
    
    private int getMenuCount(MenuType menuType) {
        return orders.stream()
                .filter(order -> order.getMenuType() == menuType)
                .mapToInt(Order::getOrderQuantity)
                .sum();
    }
    
    public int getOrderPrice() {
        return orders.stream()
                .mapToInt(Order::getOrderPrice)
                .sum();
    }
}
