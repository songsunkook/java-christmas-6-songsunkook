package domain.order;


import constant.menu.Menu;
import constant.menu.MenuType;

public class Order {
    private final Menu menu;
    private final int orderQuantity;
    
    public Order(Menu menu, int orderQuantity) {
        this.menu = menu;
        this.orderQuantity = orderQuantity;
    }
    
    public MenuType getMenuType() {
        return menu.getType();
    }
    
    public int getOrderQuantity() {
        return orderQuantity;
    }
    
    public int getOrderPrice() {
        return menu.getPrice() * orderQuantity;
    }
}
