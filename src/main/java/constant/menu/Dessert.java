package constant.menu;

public enum Dessert implements Menu {
    CHOCOLATE_CAKE(15000),
    ICE_CREAM(5000),
    ;
    
    private final int price;
    
    Dessert(int price) {
        this.price = price;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
    
    @Override
    public MenuType getType() {
        return MenuType.DESSERT;
    }
}
