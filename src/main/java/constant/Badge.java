package constant;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    ;
    
    private final String name;
    private final int discountAmount;
    
    Badge(String name, int discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }
    
    public static Badge of(int discountAmount) {
        for (int i = values().length - 1; i >= 0; i--) {
            if (discountAmount >= values()[i].discountAmount) {
                return values()[i];
            }
        }
        throw new RuntimeException("[ERROR]불가능한 할인 금액 전달");
    }
    
    public String getName() {
        return name;
    }
    
    public int getRequiredDiscountAmount() {
        return discountAmount;
    }
}
