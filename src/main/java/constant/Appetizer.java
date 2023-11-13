package constant;

public enum Appetizer implements Menu {
    BUTTON_MUSHROOM_SOUP(6000),
    TAPAS(5500),
    CAESAR_SALAD(8000),
    ;
    
    private final int price;
    
    Appetizer(int price) {
        this.price = price;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
    
    @Override
    public MenuType getType() {
        return MenuType.APPETIZER;
    }
}
