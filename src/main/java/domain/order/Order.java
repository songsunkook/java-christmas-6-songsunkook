package domain.order;


import constant.menu.Menu;
import constant.menu.MenuType;

public class Order {
    private final Menu menu;
    private final int count;
    
    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }
    
    public MenuType getMenuType() {
        return menu.getMenuType();
    }
    
    public int getOrderPrice() {
        return menu.getPrice() * count;
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public String getMenuName() {
        return menu.getName();
    }
    
    public int getCount() {
        return count;
    }
}
