package domain;

import constant.Badge;

public class EventBadge {
    private final Badge badge;
    
    public EventBadge(int discountAmount) {
        badge = Badge.from(discountAmount);
    }
    
    public Badge getBadge() {
        return badge;
    }
    
    private boolean isEmpty() {
        return badge == Badge.NONE;
    }
}
