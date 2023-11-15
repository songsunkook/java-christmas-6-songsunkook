package constant;

import domain.discount.Christmas;
import domain.discount.Discount;
import domain.discount.Special;
import domain.discount.Weekday;
import domain.discount.Weekend;
import domain.order.Orders;
import java.util.List;
import java.util.function.Function;

public enum Discounts {
    CHRISTMAS(Christmas::new, "크리스마스 디데이 할인"),
    WEEKDAY(Weekday::new, "평일 할인"),
    WEEKEND(Weekend::new, "주말 할인"),
    SPECIAL(Special::new, "특별 할인"),
    ;
    
    private final Function<Orders, Discount> function;
    private final String name;
    
    Discounts(Function<Orders, Discount> function, String name) {
        this.function = function;
        this.name = name;
    }
    
    public Function<Orders, Discount> getFunction() {
        return function;
    }
    
    public String getName() {
        return name;
    }
}
