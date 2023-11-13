package constant;

public enum Main implements Menu {
    T_BONE_STEAK(55000),
    BARBECUE_RIBS(54000),
    SEAFOOD_PASTA(35000),
    CHRISTMAS_PASTA(25000),
    ;
    
    private final int price;
    
    Main(int price) {
        this.price = price;
    }
    
    @Override
    public int getPrice() {
        return price;
    }
    
    @Override
    public MenuType getType() {
        return MenuType.MAIN;
    }
}
