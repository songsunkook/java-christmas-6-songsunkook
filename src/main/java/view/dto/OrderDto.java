package view.dto;

import constant.menu.Menu;

public class OrderDto {
    private final Menu menu;
    private final int count;
    
    public OrderDto(String name, int count) {
        
        this.count = count;
    }
}
