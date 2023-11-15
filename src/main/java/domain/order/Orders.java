package domain.order;

import constant.DayOfTheWeek;
import constant.menu.MenuType;
import constant.message.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import view.dto.OrderDto;

public class Orders {
    
    private static final int ORDER_MAXIMUM_COUNT = 20;
    private final List<Order> orders;
    private final int date;
    
    public Orders(List<Order> orders, int date) {
        validateOrders(orders);
        this.orders = orders;
        this.date = date;
    }
    
    private void validateOrders(List<Order> orders) {
        validateOverMaximumCount(orders);
        validateDuplicateOrder(orders);
        validateJustOrderDrinks(orders);
    }
    
    private static void validateOverMaximumCount(List<Order> orders) {
        int orderCount = (int) orders.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (orderCount > ORDER_MAXIMUM_COUNT) {
            throw new IllegalArgumentException(
                    ExceptionMessage.MENU_ORDER_MAXIMUM_EXCEEDED.get(ORDER_MAXIMUM_COUNT)
            );
        }
    }
    
    private void validateDuplicateOrder(List<Order> menus) {
        int initialLength = menus.size();
        int laterLength = (int) menus.stream()
                .map(Order::getMenuName)
                .distinct()
                .count();
        if (initialLength != laterLength) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.get());
        }
    }
    
    private void validateJustOrderDrinks(List<Order> orders) {
        int orderCount = (int) orders.stream()
                .mapToInt(Order::getCount)
                .sum();
        int drinkMenuCount = (int) orders.stream()
                .filter(order -> order.getMenuType().equals(MenuType.DRINK))
                .mapToInt(Order::getCount)
                .sum();
        if (orderCount == drinkMenuCount) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_DRINKS_CANNOT_BE_ORDERED.get());
        }
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
