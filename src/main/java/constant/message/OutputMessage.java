package constant.message;

public enum OutputMessage {
    START_EVENT_PLANNER("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    INPUT_DATE_OF_VISIT("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_MENU_INFORMATION("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW_EVENT_BENEFITS("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_HEADER("<주문 메뉴>"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_HEADER("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU_HEADER("<증정 메뉴>"),
    BENEFIT_DETAILS_HEADER("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT_HEADER("<총혜택 금액>"),
    AMOUNT_AFTER_DISCOUNT_HEADER("<할인 후 예상 결제 금액>"),
    EVENT_BADGE_HEADER("<%d월 이벤트 배지>"),
    GIVEAWAY_EVENT("증정 이벤트"),
    ;
    
    private static final int EVENT_MONTH = 12;
    
    private final String message;
    
    OutputMessage(String message) {
        this.message = message;
    }
    
    public String get() {
        if (message.contains("%d")) {
            return String.format(message, EVENT_MONTH);
        }
        return message;
    }
    
    public String get(int date) {
        if (message.equals(PREVIEW_EVENT_BENEFITS.message)) {
            return String.format(message, EVENT_MONTH, date);
        }
        return message;
    }
}
