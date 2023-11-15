package constant.message;

public enum OutputMessage {
    START_EVENT_PLANNER("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n"),
    INPUT_DATE_OF_VISIT("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n"),
    INPUT_MENU_INFORMATION("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n"),
    PREVIEW_EVENT_BENEFITS("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENU_HEADER("\n<주문 메뉴>\n"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT_HEADER("\n<할인 전 총주문 금액>\n"),
    GIVEAWAY_MENU_HEADER("\n<증정 메뉴>\n"),
    BENEFIT_DETAILS_HEADER("\n<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT_HEADER("\n<총혜택 금액>\n"),
    AMOUNT_AFTER_DISCOUNT_HEADER("\n<할인 후 예상 결제 금액>\n"),
    EVENT_BADGE_HEADER("\n<%d월 이벤트 배지>\n"),
    
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
