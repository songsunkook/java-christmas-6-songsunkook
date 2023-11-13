package constant;

public enum Badge {
    NONE(0),
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000),
    ;
    
    private final int discountAmount;
    
    Badge(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    public static Badge of(int discountAmount) {
        for (int i = values().length - 1; i >= 0; i--) {
            if (discountAmount >= values()[i].discountAmount) {
                return values()[i];
            }
        }
        return null;
    }
    
    public int getRequiredDiscountAmount() {
        return discountAmount;
    }
}
