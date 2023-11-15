package constant;

import constant.message.ExceptionMessage;
import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0),
    ;
    
    private final String name;
    private final int discountAmount;
    
    Badge(String name, int discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }
    
    public static Badge from(int discountAmount) {
        for (int i = 0; i < values().length; i++) {
            if (discountAmount >= values()[i].discountAmount) {
                return values()[i];
            }
        }
        throw new IllegalStateException(ExceptionMessage.IMPOSSIBLE_DISCOUNT_AMOUNT.getCheckedExceptionMessage());
    }
    
    public String getName() {
        return name;
    }
    
    public int getRequiredDiscountAmount() {
        return discountAmount;
    }
}
