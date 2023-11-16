package constant.message;

public enum ExceptionMessage {
    MENU_ORDER_MAXIMUM_EXCEEDED("메뉴는 한 번에 최대 %d개까지만 주문할 수 있습니다."),
    ONLY_DRINKS_CANNOT_BE_ORDERED("음료만 주문할 수 없습니다."),
    INVALID_DATE("유효하지 않은 날짜입니다."),
    INVALID_ORDER("유효하지 않은 주문입니다."),
    IMPOSSIBLE_DISCOUNT_AMOUNT("불가능한 할인 금액이 전달되었습니다."),
    ;
    
    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해 주세요.";
    private final String message;
    
    ExceptionMessage(String message) {
        this.message = message;
    }
    
    public String get() {
        return PREFIX + message + POSTFIX;
    }
    
    public String get(int args) {
        return PREFIX + String.format(message, args) + POSTFIX;
    }
    
    public String getCheckedExceptionMessage() {
        return PREFIX + message;
    }
}
