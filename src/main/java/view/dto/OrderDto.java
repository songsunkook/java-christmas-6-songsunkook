package view.dto;

import constant.menu.Menu;

public class OrderDto {
    private final Menu menu;
    private final int count;
    
    public OrderDto(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }
    
    public OrderDto(String name, int count) {
        menu = Menu.of(name);
        this.count = count;
    }
    
    public String getMenuName() {
        return menu.getName();
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public int getCount() {
        return count;
    }
    
    @Override
    public String toString() {
        return menu.getName() + " " + count + "개";
    }
}
