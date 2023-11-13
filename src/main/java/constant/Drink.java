package constant;

public enum Drink implements Menu {
    ZERO_COLA(3_000),
    RED_WINE(60_000),
    CHAMPAGNE(25_000),
    ;
    
    private final int price;
    
    Drink(int price) {
        this.price = price;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
    
    @Override
    public MenuType getType() {
        return MenuType.DRINK;
    }
}
