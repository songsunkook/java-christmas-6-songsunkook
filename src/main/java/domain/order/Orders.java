package domain.order;

import constant.DayOfTheWeek;
import constant.menu.MenuType;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private final List<Order> orders;
    private final int date;
    
    public Orders(List<Order> orders, int date) {
        this.orders = orders;
        this.date = date;
    }
    
    public int getDate() {
        return date;
    }
    
    public DayOfTheWeek dayOfTheWeek() {
        return DayOfTheWeek.of(date);
    }
    
    public int getAllMenuCount() {
        return orders.stream()
                .mapToInt(Order::getCount)
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
                .mapToInt(Order::getCount)
                .sum();
    }
    
    public int getOrderPrice() {
        return orders.stream()
                .mapToInt(Order::getOrderPrice)
                .sum();
    }
    
    public List<Order> getOrders() {
        return orders.stream().collect(Collectors.toUnmodifiableList());
    }
    
    public int getTotalPrice() {
        return orders.stream()
                .mapToInt(Order::getOrderPrice)
                .sum();
    }
}
